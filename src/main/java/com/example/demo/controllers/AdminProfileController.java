package com.example.demo.controllers;

import com.example.demo.dtos.ProfileDTO;
import com.example.demo.dtos.ProfilesFilter;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminProfileController {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping({"/profiles/{page}"})
    public String getMembersAtPage(@PathVariable Integer page,
                             Model model) {
        var profiles = profileRepository.findAll(PageRequest.of(page, 20, Sort.by("id").descending()));
        model.addAttribute("profiles", profiles.iterator());
        model.addAttribute("page", page);
        model.addAttribute("nextPageHasContent", (profiles.getTotalPages() - (page + 1)) != 0);
        return "admin/profiles";
    }

    @GetMapping({"/profiles"})
    public String getMembers() {
        return "redirect:/admin/profiles/0";
    }

    @GetMapping({"/profiles/filter/{page}"})
    public String getMembersAtPageFilter(@PathVariable Integer page,
                                         ProfilesFilter filter,
                                         Model model) {
        if(filter.getIsNew() != null && filter.getIsNew().equals("null")) filter.setIsNew(null);
        var profiles = profileRepository.findAllByFilter(PageRequest.of(page, 20, Sort.by("id").descending()), filter.getFirstName(), filter.getLastName(), filter.getEmail(), filter.getIsNew() != null);
        model.addAttribute("profiles", profiles);
        model.addAttribute("page", page);
        model.addAttribute("nextPageHasContent", (profiles.getTotalPages() - (page + 1)) != 0);
        model.addAttribute("filter", filter);
        return "admin/profiles";
    }

    @GetMapping({"/profile/{id}"})
    public String getProfileWithId(@PathVariable Integer id,
                                   Model model) {
        var profile = profileRepository.findById(id);
        if (profile.isEmpty()) return "profile";
        model.addAttribute("profile", profile.get());
        return "profile";
    }

    @GetMapping({"/profile/{id}/edit"})
    public String editProfileWithId(@PathVariable Integer id,
                                    Model model) {
        var profile = profileRepository.findById(id);
        if (profile.isEmpty()) return "profile";
        model.addAttribute("profile", profile.get());
        model.addAttribute("editedByAdmin", true);
        return "editprofile";
    }

    @PostMapping("/profile/{id}/edit")
    public String myProfilePost(@PathVariable Integer id,
                                ProfileDTO editedProfile) {
        var profileOpt = profileRepository.findById(id);
        if (profileOpt.isEmpty()) return "profile";
        var profile = profileOpt.get();
        modelMapper.map(editedProfile, profile);
        profileRepository.save(profile);
        return "redirect:/admin/profile/{id}";
    }
}
