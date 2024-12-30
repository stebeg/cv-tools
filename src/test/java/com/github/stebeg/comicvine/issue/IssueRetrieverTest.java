package com.github.stebeg.comicvine.issue;

import com.github.stebeg.comicvine.character.CharacterCredit;
import com.github.stebeg.comicvine.common.request.UrlContentReader;
import com.github.stebeg.comicvine.common.response.ApiListResponse;
import com.github.stebeg.comicvine.common.response.ApiResponse;
import com.github.stebeg.comicvine.common.response.StatusCode;
import com.github.stebeg.comicvine.image.Image;
import com.github.stebeg.comicvine.location.LocationCredit;
import com.github.stebeg.comicvine.person.PersonCreditWithRoles;
import com.github.stebeg.comicvine.storyarc.StoryArcCredit;
import com.github.stebeg.comicvine.team.TeamCredit;
import com.github.stebeg.comicvine.volume.VolumeCredit;
import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IssueRetrieverTest {

  private final UrlContentReader urlContentReaderMock;
  private final IssueRetriever instance;

  public IssueRetrieverTest() {
    this.urlContentReaderMock = mock(UrlContentReader.class);
    this.instance = new IssueRetriever(urlContentReaderMock, new Gson());
  }

  @Test
  public void testGetIssueById() throws Exception {
    final long issueId = 111265L;
    final GetIssueByIdRequest request = new GetIssueByIdRequest("12345", issueId);

    final URL url = getClass().getResource("/comicvine/issue/get-issue-by-id-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final Issue expResult = new Issue(issueId, "Airborne");
    expResult.setIssueNumber("1");
    expResult.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>");
    expResult.setCoverDate("2005-07-01");
    expResult.setInStoreDate("2005-05-25");
    expResult.setVolume(new VolumeCredit(18216, "Green Lantern"));
    expResult.setWebUrl("https://comicvine.gamespot.com/green-lantern-1-airborne/4000-111265/");

    expResult.setCharacterList(ImmutableList.of(
        new CharacterCredit(22634, "Abin Sur"),
        new CharacterCredit(11202, "Hal Jordan"),
        new CharacterCredit(42891, "Jillian Pearlman")
    ));

    expResult.setTeamList(ImmutableList.of(
        new TeamCredit(6992, "Green Lantern Corps"),
        new TeamCredit(55857, "The Manhunters")
    ));

    expResult.setLocationList(ImmutableList.of(
        new LocationCredit(56427, "3600 Sectors of Space"),
        new LocationCredit(55716, "California")
    ));

    expResult.setStoryArcList(ImmutableList.of(
        new StoryArcCredit(54588, "\"Green Lantern\" Rebirth")
    ));

    expResult.setCreatorList(ImmutableList.of(
        new PersonCreditWithRoles(10945, "Alex Ross", "inker, colorist, cover"),
        new PersonCreditWithRoles(3590, "Carlos Pacheco", "penciler, cover"),
        new PersonCreditWithRoles(9317, "Ethan Van Sciver", "penciler, inker")
    ));

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/5/56044/1774825-green_lantern__2005__3rd_series__001b.jpeg");
    image.setImageTags("All Images");
    expResult.setImage(image);

    final ApiResponse<Issue> result = this.instance.getIssueById(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expResult.toString(), result.getResult().toString());
  }

  @Test
  public void testGetIssues() throws Exception {
    final String filter = "name:Green Lantern";
    final GetIssueListRequest request = new GetIssueListRequest("12345", filter).withLimit(3);

    final URL url = getClass().getResource("/comicvine/issue/get-issues-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final IssueListItem issueListItem1 = new IssueListItem(4466, "S.O.S. Green Lantern / Secret of the Flaming Sphere / Menace of the Runaway Missile!");
    issueListItem1.setIssueNumber("22");
    issueListItem1.setCoverDate("1959-10-31");
    issueListItem1.setDescription("<p>Abin Sur lay dying in the desert next to his crashed ship. He uses the Power Battery to send the ring out to find help.</p>");
    issueListItem1.setVolume(new VolumeCredit(1770, "Showcase"));
    issueListItem1.setWebUrl("https://comicvine.gamespot.com/showcase-22-sos-green-lantern-secret-of-the-flamin/4000-4466/");

    final Image issueListItem1Image = new Image();
    issueListItem1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/4/4066-1770-4466-1-showcase.jpg");
    issueListItem1Image.setImageTags("All Images");
    issueListItem1.setImage(issueListItem1Image);

    final IssueListItem issueListItem2 = new IssueListItem(5536, "The Battle of the Power Rings!; Green Lantern's Brother Act");
    issueListItem2.setIssueNumber("9");
    issueListItem2.setCoverDate("1961-12-01");
    issueListItem2.setInStoreDate("1961-09-26");
    issueListItem2.setDescription("<p>Hal is flying over Coast City when he notices that his ring is losing energy and he doesn't know why.</p>");
    issueListItem2.setVolume(new VolumeCredit(2839, "Green Lantern"));
    issueListItem2.setWebUrl("https://comicvine.gamespot.com/green-lantern-9-the-battle-of-the-power-rings-gree/4000-5536/");

    final Image issueListItem2Image = new Image();
    issueListItem2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/6/67663/4346358-09.jpg");
    issueListItem2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/6/67663/4346358-09.jpg");
    issueListItem2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/6/67663/4346358-09.jpg");
    issueListItem2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/6/67663/4346358-09.jpg");
    issueListItem2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/6/67663/4346358-09.jpg");
    issueListItem2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/6/67663/4346358-09.jpg");
    issueListItem2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/6/67663/4346358-09.jpg");
    issueListItem2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/6/67663/4346358-09.jpg");
    issueListItem2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/6/67663/4346358-09.jpg");
    issueListItem2Image.setImageTags("All Images");
    issueListItem2.setImage(issueListItem2Image);

    final IssueListItem issueListItem3 = new IssueListItem(5778, "The Strange Trial Of Green Lantern!/The Trail Of The Missing Ring!");
    issueListItem3.setIssueNumber("11");
    issueListItem3.setCoverDate("1962-03-01");
    issueListItem3.setInStoreDate("1962-01-04");
    issueListItem3.setDescription("<p>The Green Lantern of Sector 2814, Hal Jordan, stands trial before a court of his peers.</p>");
    issueListItem3.setVolume(new VolumeCredit(2839, "Green Lantern"));
    issueListItem3.setWebUrl("https://comicvine.gamespot.com/green-lantern-11-the-strange-trial-of-green-lanter/4000-5778/");

    final Image issueListItem3Image = new Image();
    issueListItem3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/4/5297-2013-5778-1-green-lantern.jpg");
    issueListItem3Image.setImageTags("All Images");
    issueListItem3.setImage(issueListItem3Image);

    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 208;
    final int expLimit = 3, expOffset = 0;
    final List<IssueListItem> expResult = ImmutableList.of(issueListItem1, issueListItem2, issueListItem3);

    final ApiListResponse<IssueListItem> result = this.instance.getIssues(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

  @Test
  public void testSearchIssues() throws Exception {
    final String searchText = "Green Lantern";
    final SearchIssuesRequest request = new SearchIssuesRequest("12345", searchText).withLimit(3);

    final URL url = getClass().getResource("/comicvine/issue/search-issues-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final IssueListItem issueListItem1 = new IssueListItem(982571, null);
    issueListItem1.setIssueNumber("121");
    issueListItem1.setCoverDate("2022-10-01");
    issueListItem1.setVolume(new VolumeCredit(78611, "Green Lantern"));
    issueListItem1.setWebUrl("https://comicvine.gamespot.com/green-lantern-121/4000-982571/");

    final Image issueListItem1Image = new Image();
    issueListItem1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11/110017/8901257-2022-10-18-0001.jpg");
    issueListItem1Image.setImageTags("All Images");
    issueListItem1.setImage(issueListItem1Image);

    final IssueListItem issueListItem2 = new IssueListItem(982569, null);
    issueListItem2.setIssueNumber("119");
    issueListItem2.setCoverDate("2022-08-01");
    issueListItem2.setVolume(new VolumeCredit(78611, "Green Lantern"));
    issueListItem2.setWebUrl("https://comicvine.gamespot.com/green-lantern-119/4000-982569/");

    final Image issueListItem2Image = new Image();
    issueListItem2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11/110017/8901255-grelan0001.jpg");
    issueListItem2Image.setImageTags("All Images");
    issueListItem2.setImage(issueListItem2Image);

    final IssueListItem issueListItem3 = new IssueListItem(982570, null);
    issueListItem3.setIssueNumber("120");
    issueListItem3.setCoverDate("2022-09-01");
    issueListItem3.setVolume(new VolumeCredit(78611, "Green Lantern"));
    issueListItem3.setWebUrl("https://comicvine.gamespot.com/green-lantern-120/4000-982570/");

    final Image issueListItem3Image = new Image();
    issueListItem3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11/110017/8901256-gl-mm-dd-0001.jpg");
    issueListItem3Image.setImageTags("All Images");
    issueListItem3.setImage(issueListItem3Image);

    final List<IssueListItem> expResult = ImmutableList.of(issueListItem1, issueListItem2, issueListItem3);
    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 3618;
    final int expLimit = 3, expOffset = 0;

    final ApiListResponse<IssueListItem> result = this.instance.searchIssues(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }
}