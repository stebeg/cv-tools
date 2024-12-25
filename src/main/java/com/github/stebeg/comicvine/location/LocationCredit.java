package com.github.stebeg.comicvine.location;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the reference of a location.
 */
public class LocationCredit {

  @SerializedName(value = LocationAttribute.ID)
  private final long id;

  @SerializedName(value = LocationAttribute.NAME)
  private final String name;

  /**
   * Creates a new representation of the reference of a location.
   *
   * @param id   The location's unique ID.
   * @param name The location's name.
   */
  public LocationCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Returns the location's unique ID.
   *
   * @return The location's unique ID.
   */
  public long getId() {
    return this.id;
  }

  /**
   * Returns the location's name.
   *
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
    if (!(obj instanceof LocationCredit that)) {
      return false;
    }
    return this.id == that.id
        && Objects.equal(this.name, that.name);
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
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
