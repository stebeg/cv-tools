package com.github.stebeg.comicvine.person;

/**
 * Contains the names of the attributes of a person from the Comicvine API.
 */
public class PersonAttribute {

  /**
   * The name of the attribute for the person's unique ID.
   */
  public static final String ID = "id";
  /**
   * The name of the attribute for the person's name.
   */
  public static final String NAME = "name";

  /**
   * The attribute name for the summary of the person.
   */
  public static final String SUMMARY = "deck";
  /**
   * The attribute name for the description of the person.
   */
  public static final String DESCRIPTION = "description";
  /**
   * The attribute name for the aliases of the person.
   */
  public static final String ALIASES = "aliases";
  /**
   * The attribute name for the gender of the person.
   */
  public static final String GENDER = "gender";

  /**
   * The attribute name for the image of the person.
   */
  public static final String IMAGE = "image";

  /**
   * The attribute name for the birthdate of the person.
   */
  public static final String BIRTHDATE = "birth";
  /**
   * The attribute name for the date of the person's death.
   */
  public static final String PASSED_AWAY_DATE = "death";

  /**
   * The attribute name for the hometown of the person.
   */
  public static final String HOMETOWN = "hometown";
  /**
   * The attribute name for the country of the person.
   */
  public static final String COUNTRY = "country";

  /**
   * The attribute name for the website of the person.
   */
  public static final String WEBSITE = "website";

  /**
   * The attribute name for the list of references to the characters created by the person.
   */
  public static final String CREATED_CHARACTERS = "created_characters";

  private PersonAttribute() {
  }
}
