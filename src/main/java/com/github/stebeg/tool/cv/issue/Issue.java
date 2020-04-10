package com.github.stebeg.tool.cv.issue;

import com.github.stebeg.tool.cv.character.SimpleCharacter;
import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.person.SimplePersonWithRole;
import com.github.stebeg.tool.cv.team.SimpleTeam;
import com.github.stebeg.tool.cv.volume.SimpleVolume;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

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
  static final String VOLUME_ATTRIBUTE_NAME = "volume";

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

  @SerializedName(value = VOLUME_ATTRIBUTE_NAME)
  private SimpleVolume volume = null;

  @SerializedName(value = CHARACTER_CREDITS_ATTRIBUTE_NAME)
  private final List<SimpleCharacter> characters = new ArrayList<>();

  @SerializedName(value = TEAM_CREDITS_ATTRIBUTE_NAME)
  private final List<SimpleTeam> teams = new ArrayList<>();

  @SerializedName(value = PERSON_CREDITS_ATTRIBUTE_NAME)
  private final List<SimplePersonWithRole> personList = new ArrayList<>();

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
   * @return The volume this issue is a part of.
   */
  public SimpleVolume getVolume() {
    return this.volume;
  }

  /**
   * Sets the volume this issue is a part of.
   *
   * @param volume The volume this issue is a part of.
   */
  public void setVolume(SimpleVolume volume) {
    this.volume = volume;
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
  public List<SimplePersonWithRole> getPersonList() {
    return this.personList;
  }

  /**
   * {@inheritDoc}
   *
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
    final Issue issue = (Issue) obj;
    return this.id == issue.id &&
        Objects.equal(this.issueNumber, issue.issueNumber) &&
        Objects.equal(this.name, issue.name) &&
        Objects.equal(this.description, issue.description) &&
        Objects.equal(this.coverDate, issue.coverDate) &&
        Objects.equal(this.inStoreDate, issue.inStoreDate) &&
        Objects.equal(this.image, issue.image) &&
        Objects.equal(this.volume, issue.volume) &&
        Objects.equal(this.characters, issue.characters) &&
        Objects.equal(this.teams, issue.teams) &&
        Objects.equal(this.personList, issue.personList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects
        .hashCode(this.id, this.issueNumber, this.name, this.description, this.coverDate,
            this.inStoreDate, this.image, this.volume, this.characters, this.teams,
            this.personList);
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
        .add("issueNumber", this.issueNumber)
        .add("name", this.name)
        .add("description", this.description)
        .add("coverDate", this.coverDate)
        .add("inStoreDate", this.inStoreDate)
        .add("image", this.image)
        .add("volume", this.volume)
        .add("characters", this.characters)
        .add("teams", this.teams)
        .add("personList", this.personList)
        .toString();
  }
}
