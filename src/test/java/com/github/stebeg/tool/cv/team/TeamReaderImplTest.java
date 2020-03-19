package com.github.stebeg.tool.cv.team;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.stebeg.tool.cv.common.UrlConnectionBuilder;
import com.github.stebeg.tool.cv.common.UrlContentReader;
import com.github.stebeg.tool.cv.common.UrlContentReaderImpl;
import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.publisher.SimplePublisher;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;

public class TeamReaderImplTest {

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
  public void testGetTeam() throws IOException {
    final long teamId = 6992L;
    final String apiKey = "1234567890abcdef";

    final Team expResultTeam = new Team(teamId, "Green Lantern Corps");
    expResultTeam.setDescription(
        "<h2>Origin</h2><p>At the beginning of the universe, the population of the planet <a href=\"../../maltus/34-56204/\" rel=\"nofollow\">Maltus</a> evolved into powerful and highly intelligent beings.</p>");
    expResultTeam.setSummary(
        "The Green Lantern Corps is an intergalactic police force dedicated to the promotion of order and democracy throughout the universe. Each Green Lantern member protects a sector and it is their duty to defend it from any possible threat.");
    expResultTeam.setPublisher(new SimplePublisher(10, "DC Comics"));
    expResultTeam.setImage(new Image(
        "https://comicvine1.cbsistatic.com/uploads/original/11114/111147698/4849177-crd-xiywuaaqnca.jpg",
        "https://comicvine1.cbsistatic.com/uploads/scale_avatar/11114/111147698/4849177-crd-xiywuaaqnca.jpg"));

    final TeamGetResult expResult = new TeamGetResult(1, expResultTeam);

    final URL url = getClass().getResource("/team/team-get-example.json");
    when(this.urlBuilderMock.buildTeamGetUrl(eq(teamId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final TeamGetResult result = this.instance.getTeam(apiKey, teamId);
    assertEquals(expResult.getStatusCode(), result.getStatusCode());
    assertNotNull(result.getResult());

    final Team team = result.getResult();
    assertEquals(expResultTeam.getId(), team.getId());
    assertEquals(expResultTeam.getName(), team.getName());
    assertEquals(expResultTeam.getDescription(), team.getDescription());
    assertEquals(expResultTeam.getSummary(), team.getSummary());

    assertEquals(expResultTeam.getPublisher().getId(), team.getPublisher().getId());
    assertEquals(expResultTeam.getPublisher().getName(), team.getPublisher().getName());

    assertEquals(
        expResultTeam.getImage().getOriginalUrl(),
        team.getImage().getOriginalUrl());
    assertEquals(expResultTeam.getImage().getThumbUrl(), team.getImage().getThumbUrl());
  }
}