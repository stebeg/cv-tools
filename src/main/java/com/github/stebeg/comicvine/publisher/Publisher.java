package com.github.stebeg.comicvine.publisher;

import com.github.stebeg.comicvine.character.CharacterCredit;
import com.github.stebeg.comicvine.common.ComicvineEntity;
import com.github.stebeg.comicvine.storyarc.StoryArcCredit;
import com.github.stebeg.comicvine.team.TeamCredit;
import com.github.stebeg.comicvine.volume.VolumeCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents detailed information of a comic publisher from Comicvine.
 */
public class Publisher extends PublisherListItem implements ComicvineEntity {

  @SerializedName(value = PublisherAttribute.CHARACTERS)
  private List<CharacterCredit> characterList;

  @SerializedName(value = PublisherAttribute.TEAMS)
  private List<TeamCredit> teamList;

  @SerializedName(value = PublisherAttribute.VOLUMES)
  private List<VolumeCredit> volumeList;

  @SerializedName(value = PublisherAttribute.STORY_ARCS)
  private List<StoryArcCredit> storyArcList;

  /**
   * Creates a new representation of detailed information of a comic publisher from Comicvine.
   *
   * @param id   The publisher's unique ID.
   * @param name The publisher's name.
   */
  public Publisher(long id, String name) {
    super(id, name);
  }

  /**
   * Returns the list of references to the characters connected to this publisher.
   *
   * @return The list of references to the characters connected to this publisher.
   */
  public List<CharacterCredit> getCharacterList() {
    return this.characterList;
  }

  /**
   * Sets the list of references to the characters connected to this publisher.
   *
   * @param characterList The list of references to the characters connected to this publisher.
   */
  public void setCharacterList(List<CharacterCredit> characterList) {
    this.characterList = characterList;
  }

  /**
   * Returns the list of references to the teams connected to this publisher.
   *
   * @return The list of references to the teams connected to this publisher.
   */
  public List<TeamCredit> getTeamList() {
    return this.teamList;
  }

  /**
   * Sets the list of references to the teams connected to this publisher.
   *
   * @param teamList The list of references to the teams connected to this publisher.
   */
  public void setTeamList(List<TeamCredit> teamList) {
    this.teamList = teamList;
  }

  /**
   * Returns the list of references to the volumes published by this publisher.
   *
   * @return The list of references to the volumes published by this publisher.
   */
  public List<VolumeCredit> getVolumeList() {
    return this.volumeList;
  }

  /**
   * Sets the list of references to the volumes published by this publisher.
   *
   * @param volumeList The list of references to the volumes published by this publisher.
   */
  public void setVolumeList(List<VolumeCredit> volumeList) {
    this.volumeList = volumeList;
  }

  /**
   * Returns the list of references to the story arcs published by this publisher.
   *
   * @return The list of references to the story arcs published by this publisher.
   */
  public List<StoryArcCredit> getStoryArcList() {
    return this.storyArcList;
  }

  /**
   * Sets the list of references to the story arcs published by this publisher.
   *
   * @param storyArcList The list of references to the story arcs published by this publisher.
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
    if (!(obj instanceof Publisher publisher)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    return Objects.equal(this.characterList, publisher.characterList)
        && Objects.equal(this.teamList, publisher.teamList)
        && Objects.equal(this.volumeList, publisher.volumeList)
        && Objects.equal(this.storyArcList, publisher.storyArcList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.characterList, this.teamList, this.volumeList, this.storyArcList);
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
        .add("address", this.getAddress())
        .add("city", this.getCity())
        .add("state", this.getState())
        .add("characterList", this.characterList)
        .add("teamList", this.teamList)
        .add("volumeList", this.volumeList)
        .add("storyArcList", this.storyArcList)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
