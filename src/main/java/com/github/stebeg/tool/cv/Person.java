package com.github.stebeg.tool.cv;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Represents information of a creator of a comic book issue retrieved from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class Person {

    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String NAME_ATTRIBUTE_NAME = "name";
    private static final String ROLE_ATTRIBUTE_NAME = "role";

    @SerializedName(value = ID_ATTRIBUTE_NAME)
    private final long id;

    @SerializedName(value = NAME_ATTRIBUTE_NAME)
    private final String name;

    @SerializedName(value = ROLE_ATTRIBUTE_NAME)
    private final String role;

    /**
     * Creates a new representation of a creator of a comic book issue retrieved from the Comicvine
     * API.
     *
     * @param id   The unique ID of the creator.
     * @param name The name of the creator.
     * @param role The role of the creator (e.g. writer, cover artist, ...)
     */
    Person(long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    /**
     * @return The unique ID of the creator.
     */
    public long getId() {
        return this.id;
    }

    /**
     * @return The name of the creator.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return The role(s) of the creator (e.g. writer, cover artist, ...). If a creator has multiple
     * roles in creating an issue, the roles are separated by comma.
     */
    public String getRole() {
        return this.role;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Person{"
            + "id=" + this.id + ", "
            + "name='" + this.name + "'" + ", "
            + "role='" + this.role + "'}";
    }

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Person person = (Person) o;
        return getId() == person.getId()
            && Objects.equals(this.name, person.getName())
            && Objects.equals(this.role, person.getRole());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getClass().getName(), this.id, this.name, this.role);
    }
}
