package com.github.stebeg.tool.cv.publisher;

import com.github.stebeg.tool.cv.ComicvineEntity;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Represents the basic information of a comic book publisher from Comicvine.
 *
 * @author Steffen Berger
 */
public class PublisherCredit implements ComicvineEntity {

  static final String ID_ATTRIBUTE_NAME = "id";
  static final String NAME_ATTRIBUTE_NAME = "name";

  @SerializedName(value = ID_ATTRIBUTE_NAME)
  private final long id;

  @SerializedName(value = NAME_ATTRIBUTE_NAME)
  private final String name;

  /**
   * Creates a new representation of the basic information of a comic book publisher from Comicvine.
   *
   * @param id   The publisher's unique ID.
   * @param name The publisher's name.
   */
  public PublisherCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return The publisher's unique ID.
   */
  public long getId() {
    return this.id;
  }

  /**
   * @return The publisher's name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * {@inheritDoc}
   *
   * @param o {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final PublisherCredit publisherCredit = (PublisherCredit) o;
    return this.id == publisherCredit.getId()
        && Objects.equals(this.name, publisherCredit.getName());
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(getClass().getName(), this.id, this.name);
  }
}
