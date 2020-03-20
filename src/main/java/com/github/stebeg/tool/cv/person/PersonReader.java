package com.github.stebeg.tool.cv.person;

import java.io.IOException;

/**
 * An interface for retrieving people from the Comicvine API.
 *
 * @author Steffen Berger
 */
public interface PersonReader {

  /**
   * Retrieves information for a person from the Comicvine API.
   *
   * @param apiKey   An API key needed for retrieving information from the Comicvine API.
   * @param personId The unique ID of the person to retrieve.
   * @return The response from the Comicvine API containing the team.
   * @throws IOException When the communication with the Comicvine API or reading the information
   *                     fails.
   */
  PersonGetResult getPerson(String apiKey, long personId) throws IOException;
}
