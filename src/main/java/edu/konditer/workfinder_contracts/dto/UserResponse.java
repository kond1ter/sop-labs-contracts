package edu.konditer.workfinder_contracts.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Arrays;
import java.util.Objects;

@Relation(collectionRelation = "users", itemRelation = "user")
public class UserResponse extends RepresentationModel<UserResponse> {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String[] featuredJobs;
    private final VacancyResponse[] createdVacancies;

    public UserResponse(Long id, String firstName, String lastName, String[] featuredJobs, VacancyResponse[] createdVacancies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.featuredJobs = featuredJobs;
        this.createdVacancies = createdVacancies;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String[] getFeaturedJobs() {
        return featuredJobs;
    }

    public VacancyResponse[] getCreatedVacancies() {
        return createdVacancies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserResponse that = (UserResponse) o;
        return Objects.equals(id, that.id)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Arrays.equals(featuredJobs, that.featuredJobs)
                && Arrays.equals(createdVacancies, that.createdVacancies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                id,
                firstName,
                lastName,
                Arrays.hashCode(featuredJobs),
                Arrays.hashCode(createdVacancies)
        );
    }
}
