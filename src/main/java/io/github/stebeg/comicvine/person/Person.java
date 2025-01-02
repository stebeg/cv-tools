package io.github.stebeg.comicvine.person;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.character.CharacterCredit;

import java.util.List;

/**
 * Represents detailed information of a person from Comicvine.
 */
public class Person extends PersonListItem {

  @SerializedName(value = PersonAttribute.CREATED_CHARACTERS)
  private List<CharacterCredit> characterList;

  /**
   * Creates a new representation of detailed information of a person from Comicvine.
   *
   * @param id   The person's unique ID.
   * @param name The person's name.
   */
  Person(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a list of characters created by the person.
   *
   * @return A list of characters created by the person.
   */
  public List<CharacterCredit> getCharacterList() {
    return this.characterList;
  }

  /**
   * Sets the list of characters created by the person.
   *
   * @param characterList A list of characters created by the person.
   */
  public void setCharacterList(List<CharacterCredit> characterList) {
    this.characterList = characterList;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Person)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final Person person = (Person) obj;
    return Objects.equal(characterList, person.characterList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.characterList);
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
        .add("summary", this.getSummary())
        .add("description", this.getDescription())
        .add("aliases", this.getAliases())
        .add("image", this.getImage())
        .add("gender", this.getGender())
        .add("birthDate", this.getBirthDate())
        .add("passedAwayDate", this.getPassedAwayDate())
        .add("hometown", this.getHometown())
        .add("country", this.getCountry())
        .add("website", this.getWebsite())
        .add("characterList", this.characterList)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
