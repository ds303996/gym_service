package com.jetrouter.gymservice.controller;

import com.jetrouter.gymservice.dto.InstructorDetails;
import com.jetrouter.gymservice.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping("/instructors")
    public void createInstructor(@RequestBody InstructorDetails instructorDetails) {
        instructorService.createInstructor(instructorDetails);
    }

    @GetMapping("/instructors")
    public List<InstructorDetails> getInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/dummy")
    @PreAuthorize("@securityService.hasAdminAccess(principal.id)")
    public String test(Principal principal) {
        return principal.getName();
    }


}
