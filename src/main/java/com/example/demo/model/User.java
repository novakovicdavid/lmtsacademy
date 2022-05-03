package com.example.demo.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", initialValue = 0, allocationSize = 1)
    @GeneratedValue(generator = "user_seq")
    private Integer id;
    private String email;
    private String password;
    private String role;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Profile profile;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
