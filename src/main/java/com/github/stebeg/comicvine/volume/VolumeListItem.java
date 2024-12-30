package com.github.stebeg.comicvine.volume;

import com.github.stebeg.comicvine.image.Image;
import com.github.stebeg.comicvine.issue.IssueCredit;
import com.github.stebeg.comicvine.publisher.PublisherCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a list item of a volume. This is a simplified version of the {@link Volume} class used for
 * search results and listing volumes.
 */
public class VolumeListItem extends VolumeCredit {

  @SerializedName(value = VolumeAttribute.SUMMARY)
  private String summary;

  @SerializedName(value = VolumeAttribute.DESCRIPTION)
  private String description;

  @SerializedName(value = VolumeAttribute.ALIASES)
  private String aliases;

  @SerializedName(value = VolumeAttribute.PUBLISHER)
  private PublisherCredit publisher;

  @SerializedName(value = VolumeAttribute.IMAGE)
  private Image image;

  @SerializedName(value = VolumeAttribute.ISSUE_COUNT)
  private Integer issueCount;

  @SerializedName(value = VolumeAttribute.START_YEAR)
  private String startYear;

  @SerializedName(value = VolumeAttribute.FIRST_ISSUE)
  private IssueCredit firstIssue;

  @SerializedName(value = VolumeAttribute.LAST_ISSUE)
  private IssueCredit lastIssue;

  /**
   * Creates a new representation of a list item of a comic volume.
   *
   * @param id The volume's unique ID.
   * @param name The volume's name.
   */
  public VolumeListItem(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a brief summary of the volume.
   *
   * @return Brief summary of the volume.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the volume.
   *
   * @param summary The brief summary of the volume.
   */
  void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Returns a detailed HTML-description of the volume.
   *
   * @return A detailed HTML-description of the volume.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets a detailed HTML-description of the volume.
   *
   * @param description The detailed HTML-description of the volume.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns a list of aliases the volume is known by.
   *
   * @return List of aliases the volume is known by. A \n (newline) seperates each alias.
   */
  public String getAliases() {
    return this.aliases;
  }

  /**
   * Sets the list of aliases the volume is known by.
   *
   * @param aliases The list of aliases. A \n (newline) seperates each alias.
   */
  public void setAliases(String aliases) {
    this.aliases = aliases;
  }

  /**
   * Returns the primary publisher of the volume.
   *
   * @return The primary publisher of the volume.
   */
  public PublisherCredit getPublisher() {
    return this.publisher;
  }

  /**
   * Sets the primary publisher of the volume.
   *
   * @param publisher The primary publisher of the volume.
   */
  void setPublisher(PublisherCredit publisher) {
    this.publisher = publisher;
  }

  /**
   * Returns the main image of the volume.
   *
   * @return Main image of the volume.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the volume.
   *
   * @param image The main image of the volume.
   */
  void setImage(Image image) {
    this.image = image;
  }

  /**
   * Returns the number of issues in the volume.
   *
   * @return The number of issues in the volume.
   */
  public Integer getIssueCount() {
    return this.issueCount;
  }

  /**
   * Sets the number of issues in the volume.
   *
   * @param issueCount The number of issues in the volume.
   */
  public void setIssueCount(Integer issueCount) {
    this.issueCount = issueCount;
  }

  /**
   * Returns the start year of the volume.
   *
   * @return The start year of the volume.
   */
  public String getStartYear() {
    return this.startYear;
  }

  /**
   * Sets the start year of the volume.
   *
   * @param startYear The start year of the volume.
   */
  public void setStartYear(String startYear) {
    this.startYear = startYear;
  }

  /**
   * Returns a reference to the first issue of the volume.
   *
   * @return The reference to the first issue of the volume.
   */
  public IssueCredit getFirstIssue() {
    return this.firstIssue;
  }

  /**
   * Sets a reference to the first issue of the volume.
   *
   * @param firstIssue The reference to the first issue of the volume.
   */
  public void setFirstIssue(IssueCredit firstIssue) {
    this.firstIssue = firstIssue;
  }

  /**
   * Returns a reference to the last issue of the volume.
   *
   * @return The reference to the last issue of the volume.
   */
  public IssueCredit getLastIssue() {
    return this.lastIssue;
  }

  /**
   * Sets a reference to the last issue of the volume.
   *
   * @param lastIssue The reference to the last issue of the volume.
   */
  public void setLastIssue(IssueCredit lastIssue) {
    this.lastIssue = lastIssue;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof VolumeListItem)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final VolumeListItem volume = (VolumeListItem) obj;
    return Objects.equal(summary, volume.summary)
        && Objects.equal(description, volume.description)
        && Objects.equal(aliases, volume.aliases)
        && Objects.equal(publisher, volume.publisher)
        && Objects.equal(image, volume.image)
        && Objects.equal(issueCount, volume.issueCount)
        && Objects.equal(startYear, volume.startYear)
        && Objects.equal(firstIssue, volume.firstIssue)
        && Objects.equal(lastIssue, volume.lastIssue);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.summary, this.description, this.aliases, this.publisher, this.image,
        this.issueCount, this.startYear, this.firstIssue, this.lastIssue);
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
        .add("summary", this.summary)
        .add("description", this.description)
        .add("aliases", this.aliases)
        .add("publisher", this.publisher)
        .add("image", this.image)
        .add("issueCount", this.issueCount)
        .add("startYear", this.startYear)
        .add("firstIssue", this.firstIssue)
        .add("lastIssue", this.lastIssue)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
