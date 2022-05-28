package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Event {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_generator")

    @SequenceGenerator(name = "event_generator", sequenceName = "event_seq", allocationSize = 1)

    private Integer id;

    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime finish;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;


    public Event() {
        super();

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                ", employee=" + employee +
                ", profile=" + profile +
                '}';
    }
}

