package com.example.demo.controllers;

import com.example.demo.model.Employee;
import com.example.demo.model.Event;
import com.example.demo.model.Profile;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController extends RootController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProfileRepository profileRepository;


    @GetMapping("/eventlist")
    public String eventList(Model model) {
        Iterable<Event> eventList = eventRepository.findAll();
        Iterable<Employee> employees = employeeRepository.findAll();
        Iterable<Profile> profiles = profileRepository.findAll();

        long nrOfEvents = eventRepository.count();

        model.addAttribute("eventList", eventList);
        model.addAttribute("employees", employees);
        model.addAttribute("profiles", profiles);

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


        eventList = eventRepository.findByFilter(employeeId, start, finish);

        model.addAttribute("eventList", eventList.iterator());
        model.addAttribute("profiles", profileRepository.findAll());

        model.addAttribute("nrOfEvents", eventList.size());
        model.addAttribute("showFilters", true);
        model.addAttribute("start", start);
        model.addAttribute("finish", finish);
        model.addAttribute("employeeId", employeeId);



        return "eventlist";
    }

    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public ModelAndView calendar() {
        ModelAndView modelAndView = new ModelAndView("calendar");
        return modelAndView;
    }

}


