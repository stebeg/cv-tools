package com.github.stebeg.tool.cv.team;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Represents the basic information of a comic team from Comicvine.
 *
 * @author Steffen Berger
 */
public class SimpleTeam {

    static final String ID_ATTRIBUTE_NAME = "id";
    static final String NAME_ATTRIBUTE_NAME = "name";

    @SerializedName(value = ID_ATTRIBUTE_NAME)
    private final long id;

    @SerializedName(value = NAME_ATTRIBUTE_NAME)
    private final String name;

    /**
     * Creates a new representation of the basic information of a comic team from Comicvine.
     *
     * @param id   The team's unique ID.
     * @param name The team's name.
     */
    public SimpleTeam(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return The team's unique ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * @return The team's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Team{"
            + "id=" + this.id + ", "
            + "name='" + this.name + "'}";
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
        final SimpleTeam simpleTeam = (SimpleTeam) o;
        return getId() == simpleTeam.getId()
            && Objects.equals(this.name, simpleTeam.getName());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getClass().getName(), this.id, this.name);
    }
}
