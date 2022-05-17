package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_seq", sequenceName = "TEACHER_SEQ", initialValue = 0, allocationSize = 1)
    @GeneratedValue(generator = "teacher_seq")
    private Integer id;
    private String name;
    @Column(length = 800)
    private String bio;
    private String experience;
   @ManyToMany
    private Collection<Course> courses;
    public Teacher(){

    }
    public Teacher(Integer id, String name, String bio, String experience, Collection<Course> courses) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.experience = experience;
        this.courses = courses;
    }
    public Collection<Course> getCourses() {
        return courses;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


}
