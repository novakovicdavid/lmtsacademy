package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfilesFilter {
    String email;
    String firstName;
    String lastName;
    String isNew;
}
