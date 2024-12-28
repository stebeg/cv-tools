package com.github.stebeg.comicvine.character;

import com.github.stebeg.comicvine.image.Image;
import com.github.stebeg.comicvine.publisher.PublisherCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a list item of a character. This is a simplified version of the {@link Character} class used for
 * search results and listing characters.
 */
public class CharacterListItem extends CharacterCredit {

  @SerializedName(value = CharacterAttribute.REAL_NAME)
  private String realName;

  @SerializedName(value = CharacterAttribute.SUMMARY)
  private String summary;

  @SerializedName(value = CharacterAttribute.DESCRIPTION)
  private String description;

  @SerializedName(value = CharacterAttribute.ALIASES)
  private String aliases;

  @SerializedName(value = CharacterAttribute.PUBLISHER)
  private PublisherCredit publisher;

  @SerializedName(value = CharacterAttribute.IMAGE)
  private Image image;

  @SerializedName(value = CharacterAttribute.GENDER)
  private Integer gender;

  @SerializedName(value = CharacterAttribute.ORIGIN)
  private CharacterOrigin origin;

  @SerializedName(value = CharacterAttribute.BIRTH)
  private String birth;

  /**
   * Creates a new representation of a list item of a comic character.
   *
   * @param id The character's unique ID.
   * @param name The character's name.
   */
  public CharacterListItem(long id, String name) {
    super(id, name);
  }

  /**
   * Returns the real name of the character.
   *
   * @return Real name of the character.
   */
  public String getRealName() {
    return this.realName;
  }

  /**
   * Sets the Real name of the character.
   *
   * @param realName The Real name of the character.
   */
  void setRealName(String realName) {
    this.realName = realName;
  }

  /**
   * Returns a brief summary of the character.
   *
   * @return Brief summary of the character.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the character.
   *
   * @param summary The brief summary of the character.
   */
  void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Returns a detailed HTML-description of the character.
   *
   * @return A detailed HTML-description of the character.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets a detailed HTML-description of the character.
   *
   * @param description The detailed HTML-description of the character.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns a list of aliases the character is known by.
   *
   * @return List of aliases the character is known by. A \n (newline) seperates each alias.
   */
  public String getAliases() {
    return this.aliases;
  }

  /**
   * Sets the list of aliases the character is known by.
   *
   * @param aliases The list of aliases. A \n (newline) seperates each alias.
   */
  public void setAliases(String aliases) {
    this.aliases = aliases;
  }

  /**
   * Returns the primary publisher a character is attached to.
   *
   * @return The primary publisher a character is attached to.
   */
  public PublisherCredit getPublisher() {
    return this.publisher;
  }

  /**
   * Sets the primary publisher a character is attached to.
   *
   * @param publisher The primary publisher a character is attached to.
   */
  void setPublisher(PublisherCredit publisher) {
    this.publisher = publisher;
  }

  /**
   * Returns the main image of the character.
   *
   * @return Main image of the character.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the character.
   *
   * @param image The main image of the character.
   */
  void setImage(Image image) {
    this.image = image;
  }

  /**
   * A number representing the gender of the character.
   *
   * @return {code 1} for {@code male}, {code 2} for {@code female} and {code 3} for {@code other}.
   */
  public Integer getGender() {
    return this.gender;
  }

  /**
   * Sets the number representing the gender of the character.
   *
   * @param gender The number representing the gender of the character. {code 1} for {@code male},
   *               {code 2} for {@code female} and {code 3} for {@code other}.
   */
  void setGender(Integer gender) {
    this.gender = gender;
  }

  /**
   * Returns the origin of the character.
   *
   * @return The origin of the character. Human, Alien, Robot ...etc.
   */
  public CharacterOrigin getOrigin() {
    return this.origin;
  }

  /**
   * Sets the origin of the character. Human, Alien, Robot ...etc.
   *
   * @param origin The origin of the character. Human, Alien, Robot ...etc.
   */
  void setOrigin(CharacterOrigin origin) {
    this.origin = origin;
  }

  /**
   * A date, if one exists, that the character was born on. Not an origin date.
   *
   * @return A date, if one exists, that the character was born on. Not an origin date.
   */
  public String getBirth() {
    return this.birth;
  }

  /**
   * Sets a date that the character was born on. Not an origin date.
   *
   * @param birth The date that the character was born on. Not an origin date.
   */
  void setBirth(String birth) {
    this.birth = birth;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof CharacterListItem)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final CharacterListItem character = (CharacterListItem) obj;
    return Objects.equal(realName, character.realName)
        && Objects.equal(summary, character.summary)
        && Objects.equal(description, character.description)
        && Objects.equal(aliases, character.aliases)
        && Objects.equal(publisher, character.publisher)
        && Objects.equal(image, character.image)
        && Objects.equal(gender, character.gender)
        && Objects.equal(origin, character.origin)
        && Objects.equal(birth, character.birth);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.realName, this.summary, this.description, this.aliases,
        this.publisher, this.image, this.gender, this.origin, this.birth);
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
        .add("realName", this.realName)
        .add("summary", this.summary)
        .add("description", this.description)
        .add("aliases", this.aliases)
        .add("publisher", this.publisher)
        .add("image", this.image)
        .add("gender", this.gender)
        .add("origin", this.origin)
        .add("birth", this.birth)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
