package com.github.stebeg.tool.cv.volume;

import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.publisher.SimplePublisher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents information of a comic series/volume retrieved from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class Volume extends SimpleVolume {

  static final String DESCRIPTION_ATTRIBUTE_NAME = "description";
  static final String START_YEAR_ATTRIBUTE_NAME = "start_year";
  static final String PUBLISHER_ATTRIBUTE_NAME = "publisher";

  static final String COUNT_OF_ISSUES_ATTRIBUTE_NAME = "count_of_issues";
  static final String IMAGE_ATTRIBUTE_NAME = "image";

  @SerializedName(value = DESCRIPTION_ATTRIBUTE_NAME)
  private String description = null;

  @SerializedName(value = START_YEAR_ATTRIBUTE_NAME)
  private Integer startYear = null;

  @SerializedName(value = COUNT_OF_ISSUES_ATTRIBUTE_NAME)
  private Integer countOfIssues = null;

  @SerializedName(value = PUBLISHER_ATTRIBUTE_NAME)
  private SimplePublisher publisher = null;

  @SerializedName(value = IMAGE_ATTRIBUTE_NAME)
  private Image image = null;

  /**
   * Creates a new representation of a comic volume retrieved from the Comicvine API.
   *
   * @param id   The unique ID of the series/volume.
   * @param name The name of the series/volume.
   */
  Volume(long id, String name) {
    super(id, name);
  }

  /**
   * @return The HTML description of the series/volume.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets the HTML description of the series/volume.
   *
   * @param description The HTML description of the series/volume.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return The year the first issue of the series/volume was released.
   */
  public Integer getStartYear() {
    return this.startYear;
  }

  /**
   * Sets the year the first issue of the series/volume was released.
   *
   * @param startYear The year the first issue of the series/volume was released.
   */
  void setStartYear(Integer startYear) {
    this.startYear = startYear;
  }

  /**
   * @return The number of issues of the series/volume.
   */
  public Integer getCountOfIssues() {
    return this.countOfIssues;
  }

  /**
   * Sets the number of issues of the series/volume.
   *
   * @param countOfIssues The number of issues of the series/volume.
   */
  void setCountOfIssues(Integer countOfIssues) {
    this.countOfIssues = countOfIssues;
  }

  /**
   * @return The publisher of the series/volume.
   */
  public SimplePublisher getPublisher() {
    return this.publisher;
  }

  /**
   * Sets the publisher of the series/volume.
   *
   * @param publisher The publisher of the series/volume.
   */
  void setPublisher(SimplePublisher publisher) {
    this.publisher = publisher;
  }

  /**
   * @return An image of the series/volume. This is usually the cover of the first issue of the
   * series/volume.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the image of the series/volume
   *
   * @param image The image of the series/volume.
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
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final Volume volume = (Volume) obj;
    return Objects.equal(this.getId(), volume.getId()) &&
        Objects.equal(this.getName(), volume.getName()) &&
        Objects.equal(this.description, volume.description) &&
        Objects.equal(this.startYear, volume.startYear) &&
        Objects.equal(this.countOfIssues, volume.countOfIssues) &&
        Objects.equal(this.publisher, volume.publisher) &&
        Objects.equal(this.image, volume.image);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects
        .hashCode(super.hashCode(), this.description, this.startYear, this.countOfIssues,
            this.publisher, this.image);
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
        .add("startYear", this.startYear)
        .add("countOfIssues", this.countOfIssues)
        .add("publisher", this.publisher)
        .add("image", this.image)
        .toString();
  }
}
