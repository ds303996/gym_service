package com.jetrouter.gymservice.dto;

import lombok.Builder;

@Builder
public record Plan(long id, String name, String description) {
}
