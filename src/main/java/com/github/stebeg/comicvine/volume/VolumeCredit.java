package com.github.stebeg.comicvine.volume;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the reference of a volume.
 */
public class VolumeCredit {

  @SerializedName(value = VolumeAttribute.ID)
  private final long id;

  @SerializedName(value = VolumeAttribute.NAME)
  private final String name;

  /**
   * Creates a new representation of the reference of a volume.
   *
   * @param id   The volume's unique ID.
   * @param name The volume's name.
   */
  public VolumeCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Returns the volume's unique ID.
   *
   * @return The volume's unique ID.
   */
  public long getId() {
    return this.id;
  }

  /**
   * Returns the volume's name.
   *
   * @return The volume's name.
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
    if (!(obj instanceof VolumeCredit that)) {
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
