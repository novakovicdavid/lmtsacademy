package com.example.demo.controllers;

import com.example.demo.model.Afspraak;
import com.example.demo.repositories.AfspraakRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class afspraakController extends RootController {
    private final Logger logger = LoggerFactory.getLogger(afspraakController.class);

    @Autowired
    private AfspraakRepository afspraakRepository;

    @GetMapping("/afspraken")
    public String afsprakenLijst(Model model) {
        Iterable<Afspraak> afspraken = afspraakRepository.findAll();
        model.addAttribute("afspraken", afspraken);

        return "afspraken";

    }

    @GetMapping("/afspraaknew")
    public String afspraakNew(Model model) {
        model.addAttribute("afspraak", new Afspraak());
        model.addAttribute("afspraken", afspraakRepository.findAll());
        return "afspraaknew";

    }

    @PostMapping("/afspraaknew")
    public String afspraakNewPost(@ModelAttribute("afspraak") Afspraak afspraak) {

        Afspraak newAfspraak = afspraakRepository.save(afspraak);
        return "redirect:/afspraken";
    }

    @RequestMapping(value="/calendar", method= RequestMethod.GET)
    public ModelAndView calendar() {
        ModelAndView modelAndView = new ModelAndView("calendar");
        return modelAndView;
    }
}
