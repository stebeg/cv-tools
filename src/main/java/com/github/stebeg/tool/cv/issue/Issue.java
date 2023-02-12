package com.github.stebeg.tool.cv.issue;

import com.github.stebeg.tool.cv.ComicvineEntity;
import com.github.stebeg.tool.cv.character.CharacterCredit;
import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.location.LocationCredit;
import com.github.stebeg.tool.cv.person.PersonCreditWithRole;
import com.github.stebeg.tool.cv.storyarc.StoryArcCredit;
import com.github.stebeg.tool.cv.team.TeamCredit;
import com.github.stebeg.tool.cv.volume.VolumeCredit;
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
public class Issue extends IssueCredit implements ComicvineEntity {

  static final String ISSUE_NUMBER_ATTRIBUTE_NAME = "issue_number";
  static final String DESCRIPTION_ATTRIBUTE_NAME = "description";

  static final String COVER_DATE_ATTRIBUTE_NAME = "cover_date";
  static final String IN_STORE_DATE_ATTRIBUTE_NAME = "store_date";

  static final String IMAGE_ATTRIBUTE_NAME = "image";
  static final String VOLUME_ATTRIBUTE_NAME = "volume";

  static final String CHARACTER_CREDITS_ATTRIBUTE_NAME = "character_credits";
  static final String TEAM_CREDITS_ATTRIBUTE_NAME = "team_credits";
  static final String LOCATION_CREDITS_ATTRIBUTE_NAME = "location_credits";

  static final String PERSON_CREDITS_ATTRIBUTE_NAME = "person_credits";
  static final String STORY_ARC_CREDITS_ATTRIBUTE_NAME = "story_arc_credits";

  static final String WEB_URL_ATTRIBUTE_NAME = "site_detail_url";
  static final String API_URL_ATTRIBUTE_NAME = "api_detail_url";

  @SerializedName(value = ISSUE_NUMBER_ATTRIBUTE_NAME)
  private final String issueNumber;

  @SerializedName(value = DESCRIPTION_ATTRIBUTE_NAME)
  private String description = null;

  @SerializedName(value = COVER_DATE_ATTRIBUTE_NAME)
  private String coverDate = null;

  @SerializedName(value = IN_STORE_DATE_ATTRIBUTE_NAME)
  private String inStoreDate = null;

  @SerializedName(value = IMAGE_ATTRIBUTE_NAME)
  private Image image = null;

  @SerializedName(value = VOLUME_ATTRIBUTE_NAME)
  private VolumeCredit volumeCredit = null;

  @SerializedName(value = CHARACTER_CREDITS_ATTRIBUTE_NAME)
  private final List<CharacterCredit> characterCredits = new ArrayList<>();

  @SerializedName(value = TEAM_CREDITS_ATTRIBUTE_NAME)
  private final List<TeamCredit> teamCredits = new ArrayList<>();

  @SerializedName(value = LOCATION_CREDITS_ATTRIBUTE_NAME)
  private final List<LocationCredit> locationCredits = new ArrayList<>();

  @SerializedName(value = PERSON_CREDITS_ATTRIBUTE_NAME)
  private final List<PersonCreditWithRole> personCredits = new ArrayList<>();

  @SerializedName(value = STORY_ARC_CREDITS_ATTRIBUTE_NAME)
  private final List<StoryArcCredit> storyArcCredits = new ArrayList<>();

  @SerializedName(value = WEB_URL_ATTRIBUTE_NAME)
  private String webUrl = null;

  @SerializedName(value = API_URL_ATTRIBUTE_NAME)
  private String apiUrl = null;

  /**
   * Creates a new representation of a comic series issue retrieved from the Comicvine API.
   *
   * @param id          The unique ID of the issue.
   * @param name        The name of the issue.
   * @param issueNumber The issue number.
   */
  Issue(long id, String name, String issueNumber) {
    super(id, name);
    this.issueNumber = issueNumber;
  }

  /**
   * @return The issue number.
   */
  public String getIssueNumber() {
    return this.issueNumber;
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
  public VolumeCredit getVolumeCredit() {
    return this.volumeCredit;
  }

  /**
   * Sets the volume this issue is a part of.
   *
   * @param volumeCredit The volume this issue is a part of.
   */
  public void setVolumeCredit(VolumeCredit volumeCredit) {
    this.volumeCredit = volumeCredit;
  }

  /**
   * @return A list of characters appearing in the issue.
   */
  public List<CharacterCredit> getCharacterCredits() {
    return this.characterCredits;
  }

  /**
   * @return A list of teams appearing in the issue.
   */
  public List<TeamCredit> getTeamCredits() {
    return this.teamCredits;
  }

  /**
   * @return A list of locations appearing in the issue.
   */
  public List<LocationCredit> getLocationCredits() {
    return this.locationCredits;
  }

  /**
   * @return A list of creators of the issue (e.g. writer, cover artist, ...)
   */
  public List<PersonCreditWithRole> getPersonCredits() {
    return this.personCredits;
  }

  /**
   * @return A list of story arcs the issue is part of.
   */
  public List<StoryArcCredit> getStoryArcCredits() {
    return this.storyArcCredits;
  }

  /**
   * @return The web url of the issue.
   */
  public String getWebUrl() {
    return this.webUrl;
  }

  /**
   * Sets the web url of the issue.
   *
   * @param webUrl The web url of the issue.
   */
  public void setWebUrl(String webUrl) {
    this.webUrl = webUrl;
  }

  /**
   * @return The API url of the issue.
   */
  public String getApiUrl() {
    return this.apiUrl;
  }

  /**
   * Sets the API url of the issue.
   *
   * @param apiUrl The API url of the issue.
   */
  public void setApiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
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
    return this.getId() == issue.getId() &&
        Objects.equal(this.issueNumber, issue.issueNumber) &&
        Objects.equal(this.getName(), issue.getName()) &&
        Objects.equal(this.description, issue.description) &&
        Objects.equal(this.coverDate, issue.coverDate) &&
        Objects.equal(this.inStoreDate, issue.inStoreDate) &&
        Objects.equal(this.image, issue.image) &&
        Objects.equal(this.volumeCredit, issue.volumeCredit) &&
        Objects.equal(this.characterCredits, issue.characterCredits) &&
        Objects.equal(this.teamCredits, issue.teamCredits) &&
        Objects.equal(this.locationCredits, issue.locationCredits) &&
        Objects.equal(this.personCredits, issue.personCredits) &&
        Objects.equal(this.storyArcCredits, issue.storyArcCredits) &&
        Objects.equal(this.webUrl, issue.webUrl) &&
        Objects.equal(this.apiUrl, issue.apiUrl);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects
        .hashCode(super.hashCode(), this.issueNumber, this.description, this.coverDate,
            this.inStoreDate, this.image, this.volumeCredit, this.characterCredits, this.teamCredits,
            this.locationCredits, this.personCredits, this.storyArcCredits, this.webUrl, this.apiUrl);
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
        .add("issueNumber", this.issueNumber)
        .add("name", this.getName())
        .add("description", this.description)
        .add("coverDate", this.coverDate)
        .add("inStoreDate", this.inStoreDate)
        .add("image", this.image)
        .add("volumeCredit", this.volumeCredit)
        .add("characterCredits", this.characterCredits)
        .add("teamCredits", this.teamCredits)
        .add("teamCredits", this.locationCredits)
        .add("personCredits", this.personCredits)
        .add("storyArcCredits", this.storyArcCredits)
        .add("webUrl", this.webUrl)
        .add("apiUrl", this.apiUrl)
        .toString();
  }
}
