package com.github.stebeg.tool.cv.character;

import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.person.SimplePerson;
import com.github.stebeg.tool.cv.publisher.SimplePublisher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents detailed information of a comic character from Comicvine.
 *
 * @author Steffen Berger
 */
public class Character extends SimpleCharacter {

  static final String REAL_NAME_ATTRIBUTE_NAME = "real_name";
  static final String SUMMARY_ATTRIBUTE_NAME = "deck";
  static final String DESCRIPTION_ATTRIBUTE_NAME = "description";

  static final String PUBLISHER_ATTRIBUTE_NAME = "publisher";
  static final String IMAGE_ATTRIBUTE_NAME = "image";

  static final String GENDER_ATTRIBUTE_NAME = "gender";
  static final String ORIGIN_ATTRIBUTE_NAME = "origin";
  static final String BIRTH_ATTRIBUTE_NAME = "birth";

  static final String CREATORS_ATTRIBUTE_NAME = "creators";
  static final String FIRST_APPEARED_IN_ATTRIBUTE_NAME = "first_appeared_in_issue";

  @SerializedName(value = REAL_NAME_ATTRIBUTE_NAME)
  private String realName;

  @SerializedName(value = SUMMARY_ATTRIBUTE_NAME)
  private String summary;

  @SerializedName(value = DESCRIPTION_ATTRIBUTE_NAME)
  private String description;

  @SerializedName(value = PUBLISHER_ATTRIBUTE_NAME)
  private SimplePublisher publisher;

  @SerializedName(value = IMAGE_ATTRIBUTE_NAME)
  private Image image;

  @SerializedName(value = GENDER_ATTRIBUTE_NAME)
  private Integer gender;

  @SerializedName(value = ORIGIN_ATTRIBUTE_NAME)
  private CharacterOrigin origin;

  @SerializedName(value = BIRTH_ATTRIBUTE_NAME)
  private String birth;

  @SerializedName(value = CREATORS_ATTRIBUTE_NAME)
  private final List<SimplePerson> creatorList = new ArrayList<>();

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
   * @return The primary publisher a character is attached to.
   */
  public SimplePublisher getPublisher() {
    return this.publisher;
  }

  /**
   * Sets the primary publisher a character is attached to.
   *
   * @param publisher The primary publisher a character is attached to.
   */
  void setPublisher(SimplePublisher publisher) {
    this.publisher = publisher;
  }

  /**
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
   * @return List of the real life people who created this character.
   */
  public List<SimplePerson> getCreatorList() {
    return this.creatorList;
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
    if (!super.equals(obj)) {
      return false;
    }
    final Character character = (Character) obj;
    return Objects.equal(this.getId(), character.getId()) &&
        Objects.equal(this.getName(), character.getName()) &&
        Objects.equal(this.realName, character.realName) &&
        Objects.equal(this.summary, character.summary) &&
        Objects.equal(this.description, character.description) &&
        Objects.equal(this.publisher, character.publisher) &&
        Objects.equal(this.image, character.image) &&
        Objects.equal(this.gender, character.gender) &&
        Objects.equal(this.origin, character.origin) &&
        Objects.equal(this.birth, character.birth) &&
        Objects.equal(this.creatorList, character.creatorList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects
        .hashCode(super.hashCode(), this.realName, this.summary, this.description, this.publisher,
            this.image, this.gender, this.origin, this.birth, this.creatorList);
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
        .add("publisher", this.publisher)
        .add("image", this.image)
        .add("gender", this.gender)
        .add("origin", this.origin)
        .add("birth", this.birth)
        .add("creatorList", this.creatorList)
        .toString();
  }
}
