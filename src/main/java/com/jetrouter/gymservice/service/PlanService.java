package com.jetrouter.gymservice.service;

import com.jetrouter.gymservice.dto.Plan;
import com.jetrouter.gymservice.dto.PlanDetails;

import java.util.List;

public interface PlanService {
    List<Plan> getPlans(String type);

    List<PlanDetails> getPlanDetails(long id);
}
