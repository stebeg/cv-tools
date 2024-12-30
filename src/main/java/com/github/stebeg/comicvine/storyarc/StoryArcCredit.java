package com.github.stebeg.comicvine.storyarc;

import com.github.stebeg.comicvine.common.ComicvineEntity;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the reference of a story arc.
 */
public class StoryArcCredit implements ComicvineEntity {

  @SerializedName(value = StoryArcAttribute.ID)
  private final long id;

  @SerializedName(value = StoryArcAttribute.NAME)
  private final String name;

  /**
   * Creates a new representation of the reference of a story arc.
   *
   * @param id   The story arc's unique ID.
   * @param name The story arc's name.
   */
  public StoryArcCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Returns the story arc's unique ID.
   *
   * @return The story arc's unique ID.
   */
  @Override
  public long getId() {
    return this.id;
  }

  /**
   * Returns the story arc's name.
   *
   * @return The story arc's name.
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
    if (!(obj instanceof StoryArcCredit that)) {
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
