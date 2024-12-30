package com.github.stebeg.comicvine.team;

import com.github.stebeg.comicvine.character.CharacterCredit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents detailed information of a comic team from Comicvine.
 */
public class Team extends TeamListItem {

  @SerializedName(value = TeamAttribute.MEMBERS)
  private List<CharacterCredit> memberList;

  /**
   * Creates a new representation of detailed information of a comic team from Comicvine.
   *
   * @param id   The team's unique ID.
   * @param name The team's name.
   */
  Team(long id, String name) {
    super(id, name);
  }

  /**
   * Returns the list of references to the characters who are members of this team.
   *
   * @return The list of references to the characters who are members of this team.
   */
  public List<CharacterCredit> getMemberList() {
    return this.memberList;
  }

  /**
   * Sets the list of references to the characters who are members of this team.
   *
   * @param memberList The list of references to the characters who are members of this team.
   */
  public void setMemberList(List<CharacterCredit> memberList) {
    this.memberList = memberList;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Team)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    final Team team = (Team) obj;
    return Objects.equal(memberList, team.memberList);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.memberList);
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
        .add("publisher", this.getPublisher())
        .add("image", this.getImage())
        .add("memberList", this.memberList)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
