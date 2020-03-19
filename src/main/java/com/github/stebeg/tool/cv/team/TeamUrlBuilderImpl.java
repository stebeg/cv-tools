package com.github.stebeg.tool.cv.team;

import com.github.stebeg.tool.cv.Constants;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

class TeamUrlBuilderImpl implements TeamUrlBuilder {

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for searching
   * volumes via Comicvine API.
   */
  static final String API_TEAM_URL_FRAGMENT = "/team/";

  TeamUrlBuilderImpl() {
  }

  /**
   * {@inheritDoc}
   *
   * @param teamId    {@inheritDoc}
   * @param parameter {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildTeamGetUrl(
      final long teamId,
      final Map<String, String> parameter) throws IOException {
    try {
      final String url = Constants.API_BASE_URL
          .concat(API_TEAM_URL_FRAGMENT)
          .concat("4060-").concat(String.valueOf(teamId))
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
