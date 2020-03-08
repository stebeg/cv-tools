package com.github.stebeg.tool.cv.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.Constants;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class IssueUrlBuilderImplTest {

  private final IssueUrlBuilder instance;

  public IssueUrlBuilderImplTest() {
    this.instance = new IssueUrlBuilderImpl();
  }

  @Test
  public void testBuildIssuesGetUrl() throws IOException {
    final long volumeId = 1234L;
    final String paramName = "foo", paramValue = "bar";
    final String filterParamName = "filter", filterParamValue = "volume%3A1234";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(IssueUrlBuilderImpl.API_ISSUES_URL_FRAGMENT)
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue)
        .concat("&").concat(filterParamName).concat("=").concat(filterParamValue);

    final URL result = this.instance.buildIssuesGetUrl(volumeId, parameter);
    assertEquals(expPath, result.toString());
  }

  @Test
  public void testBuildIssueGetUrl() throws IOException {
    final long issueId = 1234L;
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(IssueUrlBuilderImpl.API_ISSUE_URL_FRAGMENT)
        .concat("4000-").concat(String.valueOf(issueId)).concat("/")
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildIssueGetUrl(issueId, parameter);
    assertEquals(expPath, result.toString());
  }

}