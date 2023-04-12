package com.github.stebeg.tool.cv.search;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public interface SearchUrlBuilder {

  /**
   * Builds a URL for searching issues, volumes, story arcs, etc. via Comicvine API.
   *
   * @param parameter The query parameters which will be added to the search URL. The keys in this map represent the parameter names. The values of this map represent the parameter
   *                  values.
   * @return The URL for searching via Comicvine API.
   * @throws IOException When building the URL fails.
   */
  URL buildSearchUrl(Map<String, String> parameter) throws IOException;

}
