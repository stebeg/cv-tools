package com.github.stebeg.tool.cv.storyarc;

import com.github.stebeg.tool.cv.Constants;
import com.github.stebeg.tool.cv.search.SearchUrlBuilderImpl;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

/**
 * An implementation for building Comicvine API URLs to retrieve story arc information.
 *
 * @author Steffen Berger
 */
class StoryArcUrlBuilderImpl extends SearchUrlBuilderImpl implements StoryArcUrlBuilder {

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for reading story arcs via Comicvine API.
   */
  static final String API_STORY_ARC_URL_FRAGMENT = "/story_arc/";

  StoryArcUrlBuilderImpl() {
  }

  /**
   * {@inheritDoc}
   *
   * @param parameter {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildStoryArcSearchUrl(final Map<String, String> parameter) throws IOException {
    return super.buildSearchUrl(parameter);
  }

  /**
   * {@inheritDoc}
   *
   * @param storyArcId {@inheritDoc}
   * @param parameter  {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildStoryArcGetUrl(
      final long storyArcId,
      final Map<String, String> parameter) throws IOException {
    try {
      final String url = Constants.API_BASE_URL
          .concat(API_STORY_ARC_URL_FRAGMENT)
          .concat("4045-").concat(String.valueOf(storyArcId))
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
