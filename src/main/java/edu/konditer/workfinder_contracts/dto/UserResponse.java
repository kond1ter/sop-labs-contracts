package edu.konditer.workfinder_contracts.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Relation(collectionRelation = "users", itemRelation = "user")
public class UserResponse extends RepresentationModel<UserResponse> {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final List<String> featuredJobs;

    public UserResponse(Long id, String firstName, String lastName, List<String> featuredJobs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.featuredJobs = featuredJobs;
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

    public List<String> getFeaturedJobs() {
        return featuredJobs;
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
                && Arrays.equals(featuredJobs.toArray(), that.featuredJobs.toArray());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                id,
                firstName,
                lastName,
                Arrays.hashCode(featuredJobs.toArray())
        );
    }
}
