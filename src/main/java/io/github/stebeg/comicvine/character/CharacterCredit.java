package io.github.stebeg.comicvine.character;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.common.ComicvineEntity;

/**
 * Represents a reference of a character.
 */
public class CharacterCredit implements ComicvineEntity {

  @SerializedName(value = CharacterAttribute.ID)
  private final long id;

  @SerializedName(value = CharacterAttribute.NAME)
  private final String name;

  /**
   * Creates a new representation of a reference of a character.
   *
   * @param id   The character's unique ID.
   * @param name The character's name.
   */
  public CharacterCredit(long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @return The character's unique ID.
   */
  @Override
  public long getId() {
    return this.id;
  }

  /**
   * @return The character's name.
   */
  @Override
  public String getName() {
    return this.name;
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
    CharacterCredit that = (CharacterCredit) obj;
    return this.id == that.id &&
        Objects.equal(this.name, that.name);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(this.id, this.name);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", this.id)
        .add("name", this.name)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
