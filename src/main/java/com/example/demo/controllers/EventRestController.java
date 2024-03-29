package com.example.demo.controllers;

import com.example.demo.model.Employee;
import com.example.demo.model.Event;
import com.example.demo.model.Profile;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventRestController extends RootController {

    @Autowired
    private EventRepository eventRespository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProfileRepository profileRepository;


    @RequestMapping(value="/events", method= RequestMethod.GET)
    public Iterable<Event> events() {
        return eventRespository.findAll();
    }
    public Iterable<Employee> employees() {
        return employeeRepository.findAll();
    }
    public Iterable<Profile> profiles() {
        return profileRepository.findAll();
    }






}
