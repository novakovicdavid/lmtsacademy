package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Course {
    @Id
    @SequenceGenerator(name = "course_seq", sequenceName = "COURSE_SEQ", initialValue = 0, allocationSize = 1)
    @GeneratedValue(generator = "course_seq")
    private Integer id;
    private String name;
    //private String teacher;
    @Column(length = 1500)
    private String description;
    @Column(length = 500)
    private String shortdescription;
    private String location;
    private Boolean workshop;
    @ManyToMany(mappedBy = "courses")
    private Collection<Teacher> teacher;
    public Course() {

    }

    public Course(Integer id, String name,Boolean workshop, String location, String description,String shortDescription,Collection<Teacher> teacher) {
        this.id = id;
        this.name = name;
        this.workshop = workshop;
        this.location = location;
        this.shortdescription = shortDescription;
        this.description = description;
        this.teacher = teacher;

    }
    public Collection<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(Collection<Teacher> teacher) {
        this.teacher = teacher;
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



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
