package com.github.stebeg.tool.cv.volume;

import com.github.stebeg.tool.cv.Constants;
import com.github.stebeg.tool.cv.search.SearchUrlBuilderImpl;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

/**
 * An implementation for building Comicvine API URLs to retrieve volume information.
 *
 * @author Steffen Berger
 */
class VolumeUrlBuilderImpl extends SearchUrlBuilderImpl implements VolumeUrlBuilder {

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for retrieving volume information from the Comicvine API.
   */
  static final String API_VOLUME_URL_FRAGMENT = "/volume/";

  VolumeUrlBuilderImpl() {
  }

  /**
   * {@inheritDoc}
   *
   * @param parameter {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildVolumeSearchUrl(final Map<String, String> parameter) throws IOException {
    return super.buildSearchUrl(parameter);
  }

  /**
   * {@inheritDoc}
   *
   * @param volumeId  {@inheritDoc}
   * @param parameter {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildVolumeGetUrl(
      final long volumeId,
      final Map<String, String> parameter) throws IOException {
    try {
      final String url = Constants.API_BASE_URL
          .concat(API_VOLUME_URL_FRAGMENT)
          .concat("4050-").concat(String.valueOf(volumeId))
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
