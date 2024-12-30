package com.github.stebeg.comicvine.issue;

import com.github.stebeg.comicvine.image.Image;
import com.github.stebeg.comicvine.volume.VolumeCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a list item of an issue. This is a simplified version of the {@link Issue} class used for
 * search results and listing issues.
 */
public class IssueListItem extends IssueCredit {

  @SerializedName(value = IssueAttribute.SUMMARY)
  private String summary;

  @SerializedName(value = IssueAttribute.DESCRIPTION)
  private String description;

  @SerializedName(value = IssueAttribute.ALIASES)
  private String aliases;

  @SerializedName(value = IssueAttribute.IMAGE)
  private Image image;

  @SerializedName(value = IssueAttribute.ISSUE_NUMBER)
  private String issueNumber;

  @SerializedName(value = IssueAttribute.VOLUME)
  private VolumeCredit volume;

  @SerializedName(value = IssueAttribute.COVER_DATE)
  private String coverDate;

  @SerializedName(value = IssueAttribute.IN_STORE_DATE)
  private String inStoreDate;


  /**
   * Creates a new representation of a list item of an issue.
   *
   * @param id   The issue's unique ID.
   * @param name The issue's name.
   */
  public IssueListItem(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a brief summary of the issue.
   *
   * @return Brief summary of the issue.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the issue.
   *
   * @param summary The brief summary of the issue.
   */
  void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Returns a detailed HTML-description of the issue.
   *
   * @return A detailed HTML-description of the issue.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets a detailed HTML-description of the issue.
   *
   * @param description The detailed HTML-description of the issue.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns a list of aliases the issue is known by.
   *
   * @return List of aliases the issue is known by. A \n (newline) seperates each alias.
   */
  public String getAliases() {
    return this.aliases;
  }

  /**
   * Sets the list of aliases the issue is known by.
   *
   * @param aliases The list of aliases. A \n (newline) seperates each alias.
   */
  public void setAliases(String aliases) {
    this.aliases = aliases;
  }

  /**
   * Returns the main image of the issue.
   *
   * @return Main image of the issue.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the issue.
   *
   * @param image The main image of the issue.
   */
  void setImage(Image image) {
    this.image = image;
  }

  /**
   * Returns the number of the issue.
   *
   * @return The number of the issue.
   */
  public String getIssueNumber() {
    return this.issueNumber;
  }

  /**
   * Sets the number of the issue.
   *
   * @param issueNumber The number of the issue.
   */
  public void setIssueNumber(String issueNumber) {
    this.issueNumber = issueNumber;
  }

  /**
   * Returns the reference of the volume the issue belongs to.
   *
   * @return The reference of the volume the issue belongs to.
   */
  public VolumeCredit getVolume() {
    return this.volume;
  }

  /**
   * Sets the reference of the volume the issue belongs to.
   *
   * @param volume The reference of the volume the issue belongs to.
   */
  public void setVolume(VolumeCredit volume) {
    this.volume = volume;
  }

  /**
   * Returns the cover date of the issue.
   *
   * @return The cover date of the issue.
   */
  public String getCoverDate() {
    return this.coverDate;
  }

  /**
   * Sets the cover date of the issue.
   *
   * @param coverDate The cover date of the issue.
   */
  public void setCoverDate(String coverDate) {
    this.coverDate = coverDate;
  }

  /**
   * Returns the date when the issue was published.
   *
   * @return The date when the issue was published.
   */
  public String getInStoreDate() {
    return this.inStoreDate;
  }

  /**
   * Sets the date when the issue was published.
   *
   * @param inStoreDate The date when the issue was published.
   */
  public void setInStoreDate(String inStoreDate) {
    this.inStoreDate = inStoreDate;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof IssueListItem)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final IssueListItem issue = (IssueListItem) obj;
    return Objects.equal(summary, issue.summary)
        && Objects.equal(description, issue.description)
        && Objects.equal(aliases, issue.aliases)
        && Objects.equal(image, issue.image)
        && Objects.equal(issueNumber, issue.issueNumber)
        && Objects.equal(volume, issue.volume)
        && Objects.equal(coverDate, issue.coverDate)
        && Objects.equal(inStoreDate, issue.inStoreDate);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.summary, this.description, this.aliases, this.image,
        this.issueNumber, this.volume, this.coverDate, this.inStoreDate);
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
        .add("image", this.image)
        .add("issueNumber", this.issueNumber)
        .add("volume", this.volume)
        .add("coverDate", this.coverDate)
        .add("inStoreDate", this.inStoreDate)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
