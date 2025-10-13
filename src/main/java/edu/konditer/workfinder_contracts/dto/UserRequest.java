package edu.konditer.workfinder_contracts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(@NotBlank(message = "Имя не может быть пустым") String firstName,
                          @NotBlank(message = "Фамилия не может быть пустой") String lastName,
                          @NotNull String[] featuredJobs) {
}
