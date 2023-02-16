package com.jetrouter.gymservice.controller;

import com.jetrouter.gymservice.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/profile")
    public ResponseEntity<byte[]> getProfileImage(Principal principal) {
        var bytes = profileService.getImage(principal.getName());

        if (bytes != null) {
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(Base64.encodeBase64(bytes, false));
        } else {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).build();
        }
    }

    @PutMapping("/profile")
    public void updateProfileImage(@RequestParam MultipartFile image, Principal principal) throws Exception {
        profileService.updateImage(image.getBytes(), principal.getName());
    }
}
