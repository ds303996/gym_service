package com.jetrouter.gymservice.service.impl;

import com.jetrouter.gymservice.dto.InstructorDetails;
import com.jetrouter.gymservice.entity.Instructor;
import com.jetrouter.gymservice.exception.InstructorExistsException;
import com.jetrouter.gymservice.repository.InstructorsRepository;
import com.jetrouter.gymservice.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorsRepository instructorsRepository;

    @Override
    public void createInstructor(InstructorDetails instructorDetails) {
        instructorsRepository.findAllByNameAndSurname(instructorDetails.name(), instructorDetails.surname()).ifPresent(user -> {
            throw new InstructorExistsException();
        });
        instructorsRepository.save(
                Instructor.builder()
                        .name(instructorDetails.name())
                        .surname(instructorDetails.surname())
                        .description(instructorDetails.description())
                        .imageURL(instructorDetails.imageURL())
                        .build()
        );
    }

    @Override
    public List<InstructorDetails> getAllInstructors() {
        return Streamable.of(
                        instructorsRepository.findAll()).toList().stream().map(
                        instructor -> InstructorDetails.builder()
                                .name(instructor.getName())
                                .surname(instructor.getSurname())
                                .imageURL(instructor.getImageURL())
                                .description(instructor.getDescription())
                                .build())
                .toList();
    }
}
