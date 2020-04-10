package com.github.stebeg.tool.cv.person;

import com.github.stebeg.tool.cv.ComicvineEntity;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the basic information of a creator of a comic book issue retrieved from the Comicvine
 * API.
 *
 * @author Steffen Berger
 */
public class SimplePersonWithRole extends SimplePerson implements ComicvineEntity {

  private static final String ROLE_ATTRIBUTE_NAME = "role";

  @SerializedName(value = ROLE_ATTRIBUTE_NAME)
  private final String role;

  /**
   * Creates a new representation of the basic information of a creator of a comic book issue
   * retrieved from the Comicvine API.
   *
   * @param id   The unique ID of the creator.
   * @param name The name of the creator.
   * @param role The role of the creator (e.g. writer, cover artist, ...)
   */
  public SimplePersonWithRole(long id, String name, String role) {
    super(id, name);
    this.role = role;
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
    final SimplePersonWithRole simplePersonWithRole = (SimplePersonWithRole) obj;
    return getId() == simplePersonWithRole.getId()
        && Objects.equal(this.getName(), simplePersonWithRole.getName())
        && Objects.equal(this.role, simplePersonWithRole.getRole());
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.role);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", this.getId())
        .add("name", this.getName())
        .add("role", this.role)
        .toString();
  }
}
