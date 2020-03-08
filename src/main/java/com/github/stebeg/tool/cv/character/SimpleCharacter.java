package com.github.stebeg.tool.cv.character;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Represents the basic information of a comic character from Comicvine.
 *
 * @author Steffen Berger
 */
public class SimpleCharacter {

  private static final String ID_ATTRIBUTE_NAME = "id";
  private static final String NAME_ATTRIBUTE_NAME = "name";

  @SerializedName(value = ID_ATTRIBUTE_NAME)
  private final long id;

  @SerializedName(value = NAME_ATTRIBUTE_NAME)
  private final String name;

  /**
   * Creates a new representation the basic information of a comic character from Comicvine.
   *
   * @param id   The character's unique ID.
   * @param name The character's name.
   */
  public SimpleCharacter(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return The character's unique ID.
   */
  public long getId() {
    return this.id;
  }

  /**
   * @return The character's name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Character{"
        + "id=" + this.id + ", "
        + "name='" + this.name + "'}";
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
    final SimpleCharacter simpleCharacter = (SimpleCharacter) o;
    return this.id == simpleCharacter.getId()
        && Objects.equals(this.name, simpleCharacter.getName());
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
