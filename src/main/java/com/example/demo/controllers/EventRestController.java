package com.example.demo.controllers;

import com.example.demo.model.Event;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventRestController extends RootController {

    @Autowired
    private EventRepository eventRespository;


    @RequestMapping(value="/events", method= RequestMethod.GET)
    public Iterable<Event> events() {
        return eventRespository.findAll();
    }




}
