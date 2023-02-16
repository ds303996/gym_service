package com.jetrouter.gymservice.repository;

import com.jetrouter.gymservice.entity.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExercisesRepository extends CrudRepository<Exercise, Long> {
}
