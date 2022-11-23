package ch.zli.m223.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.eclipse.microprofile.jwt.Claims;

import ch.zli.m223.model.User;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {
    @Inject
    private EntityManager entityManager;
    
    public String generateToken() {
        String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn("jdoe@quarkus.io") 
             .groups(new HashSet<>(Arrays.asList("User", "Admin"))) 
             .claim(Claims.birthdate.name(), "2001-07-13") 
           .sign();
        return token;
    }

    @Transactional
    public boolean userExists(String email, String password) {
        boolean doesExist = false;
        var entities = entityManager.createQuery("FROM User", User.class);
        List<User> users = entities.getResultList();
        for(User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                doesExist = true;
            }
        }
        return doesExist;
    }

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }
}
