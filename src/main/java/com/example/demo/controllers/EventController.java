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
        Iterable<Event> eventList = eventRepository.findAll();
        Iterable<Employee> employees = employeeRepository.findAll();
        long nrOfEvents = eventRepository.count();

        model.addAttribute("eventList", eventList);
        model.addAttribute("employees", employees);
        model.addAttribute("nrOfEvents", nrOfEvents);
        model.addAttribute("showFilters", false);


        return "eventlist";

    }


    @GetMapping({"/eventlist/filter"})
    public String eventlistWithFilterFilter(Model model,
                                            @RequestParam(required = false) LocalDateTime start,
                                            @RequestParam(required = false) LocalDateTime finish,
                                            @RequestParam(required = false) Integer employeeId
                                            ) {
        List<Event> eventList;


//        if (start == null || finish == null)
//            eventList = (List<Event>) eventRepository.findAll();
//        else
            eventList = eventRepository.findByFilter(employeeId, start, finish);

        model.addAttribute("eventList", eventList.iterator());

        model.addAttribute("nrOfEvents", eventList.size());
        model.addAttribute("showFilters", true);
        model.addAttribute("start", start);
        model.addAttribute("finish", finish);
        model.addAttribute("employeeId", employeeId);




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


