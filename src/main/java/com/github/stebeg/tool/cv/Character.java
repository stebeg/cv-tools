package com.github.stebeg.tool.cv;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Represents comic character information from Comicvine.
 *
 * @author Steffen Berger
 */
public class Character {

  private static final String ID_ATTRIBUTE_NAME = "id";
  private static final String NAME_ATTRIBUTE_NAME = "name";

  @SerializedName(value = ID_ATTRIBUTE_NAME)
  private final long id;

  @SerializedName(value = NAME_ATTRIBUTE_NAME)
  private final String name;

  /**
   * Creates a new representation of comic character information from Comicvine.
   *
   * @param id   The character's unique ID.
   * @param name The character's name.
   */
  Character(long id, String name) {
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
    final Character character = (Character) o;
    return this.id == character.getId()
        && Objects.equals(this.name, character.getName());
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
