package com.github.stebeg.tool.cv.team;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.stebeg.tool.cv.AbstractJsonComparisonTest;
import com.github.stebeg.tool.cv.common.UrlConnectionBuilder;
import com.github.stebeg.tool.cv.common.UrlContentReader;
import com.github.stebeg.tool.cv.common.UrlContentReaderImpl;
import com.google.gson.Gson;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;

public class TeamReaderImplTest extends AbstractJsonComparisonTest {

  private final TeamUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final TeamReader instance;

  public TeamReaderImplTest() {
    this.urlBuilderMock = mock(TeamUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new TeamReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetTeam() throws Exception {
    final long teamId = 6992L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/team/team-get-example.json");
    when(this.urlBuilderMock.buildTeamGetUrl(eq(teamId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final TeamGetResult result = this.instance.getTeam(apiKey, teamId);
    assertJsonEquals("/team/team-get-example-result.json", result);
  }
}