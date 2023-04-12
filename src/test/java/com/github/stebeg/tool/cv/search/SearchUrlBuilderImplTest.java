package com.github.stebeg.tool.cv.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.Constants;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SearchUrlBuilderImplTest {

  private SearchUrlBuilderImpl instance;

  public SearchUrlBuilderImplTest() {
    this.instance = new SearchUrlBuilderImpl();
  }

  @Test
  public void testBuildSearchUrl() throws IOException {
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(SearchUrlBuilderImpl.API_SEARCH_URL_FRAGMENT)
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildSearchUrl(parameter);
    assertEquals(expPath, result.toString());
  }
}