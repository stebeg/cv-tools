package com.github.stebeg.tool.cv.character;

import com.github.stebeg.tool.cv.Constants;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

/**
 * An implementation for building Comicvine API URLs to retrieve character information.
 *
 * @author Steffen Berger
 */
class CharacterUrlBuilderImpl implements CharacterUrlBuilder {

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for searching
   * volumes via Comicvine API.
   */
  static final String API_CHARACTER_URL_FRAGMENT = "/character/";

  CharacterUrlBuilderImpl() {
  }

  /**
   * {@inheritDoc}
   *
   * @param characterId {@inheritDoc}
   * @param parameter   {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildCharacterGetUrl(
      final long characterId,
      final Map<String, String> parameter) throws IOException {
    try {
      final String url = Constants.API_BASE_URL
          .concat(API_CHARACTER_URL_FRAGMENT)
          .concat("4005-").concat(String.valueOf(characterId))
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
