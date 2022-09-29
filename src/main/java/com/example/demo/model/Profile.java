package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Profile {
    @Id
    @SequenceGenerator(name = "profile_seq", sequenceName = "PROFILE_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "profile_seq")
    private Integer id;
    private String firstName;
    private String lastName;
    private String city;
    private String province;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String phoneNumber;

    @Column(length = 511)
    private String experience;
    private String pathToProfilePicture;

    // No intake interview done/planned
    private Boolean isNew;
    private Boolean hasDismissedCompleteProfileNotification;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date age) {
        this.birthday = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getHasDismissedCompleteProfileNotification() {
        return hasDismissedCompleteProfileNotification;
    }

    public void setHasDismissedCompleteProfileNotification(Boolean hasDismissedCompleteProfileNotification) {
        this.hasDismissedCompleteProfileNotification = hasDismissedCompleteProfileNotification;
    }

    public String getPathToProfilePicture() {
        return pathToProfilePicture;
    }

    public void setPathToProfilePicture(String pathToProfilePicture) {
        this.pathToProfilePicture = pathToProfilePicture;
    }
}
