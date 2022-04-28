package com.example.demo.controllers;

import com.example.demo.model.Course;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping({"/courselist"})
    public String courselist(Model model) {
        final Iterable<Course> allcourses = courseRepository.findAll();
        model.addAttribute("courses", allcourses);
        return "courselist";
    }

    @GetMapping({"/coursedetails/{id}", "/coursedetails"})

    public String coursedetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "coursedetails";
        Optional<Course> courseFromDb = courseRepository.findById(id);
        if (courseFromDb.isPresent()) {
            model.addAttribute("course", courseFromDb.get());
        }
        return "coursedetails";
    }
}
