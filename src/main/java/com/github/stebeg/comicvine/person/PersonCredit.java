package com.github.stebeg.comicvine.person;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the reference of a person.
 */
public class PersonCredit {

  @SerializedName(value = PersonAttribute.ID)
  private final long id;

  @SerializedName(value = PersonAttribute.NAME)
  private final String name;

  /**
   * Creates a new representation of the reference of a person.
   *
   * @param id   The person's unique ID.
   * @param name The person's name.
   */
  public PersonCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Returns the person's unique ID.
   *
   * @return The person's unique ID.
   */
  public long getId() {
    return this.id;
  }

  /**
   * Returns the person's name.
   *
   * @return The person's name.
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
    if (!(obj instanceof PersonCredit that)) {
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
        .toString();
  }
}
