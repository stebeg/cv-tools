package com.github.stebeg.tool.cv.character;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * An interface for building Comicvine API URLs to retrieve character information.
 *
 * @author Steffen Berger
 */
interface CharacterUrlBuilder {

  /**
   * Builds an URL for retrieving character information from the Comicvine API.
   *
   * @param characterId The ID of the character.
   * @param parameter   The additional parameters which will be added to the URL. The keys in this
   *                    map represent the parameter names. The values of this map represent the
   *                    parameter values.
   * @return The URL for retrieving character information from the Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildCharacterGetUrl(long characterId, Map<String, String> parameter) throws IOException;

}
