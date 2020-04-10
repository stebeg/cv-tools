package com.github.stebeg.tool.cv.team;

import com.google.common.base.MoreObjects;
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
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final SimpleTeam simpleTeam = (SimpleTeam) obj;
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

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", this.id)
        .add("name", this.name)
        .toString();
  }
}
