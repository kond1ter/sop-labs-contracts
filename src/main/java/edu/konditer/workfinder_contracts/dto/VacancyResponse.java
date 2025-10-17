package edu.konditer.workfinder_contracts.dto;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Objects;

public class VacancyResponse extends RepresentationModel<VacancyResponse> {

    private final Long id;
    private final String title;
    private final String text;
    private final String jobName;
    private final String contactNumber;
    private final Double salary;
    private final LocalDateTime createdAt;
    private final String authorFullName;

    public VacancyResponse(Long id, String title, String text, String jobName, String contactNumber, Double salary, LocalDateTime createdAt, String authorFullName) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.jobName = jobName;
        this.contactNumber = contactNumber;
        this.salary = salary;
        this.createdAt = createdAt;
        this.authorFullName = authorFullName;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getJobName() {
        return jobName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VacancyResponse that = (VacancyResponse) o;
        return Objects.equals(id, that.id)
                && Objects.equals(title, that.title)
                && Objects.equals(text, that.text)
                && Objects.equals(jobName, that.jobName)
                && Objects.equals(contactNumber, that.contactNumber)
                && Objects.equals(salary, that.salary)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(authorFullName, that.authorFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                id,
                title,
                text,
                jobName,
                contactNumber,
                salary,
                createdAt,
                authorFullName
        );
    }
}
