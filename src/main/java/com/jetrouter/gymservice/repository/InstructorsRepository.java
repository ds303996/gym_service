package com.jetrouter.gymservice.repository;

import com.jetrouter.gymservice.entity.Instructor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InstructorsRepository extends CrudRepository<Instructor, Long> {
    Optional<Instructor> findAllByNameAndSurname(String name, String surname);
}
