package com.github.stebeg.comicvine.character;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the origin of a character. Human, Alien, Robot ...etc.
 *
 * @author Steffen Berger
 */
public class CharacterOrigin {

  @SerializedName(value = CharacterAttribute.ORIGIN_ID)
  private final long id;

  @SerializedName(value = CharacterAttribute.ORIGIN_NAME)
  private final String name;

  /**
   * Creates a new representation of the origin of a character. Human, Alien, Robot ...etc.
   *
   * @param id   The ID of the origin.
   * @param name The name of the origin.
   */
  CharacterOrigin(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return The ID of the origin.
   */
  public long getId() {
    return this.id;
  }

  /**
   * @return The name of the origin. Human, Alien, Robot ...etc.
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
    if (!(obj instanceof CharacterOrigin that)) {
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
