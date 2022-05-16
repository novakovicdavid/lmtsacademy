package com.example.demo.controllers;

import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class EventController extends RootController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/eventlist")
    public String eventList(Model model) {
        Iterable<Event> eventlist = eventRepository.findAll();
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("eventlist", eventlist);
        model.addAttribute("users", users);


        return "eventlist";

    }
//    @PostMapping("/eventlist")
//    public String eventEditPost(Model model,
//
//                                @ModelAttribute("event") Event event) {
//
//
//            event.setId(event.getId());
//            event.setTitle(event.getTitle());
//            event.setStart(event.getStart());
//            event.setFinish(event.getFinish());
//            event.setDescription(event.getDescription());
//            eventRepository.save(event);
//            model.addAttribute("event", event);
//
//        return "redirect:/home";
//
//    }
////        return "redirect:/eventdetails/" + id;

    }
