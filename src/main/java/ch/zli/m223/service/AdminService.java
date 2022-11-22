package ch.zli.m223.service;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.User;

@ApplicationScoped
public class AdminService {

    @Inject
    private EntityManager entityManager;

    public List<Booking> findAll(LocalDate date) {
        var query = entityManager.createQuery("FROM Booking b WHERE b.date=:date", Booking.class).setParameter("date", date);
        //var query = entityManager.find(Booking.class, date);
        return query.getResultList();
    }

    @Transactional
    public void deleteBooking(int id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(int id) {
        var entity = entityManager.find(User.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public Booking acceptBooking(Booking booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public Booking declineBooking(Booking booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public Booking edtBooking(Booking booking) {
        return entityManager.merge(booking);
    }
    
}
