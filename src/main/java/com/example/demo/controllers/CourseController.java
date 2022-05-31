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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController extends RootController {
    @Autowired
    private CourseRepository courseRepository;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping({"/courselist"})
    public String courselist(Model model) {
        Iterable<Course> allcourses = courseRepository.findByWorkshop(false);
        Iterable<Course> allworkshops = courseRepository.findByWorkshop(true);
        model.addAttribute("courses", allcourses);
        model.addAttribute("workshops", allworkshops);
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
    @GetMapping("/coursedelete/{id}")
    public String courseDelete(Model model) {
        model.addAttribute("courses", courseRepository.findAll());



        return "coursedelete";
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
        return "redirect:/courselist/" + id;
    }

    @GetMapping("/editcourse/{id}")
    public String editcourse(Model model, @PathVariable int id){
        logger.info("editcourse "+id);
        Optional<Course> courseFromDb = courseRepository.findById(id);
        if (courseFromDb.isPresent()) {
            model.addAttribute("course", courseFromDb.get());
        }
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
        logger.info("editcoursePost " + id + " -- new workshop? " + course.getWorkshop());
        courseRepository.save(course);
        return "redirect:/coursedetails/" + id;
    }
    @GetMapping({"/coursedetails/{id}/prev"})
    public String coursedetailsPrev(Model model, @PathVariable int id) {
        Optional<Course> prevCourseFromDb = courseRepository.findFirstByIdLessThanOrderByIdDesc(id);
        if (prevCourseFromDb.isPresent())
            return String.format("redirect:/coursedetails/%d", prevCourseFromDb.get().getId());
        Optional<Course> lastCourseFromDb = courseRepository.findFirstByOrderByIdDesc();
        if (lastCourseFromDb.isPresent())
            return String.format("redirect:/coursedetails/%d", lastCourseFromDb.get().getId());
        return "coursedetails";
    }

    @GetMapping({"/coursedetails/{id}/next"})
    public String receptdetailsNext(Model model, @PathVariable int id) {
        Optional<Course> nextCourseFromDb = courseRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
        if (nextCourseFromDb.isPresent())
            return String.format("redirect:/coursedetails/%d", nextCourseFromDb.get().getId());
        Optional<Course> firstCourseFromDb = courseRepository.findFirstByOrderByIdAsc();
        if (firstCourseFromDb.isPresent())
            return String.format("redirect:/coursedetails/%d", firstCourseFromDb.get().getId());
        return "coursedetails";
    }
    @GetMapping("/newcourse")
    public String newcourse(Model model) {
        logger.info("newcourse ");
        model.addAttribute("course", new Course());
        return "admin/newcourse";
    }
    @PostMapping("/newcourse")
    public String newCoursePost(Model model, @ModelAttribute("course") Course course) {
        logger.info("newCoursePost -- new name=" + course.getName() +", teacher=" +course.getTeacher()+ ", short description=" + course.getShortdescription() +", description=" +course.getDescription()+", location= "+course.getLocation()+", workshop? "+course.getWorkshop());
        Course newCourse = courseRepository.save(course);
        return "redirect:/coursedetails/" + newCourse.getId();
    }
    @GetMapping("/courselist/category/{filter}")
    public String courselistCategory(Model model, @PathVariable String filter) {
        List<Course> allcourses = courseRepository.findByCategory(filter);
        List<Course> filteredworkshops = new ArrayList<>();
        List<Course> filteredcourses = new ArrayList<>();
        for (var course : allcourses){
            if(course.getWorkshop()){
                filteredworkshops.add(course);
            }
            else{
                filteredcourses.add(course);
            }
        }
            model.addAttribute("workshops", filteredworkshops);
            model.addAttribute("courses", filteredcourses);
        return "courselist";
    }
}
