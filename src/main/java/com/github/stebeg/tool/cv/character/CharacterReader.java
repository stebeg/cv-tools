package com.github.stebeg.tool.cv.character;

import java.io.IOException;

/**
 * An interface for retrieving characters from the Comicvine API.
 *
 * @author Steffen Berger
 */
public interface CharacterReader {

  /**
   * Retrieves information for a character from the Comicvine API.
   *
   * @param apiKey      An API key needed for retrieving information from the Comicvine API.
   * @param characterId The unique ID of the character to retrieve.
   * @return The response from the Comicvine API containing the character.
   * @throws IOException When the communication with the Comicvine API or reading the information
   *                     fails.
   */
  CharacterGetResult getCharacter(String apiKey, long characterId) throws IOException;
}
