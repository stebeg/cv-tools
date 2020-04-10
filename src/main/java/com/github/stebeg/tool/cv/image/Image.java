package com.github.stebeg.tool.cv.image;

import com.github.stebeg.tool.cv.ComicvineEntity;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Represents image locations retrieved from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class Image implements ComicvineEntity {

  private static final String ORIGINAL_URL_ATTRIBUTE_NAME = "original_url";
  private static final String THUMB_URL_ATTRIBUTE_NAME = "thumb_url";

  @SerializedName(value = ORIGINAL_URL_ATTRIBUTE_NAME)
  private final String originalUrl;

  @SerializedName(value = THUMB_URL_ATTRIBUTE_NAME)
  private final String thumbUrl;

  /**
   * Creates a new representation of an image locations retrieved from the Comicvine API.
   *
   * @param originalUrl The original URL to the image.
   * @param thumbUrl    The URL to the thumbnail of the image.
   */
  public Image(String originalUrl, String thumbUrl) {
    this.originalUrl = originalUrl;
    this.thumbUrl = thumbUrl;
  }

  /**
   * @return The original URL to the image.
   */
  public String getOriginalUrl() {
    return this.originalUrl;
  }

  /**
   * @return The URL to the thumbnail of the image.
   */
  public String getThumbUrl() {
    return this.thumbUrl;
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
    final Image image = (Image) obj;
    return Objects.equals(this.originalUrl, image.getOriginalUrl())
        && Objects.equals(this.thumbUrl, image.getThumbUrl());
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(getClass().getName(), this.originalUrl, this.thumbUrl);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Image{"
        + "originalUrl='" + this.originalUrl + "', "
        + "thumbUrl='" + this.thumbUrl + "'}";
  }
}