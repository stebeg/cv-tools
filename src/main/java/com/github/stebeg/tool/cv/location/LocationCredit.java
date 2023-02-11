package com.github.stebeg.tool.cv.location;

import com.github.stebeg.tool.cv.ComicvineEntity;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the basic information of a comic location from Comicvine.
 *
 * @author Steffen Berger
 */
public class LocationCredit implements ComicvineEntity {

  static final String ID_ATTRIBUTE_NAME = "id";
  static final String NAME_ATTRIBUTE_NAME = "name";

  @SerializedName(value = ID_ATTRIBUTE_NAME)
  private final long id;

  @SerializedName(value = NAME_ATTRIBUTE_NAME)
  private final String name;

  /**
   * Creates a new representation of the basic information of a comic location from Comicvine.
   *
   * @param id   The location's unique ID.
   * @param name The location's name.
   */
  public LocationCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return The location's unique ID.
   */
  public long getId() {
    return this.id;
  }

  /**
   * @return The location's name.
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
    final LocationCredit that = (LocationCredit) obj;
    return this.id == that.id &&
        Objects.equal(this.name, that.name);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(this.id, this.name);
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
