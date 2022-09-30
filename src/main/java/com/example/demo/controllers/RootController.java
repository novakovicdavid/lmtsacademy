package com.example.demo.controllers;

import com.example.demo.IWebStorageProvider;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.security.Principal;
import java.util.UUID;

@Controller
public class RootController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Qualifier("webClientProvider")
    private IWebStorageProvider webStorageClient;

    @ModelAttribute("show_notification")
    public Boolean insertCompleteProfileNotificationInModel(Model model, Principal principal) {
        if (principal == null) return null;
        var user = userRepository.findByEmail(principal.getName());
        if (user.isEmpty()) return null;
        if (user.get().getRole().equalsIgnoreCase("admin")) return null;
        var profile = user.get().getProfile();
        if (profile == null) return null;

        if (!profile.getHasDismissedCompleteProfileNotification()) {
            if (profile.getPhoneNumber() == null
                    || profile.getBirthday() == null
                    || profile.getCity() == null
                    || profile.getProvince() == null) {
                model.addAttribute("notification_text", "Vervolledig je profiel");
                model.addAttribute("notification_is_link", true);
                model.addAttribute("notification_link", "/profile");
                return true;
            } else {
                profile.setHasDismissedCompleteProfileNotification(true);
                return false;
            }
        }
        return false;
    }

    String uploadProfilePicture(MultipartFile profilePicture) throws Exception {
        processProfilePicture(profilePicture);
        String uuid = UUID.randomUUID().toString();
        webStorageClient.upload(uuid, profilePicture.getInputStream(), profilePicture.getSize());
        return uuid;
    }

    private void processProfilePicture(MultipartFile profilePicture) throws Exception {
        if (profilePicture.getSize() > 5000000)
            throw new Exception("Uploaded profile picture is too large (" + (profilePicture.getSize() / 1000000.0) + "MB)");
        if (ImageIO.read(profilePicture.getInputStream()) == null)
            throw new Exception("Uploaded profile picture is invalid");

    }
}
