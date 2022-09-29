package com.example.demo.controllers;

import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.contentSources.B2ContentSource;
import com.backblaze.b2.client.contentSources.B2ContentTypes;
import com.backblaze.b2.client.contentSources.B2FileContentSource;
import com.backblaze.b2.client.structures.B2UploadFileRequest;
import com.example.demo.B2MultiPartContentSource;
import com.example.demo.repositories.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.security.Principal;
import java.util.UUID;

@Controller
public class RootController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private B2StorageClient webStorageClient;

    @ModelAttribute("show_notification")
    public Boolean insertCompleteProfileNotificationInModel(Model model, Principal principal) {
        if (principal == null) return null;
        var user = userRepository.findByEmail(principal.getName());
        if (user.isEmpty()) return null;
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

    String uploadProfilePicture(Integer profileId, MultipartFile profilePicture) throws Exception {
        processProfilePicture(profilePicture);
        UUID uuid = UUID.randomUUID();

//        var path = String.format("profiles/%1$s/%2$s", profileId, uuid);
//        s3Client.putObject("lmtsbucketaj3jxiz2omvn6sidqaozmr", path, profilePicture.getInputStream(), new ObjectMetadata());
        webStorageClient.uploadSmallFile(B2UploadFileRequest.builder("9fd50648ed75132c7dce041e", uuid.toString(), B2ContentTypes.B2_AUTO, new B2MultiPartContentSource(profilePicture)).build());
        return uuid.toString();
    }

    private void processProfilePicture(MultipartFile profilePicture) throws Exception {
        if (profilePicture.getSize() > 5000000)
            throw new Exception("Uploaded profile picture is too large (" + (profilePicture.getSize() / 1000000.0) + "MB)");
        if (ImageIO.read(profilePicture.getInputStream()) == null)
            throw new Exception("Uploaded profile picture is invalid");

    }
}
