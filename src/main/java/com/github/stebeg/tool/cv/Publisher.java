package com.github.stebeg.tool.cv;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Represents comic book publisher information from Comicvine.
 *
 * @author Steffen Berger
 */
public class Publisher {

    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String NAME_ATTRIBUTE_NAME = "name";

    @SerializedName(value = ID_ATTRIBUTE_NAME)
    private final long id;

    @SerializedName(value = NAME_ATTRIBUTE_NAME)
    private final String name;

    /**
     * Creates a new representation of comic book publisher information from Comicvine.
     *
     * @param id   The publisher's unique ID.
     * @param name The publisher's name.
     */
    Publisher(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return The publisher's unique ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * @return The publisher's name.
     */
    public String getName() {
        return this.name;
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
        final Publisher publisher = (Publisher) o;
        return this.id == publisher.getId()
            && Objects.equals(this.name, publisher.getName());
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
