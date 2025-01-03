package io.github.stebeg.comicvine.volume;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.issue.IssueCredit;

import java.util.List;

/**
 * Represents detailed information of a comic volume from Comicvine.
 */
public class Volume extends VolumeListItem {

  @SerializedName(value = VolumeAttribute.ISSUES)
  private List<IssueCredit> issueList;

  /**
   * Creates a new representation of detailed information of a comic volume from Comicvine.
   *
   * @param id   The volume's unique ID.
   * @param name The volume's name.
   */
  Volume(long id, String name) {
    super(id, name);
  }

  /**
   * Returns the list of issues of the volume.
   *
   * @return The list of issues of the volume.
   */
  public List<IssueCredit> getIssueList() {
    return this.issueList;
  }

  /**
   * Sets the list of issues of the volume.
   *
   * @param issueList The list of issues of the volume.
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
    if (!(obj instanceof Volume)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final Volume volume = (Volume) obj;
    return Objects.equal(issueList, volume.issueList);
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
        .add("publisher", this.getPublisher())
        .add("image", this.getImage())
        .add("issueCount", this.getIssueCount())
        .add("startYear", this.getStartYear())
        .add("firstIssue", this.getFirstIssue())
        .add("lastIssue", this.getLastIssue())
        .add("issueList", this.issueList)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
