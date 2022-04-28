package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Profile {
    @Id
    @SequenceGenerator(name = "profile_seq", sequenceName = "PROFILE_SEQ", initialValue = 0, allocationSize = 1)
    @GeneratedValue(generator = "profile_seq")
    private Integer id;
    private String name;
    private String bio;
    private String photo_path;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Profile() {
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

    public String getPathOfProfilePicture() {
        return photo_path;
    }

    public void setPathOfProfilePicture(String photo_path) {
        this.photo_path = photo_path;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
