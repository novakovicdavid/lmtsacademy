package com.example.demo.controllers;



import com.example.demo.model.Company;
import com.example.demo.repositories.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

    @Controller
    public class CompanyController extends RootController{
        @Autowired
        private CompanyRepository companyRepository;
        private final Logger logger = LoggerFactory.getLogger(CompanyController.class);
        @GetMapping({"/companydetails/{id}", "/companydetails"})

        public String companydetails(Model model, @PathVariable(required = false) Integer id) {
            if (id == null) return "companydetails";
            Optional<Company> companyFromDb = companyRepository.findById(id);
            if (companyFromDb.isPresent()) {
                model.addAttribute("company", companyFromDb.get());
            }
            return "companydetails";
        }
    }
