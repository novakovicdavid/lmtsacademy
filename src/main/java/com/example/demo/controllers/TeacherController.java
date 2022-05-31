package com.example.demo.controllers;

import com.example.demo.model.Teacher;
import com.example.demo.repositories.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@Controller
public class TeacherController extends RootController{
    @Autowired
    private TeacherRepository teacherRepository;
    private final Logger logger = LoggerFactory.getLogger(TeacherController.class);
    @GetMapping({"/teacherdetails/{id}", "/teacherdetails"})

    public String teacherdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "teacherdetails";
        Optional<Teacher> teacherFromDb = teacherRepository.findById(id);
        teacherFromDb.ifPresent(teacher -> model.addAttribute("teacher", teacher));
        return "teacherdetails";
    }
}
