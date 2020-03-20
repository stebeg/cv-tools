package com.github.stebeg.tool.cv.person;

import com.github.stebeg.tool.cv.Constants;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

/**
 * An implementation for building Comicvine API URLs to retrieve person information.
 *
 * @author Steffen Berger
 */
class PersonUrlBuilderImpl implements PersonUrlBuilder {

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for reading people
   * via Comicvine API.
   */
  static final String API_PERSON_URL_FRAGMENT = "/person/";

  PersonUrlBuilderImpl() {
  }

  /**
   * {@inheritDoc}
   *
   * @param personId  {@inheritDoc}
   * @param parameter {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildPersonGetUrl(
      final long personId,
      final Map<String, String> parameter) throws IOException {
    try {
      final String url = Constants.API_BASE_URL
          .concat(API_PERSON_URL_FRAGMENT)
          .concat("4040-").concat(String.valueOf(personId))
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
