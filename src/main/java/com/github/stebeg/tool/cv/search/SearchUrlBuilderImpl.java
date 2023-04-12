package com.github.stebeg.tool.cv.search;

import com.github.stebeg.tool.cv.Constants;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

/**
 * An implementation for building Comicvine API URLs to search issues, volumes, story arcs, etc. via Comicvine-API.
 *
 * @author Steffen Berger
 */
public class SearchUrlBuilderImpl implements SearchUrlBuilder {

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for searching issues, volumes, story arcs, etc. via Comicvine API.
   */
  static final String API_SEARCH_URL_FRAGMENT = "/search/";

  protected SearchUrlBuilderImpl() {
  }

  /**
   * {@inheritDoc}
   *
   * @param parameter {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildSearchUrl(final Map<String, String> parameter) throws IOException {
    try {
      final URIBuilder uriBuilder = new URIBuilder(Constants.API_BASE_URL.concat(API_SEARCH_URL_FRAGMENT));
      uriBuilder.addParameter(Constants.CLIENT_PARAMETER_NAME, Constants.CLIENT_PARAMETER_VALUE);
      for (final String parameterName : parameter.keySet()) {
        uriBuilder.addParameter(parameterName, parameter.get(parameterName));
      }
      return uriBuilder.build().toURL();
    } catch (URISyntaxException uriSyntaxException) {
      throw new IOException(uriSyntaxException);
    }
  }
}
