package com.github.stebeg.tool.cv.storyarc;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * An interface for building Comicvine API URLs to retrieve story arc information.
 *
 * @author Steffen Berger
 */
public interface StoryArcUrlBuilder {

  /**
   * Builds a URL for searching story arcs via Comicvine API.
   *
   * @param parameter The query parameters which will be added to the search URL. The keys in this map represent the parameter names. The values of this map represent the parameter
   *                  values.
   * @return The URL for searching story arcs via Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildStoryArcSearchUrl(Map<String, String> parameter) throws IOException;

  /**
   * Builds a URL for retrieving story arc information from the Comicvine API.
   *
   * @param storyArcId The ID of the story arc.
   * @param parameter  The additional parameters which will be added to the URL. The keys in this map represent the parameter names. The values of this map represent the parameter
   *                   values.
   * @return The URL for retrieving story arc information from the Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildStoryArcGetUrl(long storyArcId, Map<String, String> parameter) throws IOException;

}
