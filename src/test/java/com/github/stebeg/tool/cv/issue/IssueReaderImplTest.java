package com.github.stebeg.tool.cv.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.stebeg.tool.cv.character.SimpleCharacter;
import com.github.stebeg.tool.cv.common.UrlConnectionBuilder;
import com.github.stebeg.tool.cv.common.UrlContentReader;
import com.github.stebeg.tool.cv.common.UrlContentReaderImpl;
import com.github.stebeg.tool.cv.image.Image;
import com.github.stebeg.tool.cv.person.SimplePersonWithRole;
import com.github.stebeg.tool.cv.team.SimpleTeam;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;

/**
 * @author Steffen Berger
 */
public class IssueReaderImplTest {

  private final IssueUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final IssueReaderImpl instance;

  public IssueReaderImplTest() {
    this.urlBuilderMock = mock(IssueUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new IssueReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetVolumeIssues() throws IOException {
    final long volumeId = 123L;
    final String apiKey = "1234567890abcdef";
    final IssuesGetResult expResult = new IssuesGetResult(1, 2, 205);

    final Issue expResultIssue1 = new Issue(4869L, "1");
    expResultIssue1.setName("The Planet of Doomed Men; Menace of the Giant Puppet!");
    expResultIssue1.setDescription("<h3>The Planet of Doomed Men</h3>");
    expResultIssue1.setCoverDate("1960-08-31");
    expResultIssue1.setInStoreDate("1960-05-24");
    expResultIssue1.setImage(new Image(
        "https://comicvine.gamespot.com/api/image/original/4457-2013-4869-1-green-lantern.jpg",
        "https://comicvine.gamespot.com/api/image/scale_avatar/4457-2013-4869-1-green-lantern.jpg"
    ));

    final Issue expResultIssue2 = new Issue(4944L, "2");
    expResultIssue2
        .setName("The Secret of the Golden Thunderbolts!; Riddle of the Frozen Ghost Town!");
    expResultIssue2.setDescription("<h3>Secret of the Golden Thunderbolts</h3>");
    expResultIssue2.setCoverDate("1960-10-01");
    expResultIssue2.setInStoreDate("1960-07-26");
    expResultIssue2.setImage(new Image(
        "https://comicvine.gamespot.com/api/image/original/4529-2013-4944-1-green-lantern.jpg",
        "https://comicvine.gamespot.com/api/image/scale_avatar/4529-2013-4944-1-green-lantern.jpg"
    ));

    final URL url = getClass().getResource("/issue/issues-get-example.json");
    when(this.urlBuilderMock.buildIssuesGetUrl(eq(volumeId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final IssuesGetResult result = this.instance.getVolumeIssues(apiKey, volumeId);
    assertEquals(expResult.getStatusCode(), result.getStatusCode());
    assertEquals(expResult.getNumberOfPageResults(), result.getNumberOfPageResults());
    assertEquals(expResult.getNumberOfTotalResults(), result.getNumberOfTotalResults());

    final int expResultItemCount = 2;
    assertEquals(expResultItemCount, result.getResult().size());

    final Issue resultIssue1 = result.getResult().get(0);
    assertEquals(expResultIssue1.getId(), resultIssue1.getId());
    assertEquals(expResultIssue1.getIssueNumber(), resultIssue1.getIssueNumber());
    assertEquals(expResultIssue1.getName(), resultIssue1.getName());
    assertEquals(expResultIssue1.getDescription(), resultIssue1.getDescription());
    assertEquals(expResultIssue1.getCoverDate(), resultIssue1.getCoverDate());
    assertEquals(expResultIssue1.getInStoreDate(), resultIssue1.getInStoreDate());

    assertEquals(expResultIssue1.getImage().getOriginalUrl(),
        resultIssue1.getImage().getOriginalUrl());
    assertEquals(expResultIssue1.getImage().getThumbUrl(), resultIssue1.getImage().getThumbUrl());

    final Issue resultIssue2 = result.getResult().get(1);
    assertEquals(expResultIssue2.getId(), resultIssue2.getId());
    assertEquals(expResultIssue2.getIssueNumber(), resultIssue2.getIssueNumber());
    assertEquals(expResultIssue2.getName(), resultIssue2.getName());
    assertEquals(expResultIssue2.getDescription(), resultIssue2.getDescription());
    assertEquals(expResultIssue2.getCoverDate(), resultIssue2.getCoverDate());
    assertEquals(expResultIssue2.getInStoreDate(), resultIssue2.getInStoreDate());

    assertEquals(expResultIssue2.getImage().getOriginalUrl(),
        resultIssue2.getImage().getOriginalUrl());
    assertEquals(expResultIssue2.getImage().getThumbUrl(), resultIssue2.getImage().getThumbUrl());
  }

  @Test
  public void testGetIssue() throws IOException {
    final long issueId = 310551L;
    final String apiKey = "1234567890abcdef";
    final Issue expResultIssue = new Issue(issueId, "5");
    expResultIssue.setName("Sinestro, Part Five");
    expResultIssue.setDescription(
        "<p><i>The conclusion to Sinestro and Hal Jordan's invasion of the planet Korugar!</i></p>");
    expResultIssue.setInStoreDate("2012-01-11");
    expResultIssue.setCoverDate("2012-03-26");

    expResultIssue.setImage(new Image(
        "https://comicvine.gamespot.com/api/image/original/2175391-green_lantern__05__2011_.jpg",
        "https://comicvine.gamespot.com/api/image/scale_avatar/2175391-green_lantern__05__2011_.jpg"
    ));
    expResultIssue.getCharacters().add(new SimpleCharacter(18276L, "Carol Ferris"));
    expResultIssue.getCharacters().add(new SimpleCharacter(6951L, "Ganthet"));
    expResultIssue.getCharacters().add(new SimpleCharacter(11202L, "Hal Jordan"));
    expResultIssue.getCharacters().add(new SimpleCharacter(10448L, "Sinestro"));

    expResultIssue.getTeams().add(new SimpleTeam(6992L, "Green Lantern Corps"));
    expResultIssue.getTeams().add(new SimpleTeam(42352L, "Sinestro Corps"));

    expResultIssue.getPersonList()
        .add(new SimplePersonWithRole(1533, "Doug Mahnke", "penciler, cover"));
    expResultIssue.getPersonList().add(new SimplePersonWithRole(40439, "Geoff Johns", "writer"));

    final URL url = getClass().getResource("/issue/issue-get-example.json");
    when(this.urlBuilderMock.buildIssueGetUrl(eq(issueId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final IssueGetResult expResult = new IssueGetResult(1, expResultIssue);
    final IssueGetResult result = this.instance.getIssue(apiKey, issueId);
    assertEquals(expResult.getStatusCode(), result.getStatusCode());

    final Issue resultIssue = result.getResult();
    assertEquals(expResultIssue.getId(), resultIssue.getId());
    assertEquals(expResultIssue.getIssueNumber(), resultIssue.getIssueNumber());
    assertEquals(expResultIssue.getName(), resultIssue.getName());
    assertEquals(expResultIssue.getDescription(), resultIssue.getDescription());
    assertEquals(expResultIssue.getCoverDate(), resultIssue.getCoverDate());
    assertEquals(expResultIssue.getInStoreDate(), resultIssue.getInStoreDate());

    assertEquals(expResultIssue.getImage().getOriginalUrl(),
        resultIssue.getImage().getOriginalUrl());
    assertEquals(expResultIssue.getImage().getThumbUrl(), resultIssue.getImage().getThumbUrl());

    assertEquals(expResultIssue.getCharacters().size(), resultIssue.getCharacters().size());
    for (int index = 0; index < resultIssue.getCharacters().size(); index++) {
      assertEquals(expResultIssue.getCharacters().get(index).getId(),
          resultIssue.getCharacters().get(index).getId());
      assertEquals(expResultIssue.getCharacters().get(index).getName(),
          resultIssue.getCharacters().get(index).getName());
    }

    assertEquals(expResultIssue.getTeams().size(), resultIssue.getTeams().size());
    for (int index = 0; index < resultIssue.getTeams().size(); index++) {
      assertEquals(expResultIssue.getTeams().get(index).getId(),
          resultIssue.getTeams().get(index).getId());
      assertEquals(expResultIssue.getTeams().get(index).getName(),
          resultIssue.getTeams().get(index).getName());
    }

    assertEquals(expResultIssue.getPersonList().size(), resultIssue.getPersonList().size());
    for (int index = 0; index < resultIssue.getPersonList().size(); index++) {
      assertEquals(expResultIssue.getPersonList().get(index).getId(),
          resultIssue.getPersonList().get(index).getId());
      assertEquals(expResultIssue.getPersonList().get(index).getName(),
          resultIssue.getPersonList().get(index).getName());
      assertEquals(expResultIssue.getPersonList().get(index).getRole(),
          resultIssue.getPersonList().get(index).getRole());
    }
  }
}
