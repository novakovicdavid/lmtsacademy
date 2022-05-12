package com.example.demo.controllers;

import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class RootController {
    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("show_notification")
    public Boolean insertCompleteProfileNotificationInModel(Model model, Principal principal) {
        if (principal == null) return null;
        var user = userRepository.findByEmail(principal.getName());
        if (user.isEmpty()) return null;
        var profile = user.get().getProfile();
        if (profile == null) return null;

        if (!profile.getHasDismissedCompleteProfileNotification()) {
            if(profile.getPhoneNumber() == null
            || profile.getBirthday() == null
            || profile.getCity() == null
            || profile.getProvince() == null) {
                model.addAttribute("notification_text", "Vervolledig je profiel");
                model.addAttribute("notification_is_link", true);
                model.addAttribute("notification_link", "/myProfile");
                return true;
            }
            else {
                profile.setHasDismissedCompleteProfileNotification(true);
                return false;
            }
        }
        return false;
    }
}
