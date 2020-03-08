package com.github.stebeg.tool.cv.volume;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.Constants;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class VolumeUrlBuilderImplTest {

  private final VolumeUrlBuilder instance;

  public VolumeUrlBuilderImplTest() {
    this.instance = new VolumeUrlBuilderImpl();
  }

  @Test
  public void testBuildSearchUrl() throws IOException {
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(VolumeUrlBuilderImpl.API_SEARCH_URL_FRAGMENT)
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildVolumeSearchUrl(parameter);
    assertEquals(expPath, result.toString());
  }

  @Test
  public void testBuildVolumeGetUrl() throws IOException {
    final long volumeId = 1234L;
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(VolumeUrlBuilderImpl.API_VOLUME_URL_FRAGMENT)
        .concat("4050-").concat(String.valueOf(volumeId)).concat("/")
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildVolumeGetUrl(volumeId, parameter);
    assertEquals(expPath, result.toString());
  }

}