package com.example.demo.controllers;

import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;
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

    @GetMapping({"/profiles/{page}"})
    public String getMembersAtPage(@PathVariable Integer page,
                             Model model) {
        var profiles = profileRepository.findAll(PageRequest.of(page, 10, Sort.by("id").descending()));
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
                                         @RequestParam(required = false) String email,
                                         @RequestParam(required = false) String firstName,
                                         @RequestParam(required = false) String lastName,
                                         @RequestParam(required = false) Boolean isNew,
                                         Model model) {
        var profiles = profileRepository.findAllByFilter(PageRequest.of(page, 10, Sort.by("id").descending()), firstName, lastName, email, isNew);
        model.addAttribute("profiles", profiles.iterator());
        model.addAttribute("page", page);
        model.addAttribute("nextPageHasContent", (profiles.getTotalPages() - (page + 1)) != 0);
        return "admin/profiles";
    }
}
