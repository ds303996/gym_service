package com.jetrouter.gymservice.dto;

import lombok.Builder;

@Builder
public record InstructorDetails(String name, String surname, String description, String imageURL) {
}
