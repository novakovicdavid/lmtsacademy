package com.example.demo.controllers;

import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping({"/user/login"})
    public String login(Principal principal) {
        if (principal != null) return "redirect:/";
        return "user/login";
    }

    @GetMapping({"/user/logout"})
    public String logout(Principal principal) {
        if (principal == null) return "redirect:/";
        return "user/logout";
    }

    @GetMapping({"/user/register"})
    public String register() {
        return "user/register";
    }

    @PostMapping({"/user/register"})
    public String registerPost(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String city,
            @RequestParam String province,
            @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date birthday,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String experience,
            Principal principal) {
        if (username.equals("")
                || !username.matches("^[a-zA-Z0-9]*$")
                || userRepository.findByUsername(username).isPresent()
                || firstName.equals("")
                || lastName.equals("")
                || city.equals("")
                || province.equals("")
                || email.equals("")
                || phoneNumber.equals("")
                || experience.equals("")
                || principal != null) {
            return "user/register";
        }
        username = username.toLowerCase();
        User newUser = new User();
        newUser.setUsername(username);
        String hashedPassword = passwordEncoder.encode(password);
        newUser.setPassword(hashedPassword);
        newUser.setRole("USER");
        User user = userRepository.save(newUser);

        Profile newProfile = new Profile();
        newProfile.setUser(user);
        newProfile.setFirstName(firstName);
        newProfile.setLastName(lastName);
        newProfile.setCity(city);
        newProfile.setProvince(province);
        newProfile.setBirthday(birthday);
        newProfile.setEmail(email);
        newProfile.setPhoneNumber(phoneNumber);
        newProfile.setExperience(experience);
        profileRepository.save(newProfile);

        autologin(username, password);
        return "redirect:/user/registration/confirmation";
    }

    @GetMapping({"/user/registration/confirmation"})
    public String confirmationRegistration() {
        return "user/registration_confirmation";
    }

    private void autologin(String userName, String password) {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(userName, password);
        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
