package io.github.stebeg.comicvine.issue;

/**
 * Contains the names of the attributes of an issue from the Comicvine API.
 */
public class IssueAttribute {

  /**
   * The name of the attribute for the issue's unique ID.
   */
  public static final String ID = "id";
  /**
   * The name of the attribute for the issue's name.
   */
  public static final String NAME = "name";

  /**
   * The attribute name for the summary of the issue.
   */
  public static final String SUMMARY = "deck";
  /**
   * The attribute name for the description of the issue.
   */
  public static final String DESCRIPTION = "description";
  /**
   * The attribute name for the aliases of the issue.
   */
  public static final String ALIASES = "aliases";

  /**
   * The attribute name for the number of the issue.
   */
  public static final String ISSUE_NUMBER = "issue_number";
  /**
   * The attribute name for the reference of the volume of the issue.
   */
  public static final String VOLUME = "volume";

  /**
   * The attribute name for the cover date of the issue.
   */
  public static final String COVER_DATE = "cover_date";
  /**
   * The attribute name for the date when the issue was published.
   */
  public static final String IN_STORE_DATE = "store_date";

  /**
   * The attribute name for the images of the issue.
   */
  public static final String IMAGE = "image";
  /**
   * The attribute name for the Comicvine website url of the issue.
   */
  public static final String WEB_URL = "site_detail_url";

  /**
   * The attribute name for the list of references to the characters who appear in the issue.
   */
  public static final String CHARACTERS = "character_credits";
  /**
   * The attribute name for the list of references to the teams who appear in the issue.
   */
  public static final String TEAMS = "team_credits";
  /**
   * The attribute name for the list of references to the locations where the issue takes place.
   */
  public static final String LOCATIONS = "location_credits";
  /**
   * The attribute name for the list of references to the real life people who created the issue.
   */
  public static final String CREATORS = "person_credits";
  /**
   * The attribute name for the list of references to the story arcs the issue is part of.
   */
  public static final String STORY_ARCS = "story_arc_credits";
}
