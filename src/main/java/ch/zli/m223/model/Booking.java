package ch.zli.m223.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean wholeDay;

    @Column(nullable = false)
    private Long bookingnumber;

    @Column(nullable = true)
    private String note;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    public User user;
}
