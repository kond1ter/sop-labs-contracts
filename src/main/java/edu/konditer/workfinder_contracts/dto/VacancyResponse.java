package edu.konditer.workfinder_contracts.dto;

import java.time.LocalDateTime;

public record VacancyResponse(String title, String text, String contactPhoneNumber, Double salary,
                              LocalDateTime createdAt,
                              String authorFullName) {
}
