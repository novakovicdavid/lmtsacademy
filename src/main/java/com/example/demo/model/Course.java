package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    private Integer id;
    private String name;
    private String teacher;
    @Column(length = 800)
    private String description;
    @Column(length = 500)
    private String shortdescription;
    public Course() {

    }

    public Course(Integer id, String name, String teacher, String description,String shortDescription) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.shortdescription = shortDescription;
        this.description = description;
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
