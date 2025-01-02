package io.github.stebeg.comicvine.person;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a reference to a person including their role(s) in creating a comic.
 */
public class PersonCreditWithRoles extends PersonCredit {

  @SerializedName(PersonAttribute.ROLES)
  private String roles;

  /**
   * Creates a new representation of a reference to a person including their role(s) in creating a comic.
   *
   * @param id The unique ID of the person.
   * @param name The name of the person.
   */
  public PersonCreditWithRoles(long id, String name) {
    super(id, name);
  }

  /**
   * Creates a new representation of a reference to a person including their role(s) in creating a comic.
   *
   * @param id The unique ID of the person.
   * @param name The name of the person.
   * @param roles The role(s) of the person in creating a comic.
   */
  public PersonCreditWithRoles(long id, String name, String roles) {
    super(id, name);
    this.roles = roles;
  }

  /**
   * Returns the role(s) of the person in creating a comic.
   *
   * @return The role(s) of the person in creating a comic.
   */
  public String getRoles() {
    return this.roles;
  }

  /**
   * Sets the role(s) of the person in creating a comic.
   *
   * @param roles The role(s) of the person in creating a comic.
   */
  public void setRoles(String roles) {
    this.roles = roles;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof PersonCreditWithRoles that)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    return Objects.equal(this.roles, that.roles);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.roles);
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
        .add("roles", this.roles)
        .omitEmptyValues()
        .omitNullValues()
        .toString();
  }
}
