package com.github.stebeg.comicvine.team;

import com.github.stebeg.comicvine.image.Image;
import com.github.stebeg.comicvine.publisher.PublisherCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a list item of a team. This is a simplified version of the {@link Team} class used for
 * search results and listing teams.
 */
public class TeamListItem extends TeamCredit {

  @SerializedName(value = TeamAttribute.SUMMARY)
  private String summary;

  @SerializedName(value = TeamAttribute.DESCRIPTION)
  private String description;

  @SerializedName(value = TeamAttribute.ALIASES)
  private String aliases;

  @SerializedName(value = TeamAttribute.PUBLISHER)
  private PublisherCredit publisher;

  @SerializedName(value = TeamAttribute.IMAGE)
  private Image image;

  /**
   * Creates a new representation of a list item of a comic team.
   *
   * @param id The team's unique ID.
   * @param name The team's name.
   */
  public TeamListItem(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a brief summary of the team.
   *
   * @return A Brief summary of the team.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the team.
   *
   * @param summary The brief summary of the team.
   */
  void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Returns a detailed HTML-description of the team.
   *
   * @return A detailed HTML-description of the team.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets a detailed HTML-description of the team.
   *
   * @param description The detailed HTML-description of the team.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns a list of aliases the team is known by.
   *
   * @return List of aliases the team is known by. A \n (newline) seperates each alias.
   */
  public String getAliases() {
    return this.aliases;
  }

  /**
   * Sets the list of aliases the team is known by.
   *
   * @param aliases The list of aliases. A \n (newline) seperates each alias.
   */
  public void setAliases(String aliases) {
    this.aliases = aliases;
  }

  /**
   * Returns the primary publisher a team is attached to.
   *
   * @return The primary publisher a team is attached to.
   */
  public PublisherCredit getPublisher() {
    return this.publisher;
  }

  /**
   * Sets the primary publisher a team is attached to.
   *
   * @param publisher The primary publisher a team is attached to.
   */
  void setPublisher(PublisherCredit publisher) {
    this.publisher = publisher;
  }

  /**
   * Returns the main image of the team.
   *
   * @return Main image of the team.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the team.
   *
   * @param image The main image of the team.
   */
  void setImage(Image image) {
    this.image = image;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof TeamListItem)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final TeamListItem team = (TeamListItem) obj;
    return Objects.equal(summary, team.summary)
        && Objects.equal(description, team.description)
        && Objects.equal(aliases, team.aliases)
        && Objects.equal(publisher, team.publisher)
        && Objects.equal(image, team.image);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.summary, this.description, this.aliases, this.publisher, this.image);
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
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
