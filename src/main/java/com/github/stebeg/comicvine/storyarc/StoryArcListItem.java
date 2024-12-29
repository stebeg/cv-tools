package com.github.stebeg.comicvine.storyarc;

import com.github.stebeg.comicvine.image.Image;
import com.github.stebeg.comicvine.publisher.PublisherCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a list item of a story arc. This is a simplified version of the {@link StoryArc} class used for
 * search results and listing story arcs.
 */
public class StoryArcListItem extends StoryArcCredit {

  @SerializedName(value = StoryArcAttribute.SUMMARY)
  private String summary;

  @SerializedName(value = StoryArcAttribute.DESCRIPTION)
  private String description;

  @SerializedName(value = StoryArcAttribute.ALIASES)
  private String aliases;

  @SerializedName(value = StoryArcAttribute.PUBLISHER)
  private PublisherCredit publisher;

  @SerializedName(value = StoryArcAttribute.IMAGE)
  private Image image;

  /**
   * Creates a new representation of a list item of a comic story arc.
   *
   * @param id   The story arc's unique ID.
   * @param name The story arc's name.
   */
  public StoryArcListItem(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a brief summary of the story arc.
   *
   * @return Brief summary of the story arc.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the story arc.
   *
   * @param summary The brief summary of the story arc.
   */
  void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Returns a detailed HTML-description of the story arc.
   *
   * @return A detailed HTML-description of the story arc.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets a detailed HTML-description of the story arc.
   *
   * @param description The detailed HTML-description of the story arc.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns a list of aliases the story arc is known by.
   *
   * @return List of aliases the story arc is known by. A \n (newline) seperates each alias.
   */
  public String getAliases() {
    return this.aliases;
  }

  /**
   * Sets the list of aliases the story arc is known by.
   *
   * @param aliases The list of aliases. A \n (newline) seperates each alias.
   */
  public void setAliases(String aliases) {
    this.aliases = aliases;
  }

  /**
   * Returns the primary publisher a story arc is attached to.
   *
   * @return The primary publisher a story arc is attached to.
   */
  public PublisherCredit getPublisher() {
    return this.publisher;
  }

  /**
   * Sets the primary publisher a story arc is attached to.
   *
   * @param publisher The primary publisher a story arc is attached to.
   */
  void setPublisher(PublisherCredit publisher) {
    this.publisher = publisher;
  }

  /**
   * Returns the main image of the story arc.
   *
   * @return Main image of the story arc.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the story arc.
   *
   * @param image The main image of the story arc.
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
    if (!(obj instanceof StoryArcListItem)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final StoryArcListItem stroyArc = (StoryArcListItem) obj;
    return Objects.equal(summary, stroyArc.summary)
        && Objects.equal(description, stroyArc.description)
        && Objects.equal(aliases, stroyArc.aliases)
        && Objects.equal(publisher, stroyArc.publisher)
        && Objects.equal(image, stroyArc.image);
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
