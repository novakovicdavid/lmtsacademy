package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class ProfileDTO {
    private String firstName;
    private String lastName;
    private String city;
    private String province;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private String phoneNumber;
    private String experience;
}
