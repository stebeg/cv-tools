package io.github.stebeg.comicvine.location;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import io.github.stebeg.comicvine.common.request.UrlContentReader;
import io.github.stebeg.comicvine.common.response.ApiListResponse;
import io.github.stebeg.comicvine.common.response.ApiResponse;
import io.github.stebeg.comicvine.common.response.StatusCode;
import io.github.stebeg.comicvine.image.Image;
import io.github.stebeg.comicvine.issue.IssueCredit;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationRetrieverTest {

  private final UrlContentReader urlContentReaderMock;
  private final LocationRetriever instance;

  public LocationRetrieverTest() {
    this.urlContentReaderMock = mock(UrlContentReader.class);
    this.instance = new LocationRetriever(urlContentReaderMock, new Gson());
  }

  @Test
  public void testGetLocationById() throws Exception {
    final long locationId = 41184;
    final GetLocationByIdRequest request = new GetLocationByIdRequest("12345", locationId);

    final URL url = getClass().getResource("/comicvine/location/get-location-by-id-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final Location expResult = new Location(locationId, "Metropolis");
    expResult.setSummary("Metropolis is much more than a bustling urban center. Like many east coast American cities, Metropolis is a melting pot of peoples and cultures from around the world. The city is often referred to as the Big Apricot, and the City of Tomorrow.");
    expResult.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    expResult.setStartYear("1939");
    expResult.setIssueList(ImmutableList.of(
        new IssueCredit(1080071, "Phantoms, Part Nine; Help Me"),
        new IssueCredit(1080079, "Santa's Oath?; Secret Santa; Ghosts of Christmas Present; It's a Criminal Life; Deadman Walking; Silent Nite; The Perfect Gift; O Glowy Night"),
        new IssueCredit(1081536, "Phantoms, Part Ten; We")));

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setImageTags("All Images,Art - Justin Van Genderen");
    expResult.setImage(image);

    final ApiResponse<Location> result = this.instance.getLocationById(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expResult.toString(), result.getResult().toString());
  }

  @Test
  public void testGetLocations() throws Exception {
    final String filter = "name:Metropolis";
    final GetLocationListRequest request = new GetLocationListRequest("12345", filter).withLimit(3);

    final URL url = getClass().getResource("/comicvine/location/get-locations-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final LocationListItem locationListItem1 = new LocationListItem(41184, "Metropolis");
    locationListItem1.setSummary("Metropolis is much more than a bustling urban center. Like many east coast American cities, Metropolis is a melting pot of peoples and cultures from around the world. The city is often referred to as the Big Apricot, and the City of Tomorrow.");
    locationListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    locationListItem1.setStartYear("1939");

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image.setImageTags("All Images,Art - Justin Van Genderen");
    locationListItem1.setImage(image);

    final LocationListItem locationListItem2 = new LocationListItem(57563, "Akkaba Metropolis");
    locationListItem2.setSummary("It is the base of operations for the heir of Apocalypse, Archangel, and the Final Horsemen.");
    locationListItem2.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>");
    locationListItem2.setStartYear("2011");

    final Image image2 = new Image();
    image2.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/10/101742/2011558-akkabametropolis.jpg");
    image2.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/10/101742/2011558-akkabametropolis.jpg");
    image2.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/10/101742/2011558-akkabametropolis.jpg");
    image2.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/10/101742/2011558-akkabametropolis.jpg");
    image2.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/10/101742/2011558-akkabametropolis.jpg");
    image2.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/10/101742/2011558-akkabametropolis.jpg");
    image2.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/10/101742/2011558-akkabametropolis.jpg");
    image2.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/10/101742/2011558-akkabametropolis.jpg");
    image2.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/10/101742/2011558-akkabametropolis.jpg");
    image2.setImageTags("All Images");
    locationListItem2.setImage(image2);

    final LocationListItem locationListItem3 = new LocationListItem(57744, "Monster Metropolis");
    locationListItem3.setSummary("A city under Manhattan that is a refuge for monsters");
    locationListItem3.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.</p>");
    locationListItem3.setAliases("Monster Underground");
    locationListItem3.setStartYear("2010");

    final Image image3 = new Image();
    image3.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/12/124259/9515985-rco087_1468908634.jpg");
    image3.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/12/124259/9515985-rco087_1468908634.jpg");
    image3.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/12/124259/9515985-rco087_1468908634.jpg");
    image3.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/12/124259/9515985-rco087_1468908634.jpg");
    image3.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/12/124259/9515985-rco087_1468908634.jpg");
    image3.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/12/124259/9515985-rco087_1468908634.jpg");
    image3.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/12/124259/9515985-rco087_1468908634.jpg");
    image3.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/12/124259/9515985-rco087_1468908634.jpg");
    image3.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/12/124259/9515985-rco087_1468908634.jpg");
    image3.setImageTags("All Images");
    locationListItem3.setImage(image3);

    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 15;
    final int expLimit = 3, expOffset = 0;
    final List<LocationListItem> expResult = ImmutableList.of(locationListItem1, locationListItem2, locationListItem3);

    final ApiListResponse<LocationListItem> result = this.instance.getLocations(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

  @Test
  public void testSearchLocations() throws Exception {
    final String searchText = "Metropolis";
    final SearchLocationsRequest request = new SearchLocationsRequest("12345", searchText).withLimit(3);

    final URL url = getClass().getResource("/comicvine/location/search-locations-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final LocationListItem locationListItem1 = new LocationListItem(41184, "Metropolis");
    locationListItem1.setSummary("Metropolis is much more than a bustling urban center. Like many east coast American cities, Metropolis is a melting pot of peoples and cultures from around the world. The city is often referred to as the Big Apricot, and the City of Tomorrow.");
    locationListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    locationListItem1.setStartYear("1939");

    final Image image1 = new Image();
    image1.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/8/86187/1669361-5241024543_4d024eaa09_b.jpg");
    image1.setImageTags("All Images,Art - Justin Van Genderen");
    locationListItem1.setImage(image1);

    final LocationListItem locationListItem2 = new LocationListItem(59407, "Metropolis");
    locationListItem2.setSummary("The futuristic city from the Fritz Lang movie.");
    locationListItem2.setDescription(null);
    locationListItem2.setStartYear("2009");

    final Image image2 = new Image();
    image2.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/1/15776/9369239-metropolis.jpg");
    image2.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/1/15776/9369239-metropolis.jpg");
    image2.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/1/15776/9369239-metropolis.jpg");
    image2.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/1/15776/9369239-metropolis.jpg");
    image2.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/1/15776/9369239-metropolis.jpg");
    image2.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/1/15776/9369239-metropolis.jpg");
    image2.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/1/15776/9369239-metropolis.jpg");
    image2.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/1/15776/9369239-metropolis.jpg");
    image2.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/1/15776/9369239-metropolis.png");
    image2.setImageTags("All Images");
    locationListItem2.setImage(image2);

    final LocationListItem locationListItem3 = new LocationListItem(57563, "Akkaba Metropolis");
    locationListItem3.setSummary("It is the base of operations for the heir of Apocalypse, Archangel, and the Final Horsemen.");
    locationListItem3.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>");
    locationListItem3.setStartYear("2011");

    final Image image3 = new Image();
    image3.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/10/101742/2011558-akkabametropolis.jpg");
    image3.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/10/101742/2011558-akkabametropolis.jpg");
    image3.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/10/101742/2011558-akkabametropolis.jpg");
    image3.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/10/101742/2011558-akkabametropolis.jpg");
    image3.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/10/101742/2011558-akkabametropolis.jpg");
    image3.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/10/101742/2011558-akkabametropolis.jpg");
    image3.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/10/101742/2011558-akkabametropolis.jpg");
    image3.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/10/101742/2011558-akkabametropolis.jpg");
    image3.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/10/101742/2011558-akkabametropolis.jpg");
    image3.setImageTags("All Images");
    locationListItem3.setImage(image3);

    final List<LocationListItem> expResult = ImmutableList.of(locationListItem1, locationListItem2, locationListItem3);
    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 15;
    final int expLimit = 3, expOffset = 0;

    final ApiListResponse<LocationListItem> result = this.instance.searchLocations(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

}