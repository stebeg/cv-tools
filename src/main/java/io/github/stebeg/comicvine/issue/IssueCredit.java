package io.github.stebeg.comicvine.issue;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.common.ComicvineEntity;

/**
 * Represents the reference of an issue.
 */
public class IssueCredit implements ComicvineEntity {

  @SerializedName(value = IssueAttribute.ID)
  private final long id;

  @SerializedName(value = IssueAttribute.NAME)
  private final String name;

  /**
   * Creates a new representation of the reference of an issue.
   *
   * @param id   The issue's unique ID.
   * @param name The issue's name.
   */
  public IssueCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Returns the issue's unique ID.
   *
   * @return The issue's unique ID.
   */
  @Override
  public long getId() {
    return this.id;
  }

  /**
   * Returns the issue's name.
   *
   * @return The issue's name.
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
    if (!(obj instanceof IssueCredit that)) {
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
