package com.github.stebeg.tool.cv.team;

import java.io.IOException;

/**
 * An interface for retrieving teams from the Comicvine API.
 *
 * @author Steffen Berger
 */
public interface TeamReader {

  /**
   * Retrieves information for a team from the Comicvine API.
   *
   * @param apiKey An API key needed for retrieving information from the Comicvine API.
   * @param teamId The unique ID of the team to retrieve.
   * @return The response from the Comicvine API containing the team.
   * @throws IOException When the communication with the Comicvine API or reading the information
   *                     fails.
   */
  TeamGetResult getTeam(String apiKey, long teamId) throws IOException;

}
