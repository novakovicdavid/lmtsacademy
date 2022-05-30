package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfilesFilter {
    String email;
    String firstName;
    String lastName;
    String isNew;
    String hideDisabled;
}
