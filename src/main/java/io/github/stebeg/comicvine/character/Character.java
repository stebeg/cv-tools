package io.github.stebeg.comicvine.character;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.person.PersonCredit;

import java.util.List;

/**
 * Represents detailed information of a comic character from Comicvine.
 */
public class Character extends CharacterListItem {

  @SerializedName(value = CharacterAttribute.CREATORS)
  private List<PersonCredit> creatorList;

  /**
   * Creates a new representation of detailed information of a comic character from Comicvine.
   *
   * @param id   The character's unique ID.
   * @param name The character's name.
   */
  Character(long id, String name) {
    super(id, name);
  }

  /**
   * Returns the list of references to the real life people who created this character.
   *
   * @return The list of references to the real life people who created this character.
   */
  public List<PersonCredit> getCreatorList() {
    return this.creatorList;
  }

  /**
   * Sets the list of references to the real life people who created this character.
   *
   * @param creatorList The list of references to the real life people who created this character.
   */
  public void setCreatorList(List<PersonCredit> creatorList) {
    this.creatorList = creatorList;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Character)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final Character character = (Character) obj;
    return Objects.equal(creatorList, character.creatorList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.creatorList);
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
        .add("realName", this.getRealName())
        .add("summary", this.getSummary())
        .add("description", this.getDescription())
        .add("aliases", this.getAliases())
        .add("publisher", this.getPublisher())
        .add("image", this.getImage())
        .add("gender", this.getGender())
        .add("origin", this.getOrigin())
        .add("birth", this.getBirth())
        .add("creatorList", this.creatorList)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
