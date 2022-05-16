package com.example.demo.controllers;

import com.example.demo.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminProfileController {
    @Autowired
    ProfileRepository profileRepository;
    @GetMapping({"/profiles/{page}"})
    public String getMembersAtPage(@PathVariable Integer page,
                             Model model) {
        var profiles = profileRepository.findAll(PageRequest.of(page, 20, Sort.by("id").descending()));
        model.addAttribute("profiles", profiles.iterator());
        return "admin/profiles";
    }

    @GetMapping({"/profiles"})
    public String getMembers() {
        return "redirect:/admin/profiles/0";
    }
}
