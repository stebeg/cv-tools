package io.github.stebeg.comicvine.issue;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.character.CharacterCredit;
import io.github.stebeg.comicvine.location.LocationCredit;
import io.github.stebeg.comicvine.person.PersonCreditWithRoles;
import io.github.stebeg.comicvine.storyarc.StoryArcCredit;
import io.github.stebeg.comicvine.team.TeamCredit;

import java.util.List;

/**
 * Represents detailed information of an issue from Comicvine.
 */
public class Issue extends IssueListItem {

  @SerializedName(value = IssueAttribute.CHARACTERS)
  private List<CharacterCredit> characterList;

  @SerializedName(value = IssueAttribute.TEAMS)
  private List<TeamCredit> teamList;

  @SerializedName(value = IssueAttribute.LOCATIONS)
  private List<LocationCredit> locationList;

  @SerializedName(value = IssueAttribute.CREATORS)
  private List<PersonCreditWithRoles> creatorList;

  @SerializedName(value = IssueAttribute.STORY_ARCS)
  private List<StoryArcCredit> storyArcList;

  /**
   * Creates a new representation of detailed information of an issue from Comicvine.
   *
   * @param id   The issue's unique ID.
   * @param name The issue's name.
   */
  Issue(long id, String name) {
    super(id, name);
  }

  /**
   * Returns the list of references to the characters who appear in this issue.
   *
   * @return The list of references to the characters who appear in this issue.
   */
  public List<CharacterCredit> getCharacterList() {
    return this.characterList;
  }

  /**
   * Sets the list of references to the characters who appear in this issue.
   *
   * @param characterList The list of references to the characters who appear in this issue.
   */
  public void setCharacterList(List<CharacterCredit> characterList) {
    this.characterList = characterList;
  }

  /**
   * Returns the list of references to the teams who appear in this issue.
   *
   * @return The list of references to the teams who appear in this issue.
   */
  public List<TeamCredit> getTeamList() {
    return this.teamList;
  }

  /**
   * Sets the list of references to the teams who appear in this issue.
   *
   * @param teamList The list of references to the teams who appear in this issue.
   */
  public void setTeamList(List<TeamCredit> teamList) {
    this.teamList = teamList;
  }

  /**
   * Returns the list of references to the locations this issue takes place at.
   *
   * @return The list of references to the locations this issue takes place at.
   */
  public List<LocationCredit> getLocationList() {
    return this.locationList;
  }

  /**
   * Sets the list of references to the locations this issue takes place at.
   *
   * @param locationList The list of references to the locations this issue takes place at.
   */
  public void setLocationList(List<LocationCredit> locationList) {
    this.locationList = locationList;
  }

  /**
   * Returns the list of references to the real life people who created this issue.
   *
   * @return The list of references to the real life people who created this issue.
   */
  public List<PersonCreditWithRoles> getCreatorList() {
    return this.creatorList;
  }

  /**
   * Sets the list of references to the real life people who created this issue.
   *
   * @param creatorList The list of references to the real life people who created this issue.
   */
  public void setCreatorList(List<PersonCreditWithRoles> creatorList) {
    this.creatorList = creatorList;
  }

  /**
   * Returns the list of references to the story arcs this issue is part of.
   *
   * @return The list of references to the story arcs this issue is part of.
   */
  public List<StoryArcCredit> getStoryArcList() {
    return this.storyArcList;
  }

  /**
   * Sets the list of references to the story arcs this issue is part of.
   *
   * @param storyArcList The list of references to the story arcs this issue is part of.
   */
  public void setStoryArcList(List<StoryArcCredit> storyArcList) {
    this.storyArcList = storyArcList;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Issue)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final Issue issue = (Issue) obj;
    return Objects.equal(characterList, issue.characterList)
        && Objects.equal(teamList, issue.teamList)
        && Objects.equal(locationList, issue.locationList)
        && Objects.equal(creatorList, issue.creatorList)
        && Objects.equal(storyArcList, issue.storyArcList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.characterList, this.teamList, this.locationList, this.creatorList,
        this.storyArcList);
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
        .add("issueNumber", this.getIssueNumber())
        .add("volume", this.getVolume())
        .add("coverDate", this.getCoverDate())
        .add("inStoreDate", this.getInStoreDate())
        .add("webUrl", this.getWebUrl())
        .add("characterList", this.characterList)
        .add("teamList", this.teamList)
        .add("locationList", this.locationList)
        .add("creatorList", this.creatorList)
        .add("storyArcList", this.storyArcList)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
