package com.github.stebeg.tool.cv.publisher;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * An interface for building Comicvine API URLs to retrieve publisher information.
 *
 * @author Steffen Berger
 */
interface PublisherUrlBuilder {

  /**
   * Builds an URL for retrieving publisher information from the Comicvine API.
   *
   * @param publisherId The ID of the publisher.
   * @param parameter   The additional parameters which will be added to the URL. The keys in this
   *                    map represent the parameter names. The values of this map represent the
   *                    parameter values.
   * @return The URL for retrieving publisher information from the Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildPublisherGetUrl(long publisherId, Map<String, String> parameter) throws IOException;
}
