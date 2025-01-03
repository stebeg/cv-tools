package io.github.stebeg.comicvine.location;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.image.Image;

/**
 * Represents a list item of a location. This is a simplified version of the {@link Location} class used for
 * search results and listing locations.
 */
public class LocationListItem extends LocationCredit {

  @SerializedName(value = LocationAttribute.SUMMARY)
  private String summary;

  @SerializedName(value = LocationAttribute.DESCRIPTION)
  private String description;

  @SerializedName(value = LocationAttribute.ALIASES)
  private String aliases;

  @SerializedName(value = LocationAttribute.IMAGE)
  private Image image;

  @SerializedName(value = LocationAttribute.START_YEAR)
  private String startYear;

  /**
   * Creates a new representation of a list item of a comic location.
   *
   * @param id   The location's unique ID.
   * @param name The location's name.
   */
  public LocationListItem(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a brief summary of the location.
   *
   * @return Brief summary of the location.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the location.
   *
   * @param summary The brief summary of the location.
   */
  void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Returns a detailed HTML-description of the location.
   *
   * @return A detailed HTML-description of the location.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets a detailed HTML-description of the location.
   *
   * @param description The detailed HTML-description of the location.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns a list of aliases the location is known by.
   *
   * @return List of aliases the location is known by. A \n (newline) seperates each alias.
   */
  public String getAliases() {
    return this.aliases;
  }

  /**
   * Sets the list of aliases the location is known by.
   *
   * @param aliases The list of aliases. A \n (newline) seperates each alias.
   */
  public void setAliases(String aliases) {
    this.aliases = aliases;
  }

  /**
   * Returns the main image of the location.
   *
   * @return Main image of the location.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the location.
   *
   * @param image The main image of the location.
   */
  void setImage(Image image) {
    this.image = image;
  }

  /**
   * Retuns the first year this location appeared in comics.
   *
   * @return The first year this location appeared in comics.
   */
  public String getStartYear() {
    return this.startYear;
  }

  /**
   * Sets the first year this location appeared in comics.
   *
   * @param startYear The first year this location appeared in comics.
   */
  void setStartYear(String startYear) {
    this.startYear = startYear;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof LocationListItem)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final LocationListItem location = (LocationListItem) obj;
    return Objects.equal(summary, location.summary)
        && Objects.equal(description, location.description)
        && Objects.equal(aliases, location.aliases)
        && Objects.equal(image, location.image)
        && Objects.equal(startYear, location.startYear);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.summary, this.description, this.aliases, this.image, this.startYear);
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
        .add("startYear", this.startYear)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
