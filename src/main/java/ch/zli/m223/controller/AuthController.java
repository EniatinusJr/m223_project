package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthService;

@Path("/auth")
public class AuthController {
    
    @Inject
    AuthService authService;
    
    @POST
    @Path("/login/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index user", description = "Returns a JWT if login successful.")
    public String authlogin(@PathParam("email") String username, @PathParam("password") String password) {
        if(authService.userExists(username, password) == true){
            return authService.generateToken();
        }else{
            return null;
        }
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new User.", description = "Creates a new User and returns the newly added booking.")
    public User create(User user) {
       return authService.createUser(user);
    }

}
