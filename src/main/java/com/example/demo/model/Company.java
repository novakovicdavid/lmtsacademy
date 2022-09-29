package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Company {
    @Id
    @SequenceGenerator(name = "company_seq", sequenceName = "COMPANY_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "company_seq")
    private Integer id;
    private String name;
    @Column(length = 800)
    private String bio;
    private String location;
    @ManyToMany
    private Collection<Course> courses;
    public Company(){

    }

    public Company(Integer id, String name, String bio,String location,Collection<Course> courses) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.location = location;
        this.courses = courses;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
