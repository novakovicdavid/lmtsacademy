package com.example.demo.controllers;

import com.example.demo.model.Afspraak;
import com.example.demo.repositories.AfspraakRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class afspraakController {
    private final Logger logger = LoggerFactory.getLogger(afspraakController.class);

    @Autowired
    private AfspraakRepository afspraakRepository;

    @GetMapping("/afspraken")
    public String afsprakenLijst(Model model) {
        Iterable<Afspraak> afspraken = afspraakRepository.findAll();
        model.addAttribute("afspraken", afspraken);

        return "afspraken";

    }
}
