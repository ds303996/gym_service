package com.jetrouter.gymservice.service.impl;

import com.jetrouter.gymservice.dto.Plan;
import com.jetrouter.gymservice.dto.PlanDetails;
import com.jetrouter.gymservice.repository.PlansRepository;
import com.jetrouter.gymservice.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlansRepository plansRepository;

    @Override
    public List<Plan> getPlans(String type) {
        var plans = plansRepository.findAllByType(type);
        return plans.stream().map(plan -> Plan.builder()
                        .id(plan.getId())
                        .name(plan.getName())
                        .description(plan.getDescription())
                        .build())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanDetails> getPlanDetails(long id) {
        var plan = plansRepository.findById(id).orElseThrow();
        if (plan.getType().equals("T")) {
            return plan.getExercises().stream().map(exercise -> new PlanDetails(exercise.getName(), exercise.getDescription())).toList();
        } else {
            return plan.getMeals().stream().map(meal -> new PlanDetails(meal.getName(), meal.getDescription())).toList();
        }
    }
}
