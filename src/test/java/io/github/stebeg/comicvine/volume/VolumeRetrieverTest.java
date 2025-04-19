package io.github.stebeg.comicvine.volume;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import io.github.stebeg.comicvine.common.request.UrlContentReader;
import io.github.stebeg.comicvine.common.response.ApiListResponse;
import io.github.stebeg.comicvine.common.response.ApiResponse;
import io.github.stebeg.comicvine.common.response.StatusCode;
import io.github.stebeg.comicvine.image.Image;
import io.github.stebeg.comicvine.issue.IssueCredit;
import io.github.stebeg.comicvine.publisher.PublisherCredit;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VolumeRetrieverTest {

  private final UrlContentReader urlContentReaderMock;
  private final VolumeRetriever instance;

  public VolumeRetrieverTest() {
    this.urlContentReaderMock = mock(UrlContentReader.class);
    this.instance = new VolumeRetriever(urlContentReaderMock, new Gson());
  }

  @Test
  public void testGetVolumeById() throws Exception {
    final long volumeId = 42808L;
    final GetVolumeByIdRequest request = new GetVolumeByIdRequest("12345", volumeId);

    final URL url = getClass().getResource("/comicvine/volume/get-volume-by-id-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final Volume expResult = new Volume(volumeId, "Green Lantern");
    expResult.setAliases(null);
    expResult.setSummary("Volume 5.");
    expResult.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    expResult.setIssueCount(57);
    expResult.setPublisher(new PublisherCredit(10, "DC Comics"));
    expResult.setStartYear("2011");

    expResult.setFirstIssue(new IssueCredit(292583, "Sinestro, Part One"));
    expResult.setLastIssue(new IssueCredit(528484, "Agents of Gray"));
    expResult.setIssueList(ImmutableList.of(
        new IssueCredit(292583, "Sinestro, Part One"),
        new IssueCredit(294843, "Sinestro, Part Two"),
        new IssueCredit(301647, "Sinestro, Part Three")
    ));

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/9116/2008261-1.jpg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/9116/2008261-1.jpg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/9116/2008261-1.jpg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/9116/2008261-1.jpg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/9116/2008261-1.jpg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/9116/2008261-1.jpg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/9116/2008261-1.jpg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/9116/2008261-1.jpg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/9116/2008261-1.jpg");
    image.setImageTags("All Images");
    expResult.setImage(image);

    final ApiResponse<Volume> result = this.instance.getVolumeById(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expResult.toString(), result.getResult().toString());
  }

  @Test
  public void testGetVolumeById_NotFoundResponse() throws Exception {
    final long volumeId = 9999999L;
    final GetVolumeByIdRequest request = new GetVolumeByIdRequest("12345", volumeId);

    final URL url = getClass().getResource("/comicvine/error/not-found-error-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final ApiResponse<Volume> result = this.instance.getVolumeById(request);
    assertEquals(StatusCode.OBJECT_NOT_FOUND, result.getStatusCode());
    assertNull(result.getResult());
  }

  @Test
  public void testGetVolumes() throws Exception {
    final String filter = "name:Green Lantern";
    final GetVolumeListRequest request = new GetVolumeListRequest("12345", filter).withLimit(3);

    final URL url = getClass().getResource("/comicvine/volume/get-volumes-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final VolumeListItem volumeListItem1 = new VolumeListItem(2839, "Green Lantern");
    volumeListItem1.setAliases("Green Lantern co-starring Green ArrowrnThe Green Lantern Corps");
    volumeListItem1.setIssueCount(205);
    volumeListItem1.setSummary("Volume 2");
    volumeListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.</p>");
    volumeListItem1.setFirstIssue(new IssueCredit(4869, "The Planet of Doomed Men; Menace of the Giant Puppet!"));
    volumeListItem1.setLastIssue(new IssueCredit(27229, "Bad Reputation!"));
    volumeListItem1.setPublisher(new PublisherCredit(10, "DC Comics"));
    volumeListItem1.setStartYear("1960");

    final Image volumeListItem1Image = new Image();
    volumeListItem1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setImageTags("All Images");
    volumeListItem1.setImage(volumeListItem1Image);

    final VolumeListItem volumeListItem2 = new VolumeListItem(3077, "Tales of the Green Lantern Corps");
    volumeListItem2.setIssueCount(3);
    volumeListItem2.setSummary(" ");
    volumeListItem2.setDescription("<p>Three issue mini-series.</p>");
    volumeListItem2.setFirstIssue(new IssueCredit(21224, "Challenge!"));
    volumeListItem2.setLastIssue(new IssueCredit(21357, "Triumph!"));
    volumeListItem2.setPublisher(new PublisherCredit(10, "DC Comics"));
    volumeListItem2.setStartYear("1981");

    final Image volumeListItem2Image = new Image();
    volumeListItem2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/4/18996-3077-21224-1-tales-of-the-green-l.jpg");
    volumeListItem2Image.setImageTags("All Images");
    volumeListItem2.setImage(volumeListItem2Image);

    final VolumeListItem volumeListItem3 = new VolumeListItem(3198, "Green Lantern/Green Arrow");
    volumeListItem3.setIssueCount(7);
    volumeListItem3.setSummary("A reprint series of one of the most powerful team ups ever.");
    volumeListItem3.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.</p>");
    volumeListItem3.setFirstIssue(new IssueCredit(23505, "No Evil Shall Escape My Sight! / Journey to Desolation!"));
    volumeListItem3.setLastIssue(new IssueCredit(24160, "...And Through Him Save A World! / The Killing of an Archer! / Green Arrow is Dead! / The Fate of an Archer"));
    volumeListItem3.setPublisher(new PublisherCredit(10, "DC Comics"));
    volumeListItem3.setStartYear("1983");

    final Image volumeListItem3Image = new Image();
    volumeListItem3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/4/21075-3198-23505-1-green-lantern--gree.jpg");
    volumeListItem3Image.setImageTags("All Images");
    volumeListItem3.setImage(volumeListItem3Image);

    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 296;
    final int expLimit = 3, expOffset = 0;
    final List<VolumeListItem> expResult = ImmutableList.of(volumeListItem1, volumeListItem2, volumeListItem3);

    final ApiListResponse<VolumeListItem> result = this.instance.getVolumes(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

  @Test
  public void testSearchVolumes() throws Exception {
    final String searchText = "Green Lantern";
    final SearchVolumesRequest request = new SearchVolumesRequest("12345", searchText).withLimit(3);

    final URL url = getClass().getResource("/comicvine/volume/search-volumes-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final VolumeListItem volumeListItem1 = new VolumeListItem(2839, "Green Lantern");
    volumeListItem1.setIssueCount(205);
    volumeListItem1.setSummary("Volume 2");
    volumeListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.</p>");
    volumeListItem1.setAliases("Green Lantern co-starring Green ArrowrnThe Green Lantern Corps");
    volumeListItem1.setFirstIssue(new IssueCredit(4869, "The Planet of Doomed Men; Menace of the Giant Puppet!"));
    volumeListItem1.setLastIssue(new IssueCredit(27229, "Bad Reputation!"));
    volumeListItem1.setPublisher(new PublisherCredit(10, "DC Comics"));
    volumeListItem1.setStartYear("1960");

    final Image volumeListItem1Image = new Image();
    volumeListItem1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/4/4457-2013-4869-1-green-lantern.jpg");
    volumeListItem1Image.setImageTags("All Images");
    volumeListItem1.setImage(volumeListItem1Image);

    final VolumeListItem volumeListItem2 = new VolumeListItem(25944, "Green Lantern");
    volumeListItem2.setIssueCount(38);
    volumeListItem2.setSummary("Volume 1");
    volumeListItem2.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.</p>");
    volumeListItem2.setFirstIssue(new IssueCredit(153317, "Green Lantern"));
    volumeListItem2.setLastIssue(new IssueCredit(159450, "The Murdered Clues!; The Double Play!; The Impossible Mr. Paradox!"));
    volumeListItem2.setPublisher(new PublisherCredit(10, "DC Comics"));
    volumeListItem2.setStartYear("1941");

    final Image volumeListItem2Image = new Image();
    volumeListItem2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/2/27783/732037-gl_1.jpg");
    volumeListItem2Image.setImageTags("All Images");
    volumeListItem2.setImage(volumeListItem2Image);

    final VolumeListItem volumeListItem3 = new VolumeListItem(79179, "Green Lantern");
    volumeListItem3.setIssueCount(20);
    volumeListItem3.setSummary(null);
    volumeListItem3.setDescription("<p>Spanish publication of Green Lantern.</p>");
    volumeListItem3.setFirstIssue(new IssueCredit(475174, null));
    volumeListItem3.setLastIssue(new IssueCredit(475692, "La guerra de los green lantern"));
    volumeListItem3.setPublisher(new PublisherCredit(3432, "ECC Ediciones"));
    volumeListItem3.setStartYear("2009");

    final Image volumeListItem3Image = new Image();
    volumeListItem3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11120/111202620/4302188-4908474690-1863..jpg");
    volumeListItem3Image.setImageTags("All Images");
    volumeListItem3.setImage(volumeListItem3Image);

    final List<VolumeListItem> expResult = ImmutableList.of(volumeListItem1, volumeListItem2, volumeListItem3);
    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 640;
    final int expLimit = 3, expOffset = 0;

    final ApiListResponse<VolumeListItem> result = this.instance.searchVolumes(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

}