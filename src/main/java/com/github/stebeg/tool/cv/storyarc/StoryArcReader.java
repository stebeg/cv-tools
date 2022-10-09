package com.github.stebeg.tool.cv.storyarc;

import java.io.IOException;

/**
 * An interface for retrieving story arcs from the Comicvine API.
 *
 * @author Steffen Berger
 */
public interface StoryArcReader {

  /**
   * Retrieves information for a story arc from the Comicvine API.
   *
   * @param apiKey     An API key needed for retrieving information from the Comicvine API.
   * @param storyArcId The unique ID of the story arc to retrieve.
   * @return The response from the Comicvine API containing the story arc.
   * @throws IOException When the communication with the Comicvine API or reading the information fails.
   */
  StoryArcGetResult getStoryArc(String apiKey, long storyArcId) throws IOException;

}
