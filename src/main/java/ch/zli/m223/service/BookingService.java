package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    
    @Inject
    private EntityManager entityManager;

    public Booking getBooking(int id) {
        var query = entityManager.createQuery("FROM Booking b WHERE b.id=:id", Booking.class).setParameter("id", id);
        return query.getSingleResult();
    }

}
