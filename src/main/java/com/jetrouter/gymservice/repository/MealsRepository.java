package com.jetrouter.gymservice.repository;

import com.jetrouter.gymservice.entity.Meal;
import org.springframework.data.repository.CrudRepository;

public interface MealsRepository extends CrudRepository<Meal, Long> {
}
