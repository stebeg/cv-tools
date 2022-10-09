package com.github.stebeg.tool.cv.storyarc;

import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.issue.IssueCredit;
import com.github.stebeg.tool.cv.publisher.PublisherCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents detailed information of a comic book story arc from Comicvine.
 *
 * @author Steffen Berger
 */
public class StoryArc extends StoryArcCredit {

  static final String DESCRIPTION_ATTRIBUTE_NAME = "description";
  static final String ISSUES_ATTRIBUTE_NAME = "issues";

  static final String PUBLISHER_ATTRIBUTE_NAME = "publisher";
  static final String IMAGE_ATTRIBUTE_NAME = "image";

  @SerializedName(value = DESCRIPTION_ATTRIBUTE_NAME)
  private String description;

  @SerializedName(value = ISSUES_ATTRIBUTE_NAME)
  private final List<IssueCredit> issueCredits = new ArrayList<>();

  @SerializedName(value = PUBLISHER_ATTRIBUTE_NAME)
  private PublisherCredit publisherCredit = null;

  @SerializedName(value = IMAGE_ATTRIBUTE_NAME)
  private Image image;

  /**
   * Creates a new representation of detailed information of a comic book story arc from Comicvine.
   *
   * @param id   The story arc's unique ID.
   * @param name The story arc's name.
   */
  public StoryArc(long id, String name) {
    super(id, name);
  }

  /**
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
   * @return A list of issues in the story arc.
   */
  public List<IssueCredit> getIssueCredits() {
    return this.issueCredits;
  }

  /**
   * @return The publisher of the story arc.
   */
  public PublisherCredit getPublisherCredit() {
    return this.publisherCredit;
  }

  /**
   * Sets the publisher of the story arc.
   *
   * @param publisherCredit The publisher of the story arc.
   */
  void setPublisherCredit(PublisherCredit publisherCredit) {
    this.publisherCredit = publisherCredit;
  }

  /**
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
    if (!super.equals(obj)) {
      return false;
    }
    final StoryArc that = (StoryArc) obj;
    return Objects.equal(this.getId(), that.getId())
        && Objects.equal(this.getName(), that.getName())
        && Objects.equal(this.description, that.description)
        && Objects.equal(this.issueCredits, that.issueCredits)
        && Objects.equal(this.publisherCredit, that.publisherCredit)
        && Objects.equal(this.image, that.image);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.description, this.issueCredits, this.publisherCredit, this.image);
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
        .add("description", this.description)
        .add("issueCredits", this.issueCredits)
        .add("publisherCredit", this.publisherCredit)
        .add("image", this.image)
        .toString();
  }
}
