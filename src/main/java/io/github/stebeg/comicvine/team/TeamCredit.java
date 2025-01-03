package io.github.stebeg.comicvine.team;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.common.ComicvineEntity;

/**
 * Represents the reference of a team.
 */
public class TeamCredit implements ComicvineEntity {

  @SerializedName(value = TeamAttribute.ID)
  private final long id;

  @SerializedName(value = TeamAttribute.NAME)
  private final String name;

  /**
   * Creates a new representation of the reference of a team.
   *
   * @param id   The team's unique ID.
   * @param name The team's name.
   */
  public TeamCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Returns the team's unique ID.
   *
   * @return The team's unique ID.
   */
  @Override
  public long getId() {
    return this.id;
  }

  /**
   * Returns the team's name.
   *
   * @return The team's name.
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
    if (!(obj instanceof TeamCredit that)) {
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
