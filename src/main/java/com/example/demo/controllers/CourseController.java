package com.example.demo.controllers;

import com.example.demo.model.Course;
import com.example.demo.repositories.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

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
        courseFromDb.ifPresent(course -> model.addAttribute("course", course));
        return "coursedetails";
    }
    @GetMapping("/editcourse/{id}")
    public String editcourse(Model model, @PathVariable int id){
        logger.info("editcourse "+id);
        Optional<Course> courseFromDb = courseRepository.findById(id);
        courseFromDb.ifPresent(course -> model.addAttribute("course", course));
        model.addAttribute("courses",courseRepository.findAll());
        return "admin/editcourse";
    }
    @PostMapping("/editcourse/{id}")
    public String editcoursePost(Model model,
                                @PathVariable int id,
                                @ModelAttribute("course") Course course) {
        logger.info("editcoursePost " + id + " -- new name= " + course.getName());
        logger.info("editcoursePost " + id + " -- new teacher= " + course.getTeacher());
        logger.info("editcoursePost " + id + " -- new short description= " + course.getShortdescription());
        logger.info("editcoursePost " + id + " -- new description= " + course.getDescription());
        logger.info("editcoursePost " + id + " -- new location= " + course.getLocation());
        courseRepository.save(course);
        return "redirect:/coursedetails/" + id;
    }
    @GetMapping("/newcourse")
    public String newcourse(Model model) {
        logger.info("newcourse ");
        model.addAttribute("course", new Course());
        return "admin/newcourse";
    }
    @PostMapping("/newcourse")
    public String newCoursePost(Model model, @ModelAttribute("course") Course course) {
        logger.info("newCoursePost -- new name=" + course.getName() +", teacher=" +course.getTeacher()+ ", short description=" + course.getShortdescription() +", description=" +course.getDescription()+", location= "+course.getLocation());
        Course newCourse = courseRepository.save(course);
        return "redirect:/coursedetails/" + newCourse.getId();
    }
}
