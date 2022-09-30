package com.example.demo.controllers;


import com.example.demo.dtos.ProfileDTO;
import com.example.demo.model.User;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;


@Controller
public class ProfileController extends RootController {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping({"/profile"})
    public String profile(Model model, Principal principal) {
        var user = userRepository.findByEmail(principal.getName());
        System.out.println(principal.getName());
        if (user.isEmpty()) return null;
        var profile = user.get().getProfile();
        if (profile == null) return null;
        model.addAttribute("profile", profile);
        return "profile";
    }

    @GetMapping({"/profile/edit"})
    public String profileEdit(Model model, Principal principal) {
        Optional<User> userFromDb = userRepository.findByEmail(principal.getName());
        if (userFromDb.isEmpty()) return null;
        var profile = userFromDb.get().getProfile();
        if (profile == null) return null;
        model.addAttribute("profile", profile);

        return "editprofile";
    }

    @PostMapping("/profile/edit")
    public String profileEditPost(Principal principal, ProfileDTO editedProfile) {
        var userOptional = userRepository.findByEmail(principal.getName());
        if (userOptional.isEmpty()) return null;
        var user = userOptional.get();
        var profile = user.getProfile();
        logger.info("editprofile: " + profile.getId() + " -- new name= " + editedProfile.getFirstName());
        modelMapper.map(editedProfile, profile);

        var profilePicture = editedProfile.getProfilePicture();
        if(editedProfile.getProfilePicture() != null) {
            try {
                String path = uploadProfilePicture(profilePicture);
                profile.setPathToProfilePicture(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        profileRepository.save(profile);
        return "redirect:/profile";
    }
}
