package com.github.stebeg.tool.cv.volume;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * An interface for building Comicvine API URLs to retrieve volume information.
 *
 * @author Steffen Berger
 */
interface VolumeUrlBuilder {

  /**
   * Builds an URL for searching volumes via Comicvine API.
   *
   * @param parameter The query parameters which will be added to the search URL. The keys in this
   *                  map represent the parameter names. The values of this map represent the
   *                  parameter values.
   * @return The URL for searching volumes via Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildVolumeSearchUrl(Map<String, String> parameter) throws IOException;

  /**
   * Builds an URL for retrieving volume information from the Comicvine API.
   *
   * @param volumeId  The ID of the volume.
   * @param parameter The additional parameters which will be added to the URL. The keys in this map
   *                  represent the parameter names. The values of this map represent the parameter
   *                  values.
   * @return The URL for retrieving volume information from the Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildVolumeGetUrl(long volumeId, Map<String, String> parameter) throws IOException;

}
