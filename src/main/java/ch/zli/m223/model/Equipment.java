package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @ManyToMany(mappedBy = "equipments")
    @JsonIgnoreProperties("equipments")
    @Fetch(FetchMode.JOIN)
    private Set<Booking> bookingss;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Booking> getBookingss() {
        return bookingss;
    }

    public void setBookingss(Set<Booking> bookingss) {
        this.bookingss = bookingss;
    }

    

}
