package com.github.stebeg.tool.cv.issue;

import com.github.stebeg.tool.cv.Constants;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

/**
 * An implementation for building Comicvine API URLs to retrieve issue information.
 *
 * @author Steffen Berger
 */
class IssueUrlBuilderImpl implements IssueUrlBuilder {

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for retrieving
   * issue information for a volume from the Comicvine API.
   */
  static final String API_ISSUES_URL_FRAGMENT = "/issues/";

  /**
   * The URL fragment appended to {@link Constants#API_BASE_URL} to build the URL for retrieving
   * issue information from the Comicvine API.
   */
  static final String API_ISSUE_URL_FRAGMENT = "/issue/";

  IssueUrlBuilderImpl() {
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
  public URL buildIssuesGetUrl(
      final long volumeId,
      final Map<String, String> parameter) throws IOException {
    final String filterParameterName = "filter";
    final String filterParameterValue = "volume:".concat(String.valueOf(volumeId));
    try {
      final String url = Constants.API_BASE_URL
          .concat(API_ISSUES_URL_FRAGMENT);
      final URIBuilder uriBuilder = new URIBuilder(url);
      uriBuilder.addParameter(
          Constants.CLIENT_PARAMETER_NAME,
          Constants.CLIENT_PARAMETER_VALUE);
      for (final String parameterName : parameter.keySet()) {
        uriBuilder.addParameter(parameterName, parameter.get(parameterName));
      }
      uriBuilder.addParameter(filterParameterName, filterParameterValue);
      return uriBuilder.build().toURL();
    } catch (URISyntaxException uriSyntaxException) {
      throw new IOException(uriSyntaxException);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @param issueId   {@inheritDoc}
   * @param parameter {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public URL buildIssueGetUrl(
      final long issueId,
      final Map<String, String> parameter) throws IOException {
    try {
      final String url = Constants.API_BASE_URL
          .concat(API_ISSUE_URL_FRAGMENT)
          .concat("4000-").concat(String.valueOf(issueId))
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
