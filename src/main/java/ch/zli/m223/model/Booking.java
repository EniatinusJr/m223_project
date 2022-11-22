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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    private Set<Equipment> equipments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isWholeday() {
        return wholeday;
    }

    public void setWholeday(boolean wholeday) {
        this.wholeday = wholeday;
    }

    public Long getBookingnumber() {
        return bookingnumber;
    }

    public void setBookingnumber(Long bookingnumber) {
        this.bookingnumber = bookingnumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    public MeetingRoom getMeetingroom() {
        return meetingroom;
    }

    public void setMeetingroom(MeetingRoom meetingroom) {
        this.meetingroom = meetingroom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

    

}
