package com.jetrouter.gymservice.controller;

import com.jetrouter.gymservice.dto.Plan;
import com.jetrouter.gymservice.dto.PlanDetails;
import com.jetrouter.gymservice.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping(value = "/plans")
    public List<Plan> getPlans(@RequestParam String type) {
        return planService.getPlans(type);
    }

    @GetMapping(value = "/plans/{id}")
    public List<PlanDetails> getPlanDetails(@PathVariable long id) {
        return planService.getPlanDetails(id);
    }
}
