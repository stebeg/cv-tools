package com.github.stebeg.comicvine.publisher;

import com.github.stebeg.comicvine.character.CharacterCredit;
import com.github.stebeg.comicvine.common.request.UrlContentReader;
import com.github.stebeg.comicvine.common.response.ApiListResponse;
import com.github.stebeg.comicvine.common.response.ApiResponse;
import com.github.stebeg.comicvine.common.response.StatusCode;
import com.github.stebeg.comicvine.image.Image;
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

public class PublisherRetrieverTest {

  private final UrlContentReader urlContentReaderMock;
  private final PublisherRetriever instance;

  public PublisherRetrieverTest() {
    this.urlContentReaderMock = mock(UrlContentReader.class);
    this.instance = new PublisherRetriever(urlContentReaderMock, new Gson());
  }

  @Test
  public void testGetPublisherById() throws Exception {
    final long publisherId = 10;
    final GetPublisherByIdRequest request = new GetPublisherByIdRequest("12345", publisherId);

    final URL url = getClass().getResource("/comicvine/publisher/get-publisher-by-id-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final Publisher expResult = new Publisher(publisherId, "DC Comics");
    expResult.setAliases("National Comics\nDetective Comics Inc.");
    expResult.setSummary("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.");
    expResult.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    expResult.setAddress("4000 Warner Blvd");
    expResult.setCity("Burbank");
    expResult.setState("California");

    expResult.setCharacterList(ImmutableList.of(
        new CharacterCredit(1253, "Lightning Lad"),
        new CharacterCredit(1254, "Dream Girl"),
        new CharacterCredit(1255, "Brainiac 5")));
    expResult.setTeamList(ImmutableList.of(
        new TeamCredit(5701, "Doom Patrol"),
        new TeamCredit(5704, "Outsiders"),
        new TeamCredit(5712, "Metal Men")
    ));
    expResult.setVolumeList(ImmutableList.of(
        new VolumeCredit(771, "Movie Comics"),
        new VolumeCredit(773, "Superman")
    ));
    expResult.setStoryArcList(ImmutableList.of(
        new StoryArcCredit(40503, "\"Batman: The Killing Joke\" The Killing Joke"),
        new StoryArcCredit(40645, "\"DC Annuals\" Bloodlines")
    ));

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/40/5213245-dc_logo_blue_final.jpg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/40/5213245-dc_logo_blue_final.jpg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/40/5213245-dc_logo_blue_final.jpg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/40/5213245-dc_logo_blue_final.jpg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/40/5213245-dc_logo_blue_final.jpg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/40/5213245-dc_logo_blue_final.jpg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/40/5213245-dc_logo_blue_final.jpg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/40/5213245-dc_logo_blue_final.jpg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/40/5213245-dc_logo_blue_final.jpg");
    image.setImageTags("All Images,DC Comics logo");
    expResult.setImage(image);

    final ApiResponse<Publisher> result = this.instance.getPublisherById(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expResult.toString(), result.getResult().toString());
  }

  @Test
  public void testGetPublishers() throws Exception {
    final String filter = "name:Green Lantern";
    final GetPublisherListRequest request = new GetPublisherListRequest("12345", filter).withLimit(3);

    final URL url = getClass().getResource("/comicvine/publisher/get-publishers-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final PublisherListItem publisherListItem1 = new PublisherListItem(10, "DC Comics");
    publisherListItem1.setAliases("National Comics\nDetective Comics Inc.\nDC Entertainment\nDC Nation");
    publisherListItem1.setSummary("Originally known as \"National Publications\", DC is a publisher of comic books featuring iconic characters and teams such as Superman, Batman, Wonder Woman, Green Lantern, the Justice League of America, and the Teen Titans, and is considered the originator of the American superhero genre.");
    publisherListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    publisherListItem1.setAddress("4000 Warner Blvd");
    publisherListItem1.setCity("Burbank");
    publisherListItem1.setState("California");

    final Image publisher1Image = new Image();
    publisher1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/40/5213245-dc_logo_blue_final.jpg");
    publisher1Image.setImageTags("All Images,DC Comics logo");
    publisherListItem1.setImage(publisher1Image);

    final PublisherListItem publisherListItem2 = new PublisherListItem(2014, "Marvel Comics and DC Comics");
    publisherListItem2.setAliases("Amalgam Comics");
    publisherListItem2.setSummary("While normally competitors, a handful of times through the decades the two publishers have joined together to jointly publish individual issues.");
    publisherListItem2.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");

    final Image publisher2Image = new Image();
    publisher2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11161/111615891/9002115-dcmarvel.jpg");
    publisher2Image.setImageTags("All Images");
    publisherListItem2.setImage(publisher2Image);

    final PublisherListItem publisherListItem3 = new PublisherListItem(2600, "Wildcard Production");
    publisherListItem3.setSummary("Publisher of Gumby comics.");

    final Image publisher3Image = new Image();
    publisher3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11122/111222211/6373148-blank.png");
    publisher3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11122/111222211/6373148-blank.png");
    publisher3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11122/111222211/6373148-blank.png");
    publisher3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11122/111222211/6373148-blank.png");
    publisher3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11122/111222211/6373148-blank.png");
    publisher3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11122/111222211/6373148-blank.png");
    publisher3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11122/111222211/6373148-blank.png");
    publisher3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11122/111222211/6373148-blank.png");
    publisher3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11122/111222211/6373148-blank.png");
    publisher3Image.setImageTags(",All Images,asgard,Avatars,carpediem081108,Classified: Dark Syntinel,Custom Pack,dp,Heroes/Villains");
    publisherListItem3.setImage(publisher3Image);

    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 19;
    final int expLimit = 3, expOffset = 0;
    final List<PublisherListItem> expResult = ImmutableList.of(publisherListItem1, publisherListItem2, publisherListItem3);

    final ApiListResponse<PublisherListItem> result = this.instance.getPublishers(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

}