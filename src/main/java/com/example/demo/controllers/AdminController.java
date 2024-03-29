package com.example.demo.controllers;


import com.example.demo.model.Course;
import com.example.demo.model.Event;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.ProfileRepository;
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
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/calendar")
    public String eventNew(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("eventlist", eventRepository.findAll());
        model.addAttribute("profiles", profileRepository.findAll());

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
    public String eventEdit(Model model) {
        model.addAttribute("profiles", profileRepository.findAll());



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
    @ModelAttribute("course")
    public Course findCourse(@PathVariable(required = false) Integer id) {

        if (id == null) return new Course();
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElse(null);
    }
    @GetMapping("/eventdelete/{id}")
    public String eventDelete(Model model) {
        model.addAttribute("profiles", profileRepository.findAll());



        return "admin/eventdelete";
    }

    @PostMapping("/eventdelete/{id}")
    public String eventDelete(Model model,
                                @PathVariable int id,
                                @ModelAttribute("event") Event event) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event editedEvent = optionalEvent.get();

            eventRepository.delete(event);
            model.addAttribute("event", editedEvent);

        }


       return "redirect:/eventlist";
    }
    @GetMapping("/coursedelete/{id}")
    public String courseDelete(Model model) {
        model.addAttribute("courses", courseRepository.findAll());



        return "admin/coursedelete";
    }

    @PostMapping("/coursedelete/{id}")
    public String eventDelete(Model model,
                              @PathVariable int id,
                              @ModelAttribute("course") Course course) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course editedCourse = optionalCourse.get();
            courseRepository.delete(course);
            model.addAttribute("course", editedCourse);

        }
        return "redirect:/home";
    }
}
