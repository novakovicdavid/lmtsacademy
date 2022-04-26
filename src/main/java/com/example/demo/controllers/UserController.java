package com.example.demo.controllers;

import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public String registerPost(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String name,
                           @RequestParam String bio,
                           Principal principal) {
        if (username.equals("")
                || !username.matches("^[a-zA-Z0-9]*$")
                || userRepository.findByUsername(username).isPresent()
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
        newProfile.setName(name);
        newProfile.setBio(bio);
        newProfile.setUser(user);
        profileRepository.save(newProfile);
        return "redirect:/";
    }
}
