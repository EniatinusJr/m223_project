package ch.zli.m223.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean wholeday;

    @Column(nullable = false)
    private Long bookingnumber;

    @Column(nullable = true)
    private String note;

    @Column(nullable = false)
    private String status;

    @Column(nullable = true)
    private LocalDateTime starttime;

    @Column(nullable = true)
    private LocalDateTime endtime;

    @ManyToOne
    public MeetingRoom meetingroom;

    @ManyToOne
    public User user;

    @ManyToMany
    @JoinTable(name = "booking_equipments", joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    @JsonIgnoreProperties("bookings")
    @Fetch(FetchMode.JOIN)
    private Set<Equipment> equipments;

}
