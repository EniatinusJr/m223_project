package ch.zli.m223.controller;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.User;
import ch.zli.m223.service.AdminService;

@Path("/admin")
@Tag(name = "Admin", description = "Handling of all requests from admins")
public class AdminController {

    @Inject
    AdminService adminService;

    @GET
    @Path("/bookings/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Bookings from certain date.", description = "Returns a list of all bookings from a certain date.")
    public List<Booking> index(@PathParam("date") LocalDate date) {
        return adminService.findAll(date);
    }

    @DELETE
    @Path("/booking/{id}")
    @Operation(summary = "Deletes one booking.", description = "Deletes one booking.")
    public void cancel(@PathParam("id") int id) {
        adminService.deleteBooking(id);
    }

    @PUT
    @Path("/member/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates one Entry", description = "Updates one Entry")
    public User update(User user) {
        return adminService.updateUser(user);
    }

}
