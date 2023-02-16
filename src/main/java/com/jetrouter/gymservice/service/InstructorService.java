package com.jetrouter.gymservice.service;

import com.jetrouter.gymservice.dto.InstructorDetails;

import java.util.List;

public interface InstructorService {
    void createInstructor(InstructorDetails instructorDetails);

    List<InstructorDetails> getAllInstructors();
}
