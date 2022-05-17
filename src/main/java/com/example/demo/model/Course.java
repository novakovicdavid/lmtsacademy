package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @SequenceGenerator(name = "course_seq", sequenceName = "COURSE_SEQ", initialValue = 0, allocationSize = 1)
    @GeneratedValue(generator = "course_seq")
    private Integer id;
    private String name;
    private String teacher;
    @Column(length = 800)
    private String description;
    @Column(length = 500)
    private String shortdescription;
    private String location;
    private Boolean workshop;
    public Course() {

    }

    public Course(Integer id, String name,Boolean workshop, String location, String teacher, String description,String shortDescription) {
        this.id = id;
        this.name = name;
        this.workshop = workshop;
        this.teacher = teacher;
        this.location = location;
        this.shortdescription = shortDescription;
        this.description = description;

    }

    public Boolean getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Boolean workshop) {
        this.workshop = workshop;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
