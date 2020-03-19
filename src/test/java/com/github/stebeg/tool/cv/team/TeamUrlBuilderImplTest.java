package com.github.stebeg.tool.cv.team;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.Constants;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TeamUrlBuilderImplTest {

  private final TeamUrlBuilder instance;

  public TeamUrlBuilderImplTest() {
    this.instance = new TeamUrlBuilderImpl();
  }

  @Test
  public void testBuildTeamGetUrl() throws IOException {
    final long teamId = 1234L;
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(TeamUrlBuilderImpl.API_TEAM_URL_FRAGMENT)
        .concat("4060-").concat(String.valueOf(teamId)).concat("/")
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildTeamGetUrl(teamId, parameter);
    assertEquals(expPath, result.toString());
  }
}