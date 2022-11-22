package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
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

}
