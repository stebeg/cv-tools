package com.github.stebeg.tool.cv.team;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * An interface for building Comicvine API URLs to retrieve team information.
 *
 * @author Steffen Berger
 */
interface TeamUrlBuilder {

  /**
   * Builds a URL for retrieving team information from the Comicvine API.
   *
   * @param teamId    The ID of the team.
   * @param parameter The additional parameters which will be added to the URL. The keys in this map represent the parameter names. The values of this map represent the parameter
   *                  values.
   * @return The URL for retrieving team information from the Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildTeamGetUrl(long teamId, Map<String, String> parameter) throws IOException;

}
