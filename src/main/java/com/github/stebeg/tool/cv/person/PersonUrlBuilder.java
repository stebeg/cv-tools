package com.github.stebeg.tool.cv.person;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * An interface for building Comicvine API URLs to retrieve person information.
 *
 * @author Steffen Berger
 */
interface PersonUrlBuilder {

  /**
   * Builds an URL for retrieving person information from the Comicvine API.
   *
   * @param personId  The ID of the person.
   * @param parameter The additional parameters which will be added to the URL. The keys in this map
   *                  represent the parameter names. The values of this map represent the parameter
   *                  values.
   * @return The URL for retrieving person information from the Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildPersonGetUrl(long personId, Map<String, String> parameter) throws IOException;
}
