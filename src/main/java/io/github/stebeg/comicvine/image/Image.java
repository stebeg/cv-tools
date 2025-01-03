package io.github.stebeg.comicvine.image;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents an image from the Comicvine API.
 */
public class Image {

  @SerializedName(value = ImageAttribute.ICON_URL)
  private String iconUrl;

  @SerializedName(value = ImageAttribute.MEDUIM_URL)
  private String mediumUrl;

  @SerializedName(value = ImageAttribute.SCREEN_URL)
  private String screenUrl;

  @SerializedName(value = ImageAttribute.SCREEN_LARGE_URL)
  private String screenLargeUrl;

  @SerializedName(value = ImageAttribute.SMALL_URL)
  private String smallUrl;

  @SerializedName(value = ImageAttribute.SUPER_URL)
  private String superUrl;

  @SerializedName(value = ImageAttribute.THUMB_URL)
  private String thumbUrl;

  @SerializedName(value = ImageAttribute.TINY_URL)
  private String tinyUrl;

  @SerializedName(value = ImageAttribute.ORIGINAL_URL)
  private String originalUrl;

  @SerializedName(value = ImageAttribute.IMAGE_TAGS)
  private String imageTags;

  /**
   * Creates a new representation of an image from the Comicvine API.
   */
  public Image() {
  }

  /**
   * Returns the URL to the icon image.
   *
   * @return The URL to the icon image.
   */
  public String getIconUrl() {
    return iconUrl;
  }

  /**
   * Sets the URL to the icon image.
   *
   * @param iconUrl The URL to the icon image.
   */
  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  /**
   * Returns the URL to the medium image.
   *
   * @return The URL to the medium image.
   */
  public String getMediumUrl() {
    return mediumUrl;
  }

  /**
   * Sets the URL to the medium image.
   *
   * @param mediumUrl The URL to the medium image.
   */
  public void setMediumUrl(String mediumUrl) {
    this.mediumUrl = mediumUrl;
  }

  /**
   * Returns the URL to the screen image.
   *
   * @return The URL to the screen image.
   */
  public String getScreenUrl() {
    return screenUrl;
  }

  /**
   * Sets the URL to the screen image.
   *
   * @param screenUrl The URL to the screen image.
   */
  public void setScreenUrl(String screenUrl) {
    this.screenUrl = screenUrl;
  }

  /**
   * Returns the URL to the large screen image.
   *
   * @return The URL to the large screen image.
   */
  public String getScreenLargeUrl() {
    return screenLargeUrl;
  }

  /**
   * Sets the URL to the large screen image.
   *
   * @param screenLargeUrl The URL to the large screen image.
   */
  public void setScreenLargeUrl(String screenLargeUrl) {
    this.screenLargeUrl = screenLargeUrl;
  }

  /**
   * Returns the URL to the small image.
   *
   * @return The URL to the small image.
   */
  public String getSmallUrl() {
    return smallUrl;
  }

  /**
   * Sets the URL to the small image.
   *
   * @param smallUrl The URL to the small image.
   */
  public void setSmallUrl(String smallUrl) {
    this.smallUrl = smallUrl;
  }

  /**
   * Returns the URL to the super image.
   *
   * @return The URL to the super image.
   */
  public String getSuperUrl() {
    return superUrl;
  }

  /**
   * Sets the URL to the super image.
   *
   * @param superUrl The URL to the super image.
   */
  public void setSuperUrl(String superUrl) {
    this.superUrl = superUrl;
  }

  /**
   * Returns the URL to the thumbnail image.
   *
   * @return The URL to the thumbnail image.
   */
  public String getThumbUrl() {
    return thumbUrl;
  }

  /**
   * Sets the URL to the thumbnail image.
   *
   * @param thumbUrl The URL to the thumbnail image.
   */
  public void setThumbUrl(String thumbUrl) {
    this.thumbUrl = thumbUrl;
  }

  /**
   * Returns the URL to the tiny image.
   *
   * @return The URL to the tiny image.
   */
  public String getTinyUrl() {
    return tinyUrl;
  }

  /**
   * Sets the URL to the tiny image.
   *
   * @param tinyUrl The URL to the tiny image.
   */
  public void setTinyUrl(String tinyUrl) {
    this.tinyUrl = tinyUrl;
  }

  /**
   * Returns the URL to the original image.
   *
   * @return The URL to the original image.
   */
  public String getOriginalUrl() {
    return originalUrl;
  }

  /**
   * Sets the URL to the original image.
   *
   * @param originalUrl The URL to the original image.
   */
  public void setOriginalUrl(String originalUrl) {
    this.originalUrl = originalUrl;
  }

  /**
   * Returns the tags of the image.
   *
   * @return The tags of the image.
   */
  public String getImageTags() {
    return imageTags;
  }

  /**
   * Sets the tags of the image.
   *
   * @param imageTags The tags of the image.
   */
  public void setImageTags(String imageTags) {
    this.imageTags = imageTags;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Image image)) {
      return false;
    }
    return Objects.equal(this.iconUrl, image.iconUrl)
        && Objects.equal(this.mediumUrl, image.mediumUrl)
        && Objects.equal(this.screenUrl, image.screenUrl)
        && Objects.equal(this.screenLargeUrl, image.screenLargeUrl)
        && Objects.equal(this.smallUrl, image.smallUrl)
        && Objects.equal(this.superUrl, image.superUrl)
        && Objects.equal(this.thumbUrl, image.thumbUrl)
        && Objects.equal(this.tinyUrl, image.tinyUrl)
        && Objects.equal(this.originalUrl, image.originalUrl)
        && Objects.equal(this.imageTags, image.imageTags);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(this.iconUrl, this.mediumUrl, this.screenUrl, this.screenLargeUrl, this.smallUrl,
        this.superUrl, this.thumbUrl, this.tinyUrl, this.originalUrl, this.imageTags);
  }
}
