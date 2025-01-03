package io.github.stebeg.comicvine.location;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.issue.IssueCredit;

import java.util.List;

/**
 * Represents detailed information of a comic location from Comicvine.
 */
public class Location extends LocationListItem {

  @SerializedName(value = LocationAttribute.ISSUES)
  private List<IssueCredit> issueList;

  /**
   * Creates a new representation of detailed information of a comic location from Comicvine.
   *
   * @param id   The location's unique ID.
   * @param name The location's name.
   */
  Location(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a list of references to issues the location appeared in.
   *
   * @return A list of references to issues the location appeared in.
   */
  public List<IssueCredit> getIssueList() {
    return this.issueList;
  }

  /**
   * Sets the list of references to issues the location appeared in.
   *
   * @param issueList The list of references to issues the location appeared in.
   */
  public void setIssueList(List<IssueCredit> issueList) {
    this.issueList = issueList;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Location)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final Location location = (Location) obj;
    return Objects.equal(issueList, location.issueList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.issueList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", this.getId())
        .add("name", this.getName())
        .add("summary", this.getSummary())
        .add("description", this.getDescription())
        .add("aliases", this.getAliases())
        .add("image", this.getImage())
        .add("startYear", this.getStartYear())
        .add("issueList", this.issueList)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
