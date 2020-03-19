package com.github.stebeg.tool.cv.publisher;

import com.github.stebeg.tool.cv.Constants;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

/**
 * An implementation for building Comicvine API URLs to retrieve publisher information.
 *
 * @author Steffen Berger
 */
class PublisherUrlBuilderImpl implements PublisherUrlBuilder {

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for reading
   * publishers via Comicvine API.
   */
  static final String API_PUBLISHER_URL_FRAGMENT = "/publisher/";

  PublisherUrlBuilderImpl() {
  }

  /**
   * {@inheritDoc}
   *
   * @param publisherId {@inheritDoc}
   * @param parameter   {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildPublisherGetUrl(
      final long publisherId,
      final Map<String, String> parameter) throws IOException {
    try {
      final String url = Constants.API_BASE_URL
          .concat(API_PUBLISHER_URL_FRAGMENT)
          .concat("4010-").concat(String.valueOf(publisherId))
          .concat("/");
      final URIBuilder uriBuilder = new URIBuilder(url);
      uriBuilder.addParameter(
          Constants.CLIENT_PARAMETER_NAME,
          Constants.CLIENT_PARAMETER_VALUE);
      for (final String parameterName : parameter.keySet()) {
        uriBuilder.addParameter(parameterName, parameter.get(parameterName));
      }
      return uriBuilder.build().toURL();
    } catch (URISyntaxException uriSyntaxException) {
      throw new IOException(uriSyntaxException);
    }
  }
}
