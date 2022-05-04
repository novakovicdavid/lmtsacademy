package com.example.demo.controllers;


import com.example.demo.model.Event;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/eventnew")
    public String eventNew(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("eventlist", eventRepository.findAll());
        return "admin/eventnew";

    }

    @PostMapping("/eventnew")
    public String eventNewPost(@ModelAttribute("event") Event event) {

        Event newEvent = eventRepository.save(event);
        return "redirect:/calendar";
    }
}
