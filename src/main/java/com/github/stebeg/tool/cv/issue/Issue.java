package com.github.stebeg.tool.cv.issue;

import com.github.stebeg.tool.cv.character.SimpleCharacter;
import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.person.SimplePerson;
import com.github.stebeg.tool.cv.team.SimpleTeam;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents information of a comic series issue retrieved from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class Issue {

  static final String ID_ATTRIBUTE_NAME = "id";
  static final String ISSUE_NUMBER_ATTRIBUTE_NAME = "issue_number";

  static final String NAME_ATTRIBUTE_NAME = "name";
  static final String DESCRIPTION_ATTRIBUTE_NAME = "description";

  static final String COVER_DATE_ATTRIBUTE_NAME = "cover_date";
  static final String IN_STORE_DATE_ATTRIBUTE_NAME = "store_date";

  static final String IMAGE_ATTRIBUTE_NAME = "image";

  static final String CHARACTER_CREDITS_ATTRIBUTE_NAME = "character_credits";
  static final String TEAM_CREDITS_ATTRIBUTE_NAME = "team_credits";
  static final String PERSON_CREDITS_ATTRIBUTE_NAME = "person_credits";

  @SerializedName(value = ID_ATTRIBUTE_NAME)
  private final long id;

  @SerializedName(value = ISSUE_NUMBER_ATTRIBUTE_NAME)
  private final String issueNumber;

  @SerializedName(value = NAME_ATTRIBUTE_NAME)
  private String name = null;

  @SerializedName(value = DESCRIPTION_ATTRIBUTE_NAME)
  private String description = null;

  @SerializedName(value = COVER_DATE_ATTRIBUTE_NAME)
  private String coverDate = null;

  @SerializedName(value = IN_STORE_DATE_ATTRIBUTE_NAME)
  private String inStoreDate = null;

  @SerializedName(value = IMAGE_ATTRIBUTE_NAME)
  private Image image = null;

  @SerializedName(value = CHARACTER_CREDITS_ATTRIBUTE_NAME)
  private final List<SimpleCharacter> characters = new ArrayList<>();

  @SerializedName(value = TEAM_CREDITS_ATTRIBUTE_NAME)
  private final List<SimpleTeam> teams = new ArrayList<>();

  @SerializedName(value = PERSON_CREDITS_ATTRIBUTE_NAME)
  private final List<SimplePerson> personList = new ArrayList<>();

  /**
   * Creates a new representation of a comic series issue retrieved from the Comicvine API.
   *
   * @param id          The unique ID of the issue.
   * @param issueNumber The issue number.
   */
  Issue(long id, String issueNumber) {
    this.id = id;
    this.issueNumber = issueNumber;
  }

  /**
   * @return The unique ID of the issue.
   */
  public long getId() {
    return this.id;
  }

  /**
   * @return The issue number.
   */
  public String getIssueNumber() {
    return this.issueNumber;
  }

  /**
   * @return The name or title of the issue.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the name or title of the issue.
   *
   * @param name The name or title of the issue.
   */
  void setName(String name) {
    this.name = name;
  }

  /**
   * @return The HTML-description of the issue.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets the HTML-description of the issue.
   *
   * @param description The HTML-description of the issue.
   */
  void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return The date printed on the cover of the issue.
   */
  public String getCoverDate() {
    return this.coverDate;
  }

  /**
   * Sets the date printed on the cover of the issue.
   *
   * @param coverDate The date printed on the cover of the issue.
   */
  void setCoverDate(String coverDate) {
    this.coverDate = coverDate;
  }

  /**
   * @return The date the issue was released.
   */
  public String getInStoreDate() {
    return this.inStoreDate;
  }

  /**
   * Sets the date the issue was released.
   *
   * @param inStoreDate The date the issue was released.
   */
  void setInStoreDate(String inStoreDate) {
    this.inStoreDate = inStoreDate;
  }

  /**
   * @return Information about the cover image of the issue.
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Sets Information about the cover image of the issue.
   *
   * @param image Information about the cover image of the issue.
   */
  void setImage(Image image) {
    this.image = image;
  }

  /**
   * @return A list of characters appearing in the issue.
   */
  public List<SimpleCharacter> getCharacters() {
    return this.characters;
  }

  /**
   * @return A list of teams appearing in the issue.
   */
  public List<SimpleTeam> getTeams() {
    return this.teams;
  }

  /**
   * @return A list of creators of the issue (e.g. writer, cover artist, ...)
   */
  public List<SimplePerson> getPersonList() {
    return this.personList;
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Issue{"
        + "id=" + this.id + ", "
        + "issueNumber='" + this.issueNumber + "', "
        + "name='" + this.name + "', "
        + "description='" + this.description + "', "
        + "coverDate='" + this.coverDate + "', "
        + "inStoreDate='" + this.inStoreDate + "', "
        + "image=" + this.image + ", "
        + "characters=" + this.characters + ", "
        + "teams=" + this.teams + ", "
        + "personList=" + this.personList
        + "}";
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
    final Issue issue = (Issue) o;
    return getId() == issue.getId()
        && Objects.equals(getIssueNumber(), issue.getIssueNumber())
        && Objects.equals(getName(), issue.getName())
        && Objects.equals(getDescription(), issue.getDescription())
        && Objects.equals(getCoverDate(), issue.getCoverDate())
        && Objects.equals(getInStoreDate(), issue.getInStoreDate())
        && Objects.equals(getImage(), issue.getImage())
        && Objects.equals(getCharacters(), issue.getCharacters())
        && Objects.equals(getTeams(), issue.getTeams())
        && Objects.equals(getPersonList(), issue.getPersonList());
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(getClass().getName(), this.id, this.issueNumber, this.name, this.description,
            this.coverDate, this.inStoreDate, this.image, this.characters, this.teams,
            this.personList);
  }
}
