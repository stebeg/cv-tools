package com.github.stebeg.tool.cv.volume;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

public class SimpleVolume {

  static final String ID_ATTRIBUTE_NAME = "id";
  static final String NAME_ATTRIBUTE_NAME = "name";

  @SerializedName(value = ID_ATTRIBUTE_NAME)
  private final long id;

  @SerializedName(value = NAME_ATTRIBUTE_NAME)
  private final String name;

  /**
   * Creates a new simplified representation of a comic volume retrieved from the Comicvine API.
   *
   * @param id   The unique ID of the series/volume.
   * @param name The name of the series/volume.
   */
  SimpleVolume(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return The unique ID of the series/volume.
   */
  public long getId() {
    return this.id;
  }

  /**
   * @return The name of the series/volume.
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
    final SimpleVolume that = (SimpleVolume) obj;
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
