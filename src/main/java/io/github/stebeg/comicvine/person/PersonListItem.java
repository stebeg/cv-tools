package io.github.stebeg.comicvine.person;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.image.Image;

/**
 * Represents a list item of a person. This is a simplified version of the {@link Person} class used for
 * search results and listing people.
 */
public class PersonListItem extends PersonCredit {

  @SerializedName(value = PersonAttribute.SUMMARY)
  private String summary;

  @SerializedName(value = PersonAttribute.DESCRIPTION)
  private String description;

  @SerializedName(value = PersonAttribute.ALIASES)
  private String aliases;

  @SerializedName(value = PersonAttribute.IMAGE)
  private Image image;

  @SerializedName(value = PersonAttribute.GENDER)
  private Integer gender;

  @SerializedName(value = PersonAttribute.BIRTHDATE)
  private String birthDate;

  @SerializedName(value = PersonAttribute.PASSED_AWAY_DATE)
  private String passedAwayDate;

  @SerializedName(value = PersonAttribute.HOMETOWN)
  private String hometown;

  @SerializedName(value = PersonAttribute.COUNTRY)
  private String country;

  @SerializedName(value = PersonAttribute.WEBSITE)
  private String website;

  /**
   * Creates a new representation of a list item of a person.
   *
   * @param id The person's unique ID.
   * @param name The person's name.
   */
  public PersonListItem(long id, String name) {
    super(id, name);
  }

  /**
   * Returns a brief summary of the person.
   *
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
   * Returns a detailed HTML-description of the person.
   *
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
   * Returns a list of aliases the person is known by.
   *
   * @return List of aliases the person is known by. A \n (newline) seperates each alias.
   */
  public String getAliases() {
    return this.aliases;
  }

  /**
   * Sets the list of aliases the person is known by.
   *
   * @param aliases The list of aliases. A \n (newline) seperates each alias.
   */
  public void setAliases(String aliases) {
    this.aliases = aliases;
  }

  /**
   * Returns the main image of the person.
   *
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
   * A date, if one exists, that the person was born on. Not an origin date.
   *
   * @return A date, if one exists, that the person was born on.
   */
  public String getBirthDate() {
    return this.birthDate;
  }

  /**
   * Sets a date that the person was born on. Not an origin date.
   *
   * @param birthDate The date that the person was born on.
   */
  void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * Returns the date of the person's death.
   *
   * @return The date of the person's death.
   */
  public String getPassedAwayDate() {
    return this.passedAwayDate;
  }

  /**
   * Sets the date of the person's death.
   *
   * @param passedAwayDate The date of the person's death.
   */
  public void setPassedAwayDate(String passedAwayDate) {
    this.passedAwayDate = passedAwayDate;
  }

  /**
   * Returns the hometown of the person.
   *
   * @return The hometown of the person.
   */
  public String getHometown() {
    return this.hometown;
  }

  /**
   * Sets the hometown of the person.
   *
   * @param hometown The hometown of the person.
   */
  public void setHometown(String hometown) {
    this.hometown = hometown;
  }

  /**
   * Returns the country of the person.
   *
   * @return The country of the person.
   */
  public String getCountry() {
    return this.country;
  }

  /**
   * Sets the country of the person.
   *
   * @param country The country of the person.
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Returns the website of the person.
   *
   * @return The website of the person.
   */
  public String getWebsite() {
    return this.website;
  }

  /**
   * Sets the website of the person.
   *
   * @param website The website of the person.
   */
  public void setWebsite(String website) {
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
    if (!(obj instanceof PersonListItem)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final PersonListItem person = (PersonListItem) obj;
    return Objects.equal(summary, person.summary)
        && Objects.equal(description, person.description)
        && Objects.equal(aliases, person.aliases)
        && Objects.equal(image, person.image)
        && Objects.equal(gender, person.gender)
        && Objects.equal(birthDate, person.birthDate)
        && Objects.equal(passedAwayDate, person.passedAwayDate)
        && Objects.equal(hometown, person.hometown)
        && Objects.equal(country, person.country)
        && Objects.equal(website, person.website);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.summary, this.description, this.aliases, this.image, this.gender,
        this.birthDate, this.passedAwayDate, this.hometown, this.country, this.website);
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
        .add("aliases", this.aliases)
        .add("image", this.image)
        .add("gender", this.gender)
        .add("birthDate", this.birthDate)
        .add("passedAwayDate", this.passedAwayDate)
        .add("hometown", this.hometown)
        .add("country", this.country)
        .add("website", this.website)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
