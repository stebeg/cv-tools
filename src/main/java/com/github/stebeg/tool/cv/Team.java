package com.github.stebeg.tool.cv;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Represents comic team information from Comicvine.
 * 
 * @author Steffen Berger
 */
public class Team {

    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String NAME_ATTRIBUTE_NAME = "name";

    @SerializedName(value = ID_ATTRIBUTE_NAME)
    private final long id;

    @SerializedName(value = NAME_ATTRIBUTE_NAME)
    private final String name;

    /**
     * Creates a new representation of comic team information from Comicvine.
     *
     * @param id The team's unique ID.
     * @param name The team's name.
     */
    Team(long id, String name) {
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
        final Team team = (Team) o;
        return getId() == team.getId()
                && Objects.equals(this.name, team.getName());
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
