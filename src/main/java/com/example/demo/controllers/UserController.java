package com.example.demo.controllers;

import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.regex.Pattern;

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
    private final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"); // OWASP

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
    public String register(Principal principal) {
        if(principal != null) return "redirect:/";
        return "user/register";
    }

    @PostMapping({"/user/register"})
    public String registerPost(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String experience,
            Principal principal, RedirectAttributes redirectAttributes) {
        if (email.equals("")
                || !emailPattern.matcher(email).matches()
                || userRepository.findByEmail(email).isPresent()
                || firstName.equals("")
                || lastName.equals("")
                || password.equals("")
                || principal != null) {
            redirectAttributes.addAttribute("error", true);
            return "redirect:/user/register";
        }
        email = email.toLowerCase();
        User newUser = new User();
        newUser.setEmail(email);
        String hashedPassword = passwordEncoder.encode(password);
        newUser.setPassword(hashedPassword);
        newUser.setRole("USER");
        newUser.setEnabled(true);
        User user = userRepository.save(newUser);

        Profile newProfile = new Profile();
        newProfile.setUser(user);
        newProfile.setFirstName(firstName);
        newProfile.setLastName(lastName);
        newProfile.setExperience(experience);
        newProfile.setNew(true);
        newProfile.setHasDismissedCompleteProfileNotification(false);
        profileRepository.save(newProfile);

        autologin(email, password);
        return "redirect:/user/register/confirmation";
    }

    @GetMapping({"/user/register/confirmation"})
    public String confirmationRegistration() {
        return "user/registration_confirmation";
    }
    private void autologin(String email, String password) {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(email, password);
        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
