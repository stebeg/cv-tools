package com.github.stebeg.tool.cv.storyarc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the basic information of a comic book story arc from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class StoryArcCredit {

  static final String ID_ATTRIBUTE_NAME = "id";
  static final String NAME_ATTRIBUTE_NAME = "name";

  @SerializedName(value = ID_ATTRIBUTE_NAME)
  private final long id;

  @SerializedName(value = NAME_ATTRIBUTE_NAME)
  private final String name;

  /**
   * Creates a new representation of the basic information of a story arc of a comic book issue retrieved from the Comicvine API.
   *
   * @param id   The unique ID of the story arc.
   * @param name The name of the story arc.
   */
  public StoryArcCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return The unique ID of the story arc.
   */
  public long getId() {
    return this.id;
  }

  /**
   * @return The name of the story arc.
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
    final StoryArcCredit that = (StoryArcCredit) obj;
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
