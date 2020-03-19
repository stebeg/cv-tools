package com.github.stebeg.tool.cv.team;

import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.publisher.SimplePublisher;
import com.google.gson.annotations.SerializedName;

/**
 * Represents detailed information of a comic team from Comicvine.
 *
 * @author Steffen Berger
 */
public class Team extends SimpleTeam {

  static final String SUMMARY_ATTRIBUTE_NAME = "deck";
  static final String DESCRIPTION_ATTRIBUTE_NAME = "description";

  static final String PUBLISHER_ATTRIBUTE_NAME = "publisher";
  static final String IMAGE_ATTRIBUTE_NAME = "image";

  @SerializedName(value = SUMMARY_ATTRIBUTE_NAME)
  private String summary;

  @SerializedName(value = DESCRIPTION_ATTRIBUTE_NAME)
  private String description;

  @SerializedName(value = PUBLISHER_ATTRIBUTE_NAME)
  private SimplePublisher publisher;

  @SerializedName(value = IMAGE_ATTRIBUTE_NAME)
  private Image image;

  /**
   * Creates a new representation of detailed information of a comic team from Comicvine.
   *
   * @param id   The team's unique ID.
   * @param name The team's name.
   */
  Team(long id, String name) {
    super(id, name);
  }

  /**
   * @return Brief summary of the team.
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
   * @return The primary publisher a team is attached to.
   */
  public SimplePublisher getPublisher() {
    return this.publisher;
  }

  /**
   * Sets the primary publisher a team is attached to.
   *
   * @param publisher The primary publisher a character is attached to.
   */
  void setPublisher(SimplePublisher publisher) {
    this.publisher = publisher;
  }

  /**
   * @return Main image of the team.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the team.
   *
   * @param image The main image of the character.
   */
  void setImage(Image image) {
    this.image = image;
  }

}
