package com.example.demo.controllers;


import com.example.demo.model.Event;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/calendar")
    public String eventNew(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("eventlist", eventRepository.findAll());
        return "admin/calendar";

    }

    @PostMapping("/calendar")
    public String eventNewPost(@ModelAttribute("event") Event event) {

        eventRepository.save(event);
        return "redirect:/admin/calendar";
    }


    @ModelAttribute("event")
    public Event findEvent(@PathVariable(required = false) Integer id) {

        if (id == null) return new Event();
        Optional<Event> optionalEvent = eventRepository.findById(id);
        return optionalEvent.orElse(null);
    }

    @GetMapping("/eventedit/{id}")
    public String eventEdit() {


        return "admin/eventedit";
    }

    @PostMapping("/eventedit/{id}")
    public String eventEditPost(Model model,
                                @PathVariable int id,
                                @ModelAttribute("event") Event event) {

        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event editedEvent = optionalEvent.get();
            editedEvent.setTitle(event.getTitle());
            editedEvent.setStart(event.getStart());
            editedEvent.setFinish(event.getFinish());
            editedEvent.setDescription(event.getDescription());
            eventRepository.save(event);

            model.addAttribute("event", editedEvent);

        }


        return "redirect:/eventlist";

    }


}
