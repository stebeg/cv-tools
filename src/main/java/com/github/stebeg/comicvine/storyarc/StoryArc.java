package com.github.stebeg.comicvine.storyarc;

import com.github.stebeg.comicvine.issue.IssueCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents detailed information of a comic story arc from Comicvine.
 */
public class StoryArc extends StoryArcListItem {

  @SerializedName(value = StoryArcAttribute.ISSUES)
  private List<IssueCredit> issueList;

  /**
   * Creates a new representation of detailed information of a comic story arc from Comicvine.
   *
   * @param id   The story arc's unique ID.
   * @param name The story arc's name.
   */
  StoryArc(long id, String name) {
    super(id, name);
  }

  /**
   * Returns the list of references to the issues of this story arc.
   *
   * @return The list of references to the issues of this story arc.
   */
  public List<IssueCredit> getIssueList() {
    return this.issueList;
  }

  /**
   * Sets the list of references to the issues of this story arc.
   *
   * @param issueList The list of references to the issues of this story arc.
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
    if (!(obj instanceof StoryArc)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final StoryArc storyArc = (StoryArc) obj;
    return Objects.equal(issueList, storyArc.issueList);
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
        .add("issueList", this.issueList)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }

}
