package com.github.stebeg.tool.cv.publisher;

import com.github.stebeg.tool.cv.image.Image;
import com.google.gson.annotations.SerializedName;

/**
 * Represents detailed information of a comic book publisher from Comicvine.
 *
 * @author Steffen Berger
 */
public class Publisher extends SimplePublisher {

  static final String SUMMARY_ATTRIBUTE_NAME = "deck";
  static final String DESCRIPTION_ATTRIBUTE_NAME = "description";

  static final String IMAGE_ATTRIBUTE_NAME = "image";

  static final String CITY_ATTRIBUTE_NAME = "location_city";
  static final String STATE_ATTRIBUTE_NAME = "location_state";

  @SerializedName(value = SUMMARY_ATTRIBUTE_NAME)
  private String summary;

  @SerializedName(value = DESCRIPTION_ATTRIBUTE_NAME)
  private String description;

  @SerializedName(value = IMAGE_ATTRIBUTE_NAME)
  private Image image;

  @SerializedName(value = CITY_ATTRIBUTE_NAME)
  private String city;

  @SerializedName(value = STATE_ATTRIBUTE_NAME)
  private String state;

  /**
   * Creates a new representation of detailed information of a comic book publisher from Comicvine.
   *
   * @param id   The publisher's unique ID.
   * @param name The publisher's name.
   */
  Publisher(long id, String name) {
    super(id, name);
  }

  /**
   * @return Brief summary of the publisher.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the publisher.
   *
   * @param summary The brief summary of the publisher.
   */
  void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * @return A detailed HTML-description of the publisher.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets a detailed HTML-description of the publisher.
   *
   * @param description The detailed HTML-description of the publisher.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return Main image of the publisher.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the publisher.
   *
   * @param image The main image of the publisher.
   */
  void setImage(Image image) {
    this.image = image;
  }

  /**
   * @return The City the publisher resides in.
   */
  public String getCity() {
    return this.city;
  }

  /**
   * Sets the City the publisher resides in.
   *
   * @param city The City the publisher resides in.
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return The State the publisher resides in.
   */
  public String getState() {
    return this.state;
  }

  /**
   * Sets the State the publisher resides in.
   *
   * @param state The State the publisher resides in.
   */
  public void setState(String state) {
    this.state = state;
  }
}
