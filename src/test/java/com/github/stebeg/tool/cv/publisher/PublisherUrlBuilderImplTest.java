package com.github.stebeg.tool.cv.publisher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.Constants;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PublisherUrlBuilderImplTest {

  private final PublisherUrlBuilder instance;

  public PublisherUrlBuilderImplTest() {
    this.instance = new PublisherUrlBuilderImpl();
  }

  @Test
  public void testBuildPublisherGetUrl() throws IOException {
    final long publisherId = 1234L;
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(PublisherUrlBuilderImpl.API_PUBLISHER_URL_FRAGMENT)
        .concat("4010-").concat(String.valueOf(publisherId)).concat("/")
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildPublisherGetUrl(publisherId, parameter);
    assertEquals(expPath, result.toString());
  }
}