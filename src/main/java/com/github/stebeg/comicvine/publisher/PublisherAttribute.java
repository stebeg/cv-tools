package com.github.stebeg.comicvine.publisher;

/**
 * Contains the names of the attributes of a publisher from the Comicvine API.
 */
public class PublisherAttribute {

  /**
   * The name of the attribute for the publisher's unique ID.
   */
  public static final String ID = "id";
  /**
   * The name of the attribute for the publisher's name.
   */
  public static final String NAME = "name";

  /**
   * The name of the attribute for the publisher's aliases.
   */
  public static final String ALIASES = "aliases";

  /**
   * The name of the attribute for the publisher's brief summary.
   */
  public static final String SUMMARY = "deck";
  /**
   * The name of the attribute for the publisher's detailed description.
   */
  public static final String DESCRIPTION = "description";

  /**
   * The name of the attribute for the publisher's image.
   */
  public static final String IMAGE = "image";

  /**
   * The name of the attribute for the publisher's address.
   */
  public static final String ADDRESS = "location_address";
  /**
   * The name of the attribute for the city the publisher is located in.
   */
  public static final String CITY = "location_city";
  /**
   * The name of the attribute for the state the publisher is located in.
   */
  public static final String STATE = "location_state";

  /**
   * The name of the attribute for the characters connected to the publisher.
   */
  public static final String CHARACTERS = "characters";
  /**
   * The name of the attribute for the teams connected to the publisher.
   */
  public static final String TEAMS = "teams";
  /**
   * The name of the attribute for the volumes published by the publisher.
   */
  public static final String VOLUMES = "volumes";
  /**
   * The name of the attribute for the story arcs published by the publisher.
   */
  public static final String STORY_ARCS = "story_arcs";

  private PublisherAttribute() {
  }
}
