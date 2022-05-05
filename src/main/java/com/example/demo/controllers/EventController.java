package com.example.demo.controllers;

import com.example.demo.model.Event;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController extends RootController {
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/eventlist")
    public String eventList(Model model) {
        Iterable<Event> eventlist = eventRepository.findAll();
        model.addAttribute("eventlist", eventlist);

        return "eventlist";

    }



}