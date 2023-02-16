package com.jetrouter.gymservice.repository;

import com.jetrouter.gymservice.entity.Plan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlansRepository extends CrudRepository<Plan, Long> {
    List<Plan> findAllByType(String type);
}
