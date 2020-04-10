package com.github.stebeg.tool.cv.person;

import com.github.stebeg.tool.cv.image.Image;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents detailed information of a person from Comicvine.
 *
 * @author Steffen Berger
 */
public class Person extends SimplePerson {

  static final String SUMMARY_ATTRIBUTE_NAME = "deck";
  static final String DESCRIPTION_ATTRIBUTE_NAME = "description";

  static final String BIRTH_ATTRIBUTE_NAME = "birth";
  static final String DEATH_ATTRIBUTE_NAME = "death";

  static final String GENDER_ATTRIBUTE_NAME = "gender";
  static final String IMAGE_ATTRIBUTE_NAME = "image";

  static final String COUNTRY_ATTRIBUTE_NAME = "country";
  static final String HOMETOWN_ATTRIBUTE_NAME = "hometown";
  static final String WEBSITE_ATTRIBUTE_NAME = "website";

  @SerializedName(value = SUMMARY_ATTRIBUTE_NAME)
  private String summary;

  @SerializedName(value = DESCRIPTION_ATTRIBUTE_NAME)
  private String description;

  @SerializedName(value = BIRTH_ATTRIBUTE_NAME)
  private String birth;

  @SerializedName(value = DEATH_ATTRIBUTE_NAME)
  private String death;

  @SerializedName(value = GENDER_ATTRIBUTE_NAME)
  private Integer gender;

  @SerializedName(value = IMAGE_ATTRIBUTE_NAME)
  private Image image;

  @SerializedName(value = COUNTRY_ATTRIBUTE_NAME)
  private String country;

  @SerializedName(value = HOMETOWN_ATTRIBUTE_NAME)
  private String hometown;

  @SerializedName(value = WEBSITE_ATTRIBUTE_NAME)
  private String website;


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
   * @return Brief summary of the person.
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * Sets a brief summary of the person.
   *
   * @param summary The brief summary of the person.
   */
  void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * @return A detailed HTML-description of the person.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets a detailed HTML-description of the person.
   *
   * @param description The detailed HTML-description of the person.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return The date, if one exists, that the person was born on.
   */
  public String getBirth() {
    return this.birth;
  }

  /**
   * Sets the date that the person was born on.
   *
   * @param birth The date that the person was born on.
   */
  void setBirth(String birth) {
    this.birth = birth;
  }

  /**
   * @return The Date, if one exists, this person died on.
   */
  public String getDeath() {
    return this.death;
  }

  /**
   * Sets the Date this person died on.
   *
   * @param death The Date this person died on.
   */
  void setDeath(String death) {
    this.death = death;
  }

  /**
   * A number representing the gender of the person.
   *
   * @return {code 1} for {@code male}, {code 2} for {@code female} and {code 3} for {@code other}.
   */
  public Integer getGender() {
    return this.gender;
  }

  /**
   * Sets the number representing the gender of the person.
   *
   * @param gender The number representing the gender of the person. {code 1} for {@code male},
   *               {code 2} for {@code female} and {code 3} for {@code other}.
   */
  void setGender(Integer gender) {
    this.gender = gender;
  }

  /**
   * @return Main image of the person.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets the main image of the person.
   *
   * @param image The main image of the person.
   */
  void setImage(Image image) {
    this.image = image;
  }

  /**
   * @return The Country the person resides in.
   */
  public String getCountry() {
    return this.country;
  }

  /**
   * Sets the Country the person resides in.
   *
   * @param country The Country the person resides in.
   */
  void setCountry(String country) {
    this.country = country;
  }

  /**
   * @return The City or town the person resides in.
   */
  public String getHometown() {
    return this.hometown;
  }

  /**
   * Sets the City or town the person resides in.
   *
   * @param hometown The City or town the person resides in.
   */
  void setHometown(String hometown) {
    this.hometown = hometown;
  }

  /**
   * @return The URL to the person website.
   */
  public String getWebsite() {
    return this.website;
  }

  /**
   * Sets the URL to the person website.
   *
   * @param website The URL to the person website.
   */
  void setWebsite(String website) {
    this.website = website;
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
    final Person person = (Person) obj;
    return Objects.equal(this.getId(), person.getId()) &&
        Objects.equal(this.getName(), person.getName()) &&
        Objects.equal(this.summary, person.summary) &&
        Objects.equal(this.description, person.description) &&
        Objects.equal(this.birth, person.birth) &&
        Objects.equal(this.death, person.death) &&
        Objects.equal(this.gender, person.gender) &&
        Objects.equal(this.image, person.image) &&
        Objects.equal(this.country, person.country) &&
        Objects.equal(this.hometown, person.hometown) &&
        Objects.equal(this.website, person.website);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects
        .hashCode(super.hashCode(), this.summary, this.description, this.birth, this.death,
            this.gender, this.image, this.country, this.hometown, this.website);
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
        .add("summary", this.summary)
        .add("description", this.description)
        .add("birth", this.birth)
        .add("death", this.death)
        .add("gender", this.gender)
        .add("image", this.image)
        .add("country", this.country)
        .add("hometown", this.hometown)
        .add("website", this.website)
        .toString();
  }
}
