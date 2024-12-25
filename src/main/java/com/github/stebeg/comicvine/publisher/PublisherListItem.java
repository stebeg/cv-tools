package com.github.stebeg.comicvine.publisher;

import com.github.stebeg.comicvine.common.ComicvineEntity;
import com.github.stebeg.comicvine.image.Image;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a list item of a comic book publisher. This is a simplified version of the {@link Publisher} class used for
 * search results and listing publishers.
 */
public class PublisherListItem extends PublisherCredit implements ComicvineEntity {

  @SerializedName(value = PublisherAttribute.SUMMARY)
  private String summary;

  @SerializedName(value = PublisherAttribute.DESCRIPTION)
  private String description;

  @SerializedName(value = PublisherAttribute.ALIASES)
  private String aliases;

  @SerializedName(value = PublisherAttribute.IMAGE)
  private Image image;

  @SerializedName(value = PublisherAttribute.ADDRESS)
  private String address;

  @SerializedName(value = PublisherAttribute.CITY)
  private String city;

  @SerializedName(value = PublisherAttribute.STATE)
  private String state;

  /**
   * Creates a new representation of a list item of a comic book publisher.
   *
   * @param id   The publisher's unique ID.
   * @param name The publisher's name.
   */
  public PublisherListItem(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a brief summary of the publisher.
   *
   * @return A brief summary of the publisher.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the publisher.
   *
   * @param summary The brief summary of the publisher.
   */
  public void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Returns a detailed HTML-description of the publisher.
   *
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
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns the aliases of the publisher.
   *
   * @return The aliases of the publisher.
   */
  public String getAliases() {
    return this.aliases;
  }

  /**
   * Sets the aliases of the publisher.
   *
   * @param aliases The aliases of the publisher.
   */
  public void setAliases(String aliases) {
    this.aliases = aliases;
  }

  /**
   * Returns the main image of the publisher.
   *
   * @return The main image of the publisher.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the publisher.
   *
   * @param image The main image of the publisher.
   */
  public void setImage(Image image) {
    this.image = image;
  }

  /**
   * Returns the address of the publisher.
   *
   * @return The address of the publisher.
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Sets the address of the publisher.
   *
   * @param address The address of the publisher.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Returns the city the publisher is located in.
   *
   * @return The city the publisher is located in.
   */
  public String getCity() {
    return this.city;
  }

  /**
   * Sets the city the publisher is located in.
   *
   * @param city The city the publisher is located in.
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Returns the state the publisher is located in.
   *
   * @return The state the publisher is located in.
   */
  public String getState() {
    return this.state;
  }

  /**
   * Sets the state the publisher is located in.
   *
   * @param state The state the publisher is located in.
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof PublisherListItem that)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    return Objects.equal(this.summary, that.summary)
        && Objects.equal(this.description, that.description)
        && Objects.equal(this.aliases, that.aliases)
        && Objects.equal(this.image, that.image)
        && Objects.equal(this.address, that.address)
        && Objects.equal(this.city, that.city)
        && Objects.equal(this.state, that.state);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.summary, this.description, this.aliases, this.image, this.address,
        this.city, this.state);
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
        .add("address", this.address)
        .add("city", this.city)
        .add("state", this.state)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
