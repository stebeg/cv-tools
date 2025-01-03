package io.github.stebeg.comicvine.publisher;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.common.ComicvineEntity;

/**
 * Represents the reference of a publisher.
 */
public class PublisherCredit implements ComicvineEntity {

  @SerializedName(value = PublisherAttribute.ID)
  private final long id;

  @SerializedName(value = PublisherAttribute.NAME)
  private final String name;

  /**
   * Creates a new representation of the reference of a publisher.
   *
   * @param id   The publisher's unique ID.
   * @param name The publisher's name.
   */
  public PublisherCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Returns the publisher's unique ID.
   *
   * @return The publisher's unique ID.
   */
  @Override
  public long getId() {
    return this.id;
  }

  /**
   * Returns the publisher's name.
   *
   * @return The publisher's name.
   */
  @Override
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
    if (!(obj instanceof PublisherCredit that)) {
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
