package com.github.stebeg.comicvine;

import com.github.stebeg.comicvine.character.CharacterRetriever;
import com.github.stebeg.comicvine.common.request.UrlConnectionBuilder;
import com.github.stebeg.comicvine.common.request.UrlContentReader;
import com.github.stebeg.comicvine.location.LocationRetriever;
import com.github.stebeg.comicvine.publisher.PublisherRetriever;
import com.github.stebeg.comicvine.storyarc.StoryArcRetriever;
import com.github.stebeg.comicvine.team.TeamRetriever;
import com.google.gson.Gson;

/**
 * Provides access to the Comicvine API.
 */
public class ComicvineTools {

  private static final UrlContentReader URL_CONTENT_READER = new UrlContentReader(new UrlConnectionBuilder());
  private static final Gson GSON = new Gson();

  private static final CharacterRetriever CHARACTER_RETRIEVER = new CharacterRetriever(URL_CONTENT_READER, GSON);
  private static final TeamRetriever TEAM_RETRIEVER = new TeamRetriever(URL_CONTENT_READER, GSON);
  private static final PublisherRetriever PUBLISHER_RETRIEVER = new PublisherRetriever(URL_CONTENT_READER, GSON);
  private static final LocationRetriever LOCATION_RETRIEVER = new LocationRetriever(URL_CONTENT_READER, GSON);
  private static final StoryArcRetriever STORY_ARC_RETRIEVER = new StoryArcRetriever(URL_CONTENT_READER, GSON);

  /**
   * Retrieves a singleton instance of the {@link CharacterRetriever}.
   *
   * @return A singleton instance of the {@link CharacterRetriever}.
   */
  public static CharacterRetriever getCharacterRetriever() {
    return CHARACTER_RETRIEVER;
  }

  /**
   * Retrieves a singleton instance of the {@link TeamRetriever}.
   *
   * @return A singleton instance of the {@link TeamRetriever}.
   */
  public static TeamRetriever getTeamRetriever() {
    return TEAM_RETRIEVER;
  }

  /**
   * Retrieves a singleton instance of the {@link PublisherRetriever}.
   *
   * @return A singleton instance of the {@link PublisherRetriever}.
   */
  public static PublisherRetriever getPublisherRetriever() {
    return PUBLISHER_RETRIEVER;
  }

  /**
   * Retrieves a singleton instance of the {@link LocationRetriever}.
   *
   * @return A singleton instance of the {@link LocationRetriever}.
   */
  public static LocationRetriever getLocationRetriever() {
    return LOCATION_RETRIEVER;
  }

  /**
   * Retrieves a singleton instance of the {@link StoryArcRetriever}.
   *
   * @return A singleton instance of the {@link StoryArcRetriever}.
   */
  public static StoryArcRetriever getStoryArcRetriever() {
    return STORY_ARC_RETRIEVER;
  }

}
