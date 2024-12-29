package com.github.stebeg.comicvine.storyarc;

import com.github.stebeg.comicvine.common.request.UrlContentReader;
import com.github.stebeg.comicvine.common.response.ApiListResponse;
import com.github.stebeg.comicvine.common.response.ApiResponse;
import com.github.stebeg.comicvine.common.response.StatusCode;
import com.github.stebeg.comicvine.image.Image;
import com.github.stebeg.comicvine.publisher.PublisherCredit;
import com.github.stebeg.tool.cv.issue.IssueCredit;
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

public class StoryArcRetrieverTest {

  private final UrlContentReader urlContentReaderMock;
  private final StoryArcRetriever instance;

  public StoryArcRetrieverTest() {
    this.urlContentReaderMock = mock(UrlContentReader.class);
    this.instance = new StoryArcRetriever(urlContentReaderMock, new Gson());
  }

  @Test
  public void testGetStoryArcById() throws Exception {
    final long storyArcId = 55766L;
    final GetStoryArcByIdRequest request = new GetStoryArcByIdRequest("12345", storyArcId);

    final URL url = getClass().getResource("/comicvine/storyarc/get-storyarc-by-id-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final StoryArc expResult = new StoryArc(storyArcId, "\"Green Lantern\" Blackest Night");
    expResult.setSummary("The Blackest Night is the third part of Geoff Johns's trilogy in the Green Lantern universe. This storyline will follow the events of Sinestro Corps War and the fallout of the War of Light.");
    expResult.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    expResult.setPublisher(new PublisherCredit(10, "DC Comics"));
    expResult.setIssueList(ImmutableList.of(
        new IssueCredit(155207, "Agent Orange Part 1"),
        new IssueCredit(155833, "Death Becomes Us"),
        new IssueCredit(164031, "Saint Walker; Mongul For Your Love; Tales of the Indigo Tribe")
    ));

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/2/28028/860257-horrors.jpg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/2/28028/860257-horrors.jpg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/2/28028/860257-horrors.jpg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/2/28028/860257-horrors.jpg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/2/28028/860257-horrors.jpg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/2/28028/860257-horrors.jpg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/2/28028/860257-horrors.jpg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/2/28028/860257-horrors.jpg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/2/28028/860257-horrors.jpg");
    image.setImageTags("All Images,Black Hand,Black Lantern Corps,The Blackest Night");
    expResult.setImage(image);

    final ApiResponse<StoryArc> result = this.instance.getStoryArcById(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expResult.toString(), result.getResult().toString());
  }

  @Test
  public void testGetStoryArcs() throws Exception {
    final String filter = "name:Blackest Night";
    final GetStoryArcListRequest request = new GetStoryArcListRequest("12345", filter).withLimit(3);

    final URL url = getClass().getResource("/comicvine/storyarc/get-storyarcs-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final StoryArcListItem storyArcListItem1 = new StoryArcListItem(55766, "\"Green Lantern\" Blackest Night");
    storyArcListItem1.setSummary("The Blackest Night is the third part of Geoff Johns's trilogy in the Green Lantern universe. This storyline will follow the events of Sinestro Corps War and the fallout of the War of Light.");
    storyArcListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    storyArcListItem1.setPublisher(new PublisherCredit(10, "DC Comics"));

    final Image storyArc1Image = new Image();
    storyArc1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/2/28028/860257-horrors.jpg");
    storyArc1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/2/28028/860257-horrors.jpg");
    storyArc1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/2/28028/860257-horrors.jpg");
    storyArc1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/2/28028/860257-horrors.jpg");
    storyArc1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/2/28028/860257-horrors.jpg");
    storyArc1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/2/28028/860257-horrors.jpg");
    storyArc1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/2/28028/860257-horrors.jpg");
    storyArc1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/2/28028/860257-horrors.jpg");
    storyArc1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/2/28028/860257-horrors.jpg");
    storyArc1Image.setImageTags("All Images,Black Hand,Black Lantern Corps,The Blackest Night");
    storyArcListItem1.setImage(storyArc1Image);

    final StoryArcListItem storyArcListItem2 = new StoryArcListItem(55792, "\"Blackest Night\" Origins & Omens");
    storyArcListItem2.setSummary("Crossover spanning in 19 issues.");
    storyArcListItem2.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.</p>");
    storyArcListItem2.setPublisher(new PublisherCredit(10, "DC Comics"));

    final Image storyArc2Image = new Image();
    storyArc2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/2/26476/698245-originsomens.jpg");
    storyArc2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/2/26476/698245-originsomens.jpg");
    storyArc2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/2/26476/698245-originsomens.jpg");
    storyArc2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/2/26476/698245-originsomens.jpg");
    storyArc2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/2/26476/698245-originsomens.jpg");
    storyArc2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/2/26476/698245-originsomens.jpg");
    storyArc2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/2/26476/698245-originsomens.jpg");
    storyArc2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/2/26476/698245-originsomens.jpg");
    storyArc2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/2/26476/698245-originsomens.jpg");
    storyArc2Image.setImageTags("All Images");
    storyArcListItem2.setImage(storyArc2Image);

    final int expNumberOfPageResults = 2;
    final int expNumberOfTotalResults = 2;
    final int expLimit = 3, expOffset = 0;
    final List<StoryArcListItem> expResult = ImmutableList.of(storyArcListItem1, storyArcListItem2);

    final ApiListResponse<StoryArcListItem> result = this.instance.getStoryArcs(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

}