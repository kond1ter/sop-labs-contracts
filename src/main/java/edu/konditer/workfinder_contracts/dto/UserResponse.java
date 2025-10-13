package edu.konditer.workfinder_contracts.dto;

public record UserResponse(Long id, String firstName, String lastName, String[] featuredJobs,
                           VacancyResponse[] createdVacancies) {
}
