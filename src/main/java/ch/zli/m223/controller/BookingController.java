package ch.zli.m223.controller;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@Tag(name = "Bookings", description = "Handling of bookings")
@RolesAllowed({"Mitglied", "Administrator"})
public class BookingController {
    
    @Inject
    BookingService bookingService;
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index Booking.", description = "Returns a booking.")
    public Booking getBooking(@PathParam("id") int id) {
        return bookingService.getBooking(id);
    }

    @DELETE
    @Path("/cancel/{id}")
    @Operation(summary = "Deletes one booking.", description = "Deletes one booking.")
    public void cancel(@PathParam("id") int id) {
        bookingService.cancelBooking(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new booking.", description = "Creates a new booking and returns the newly added booking.")
    public Booking create(Booking booking) {
       return bookingService.createBooking(booking);
    }

}
