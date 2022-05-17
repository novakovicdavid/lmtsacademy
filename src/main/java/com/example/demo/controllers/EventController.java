package com.example.demo.controllers;

import com.example.demo.model.Employee;
import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class EventController extends RootController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/eventlist")
    public String eventList(Model model) {
        Iterable<Event> eventlist = eventRepository.findAll();
        Iterable<Employee> employees = employeeRepository.findAll();
        long nrOfEvents = eventRepository.count();

        model.addAttribute("eventlist", eventlist);
        model.addAttribute("employees", employees);
        model.addAttribute("nrOfEvents", nrOfEvents);



        return "eventlist";

    }

    @GetMapping({"/eventlist/filter"})
    public String eventlistWithFilterFilter(Model model,
                                            @RequestParam(required = false)LocalDateTime start,
                                            @RequestParam(required = false)LocalDateTime finish) {
        List<Event> events = eventRepository.findByFilter(start, finish);
        model.addAttribute("events", events);
        model.addAttribute("nrOfEvents", events.size());


        return "eventlist";
    }
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


