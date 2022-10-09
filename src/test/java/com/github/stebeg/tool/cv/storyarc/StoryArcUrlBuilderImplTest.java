package com.github.stebeg.tool.cv.storyarc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.Constants;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class StoryArcUrlBuilderImplTest {

  private final StoryArcUrlBuilder instance;

  public StoryArcUrlBuilderImplTest() {
    this.instance = new StoryArcUrlBuilderImpl();
  }

  @Test
  public void testBuildStoryArcGetUrl() throws IOException {
    final long storyArcId = 1234L;
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(StoryArcUrlBuilderImpl.API_STORY_ARC_URL_FRAGMENT)
        .concat("4045-").concat(String.valueOf(storyArcId)).concat("/")
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildStoryArcGetUrl(storyArcId, parameter);
    assertEquals(expPath, result.toString());
  }

}