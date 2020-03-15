package com.github.stebeg.tool.cv.volume;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyMap;
import static org.mockito.Mockito.eq;
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

/**
 * @author Steffen Berger
 */
public class VolumeReaderImplTest {

  private final VolumeUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final VolumeReaderImpl instance;

  public VolumeReaderImplTest() {
    this.urlBuilderMock = mock(VolumeUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new VolumeReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testSearchVolumes() throws IOException {
    final String apiKey = "1234567890abcdef";
    final String searchText = "Green Lantern";
    final VolumeSearchResult expResult = new VolumeSearchResult(1, 2, 544);

    final Volume expResultVolume1 = new Volume(2839L, "Green Lantern");
    expResultVolume1.setDescription("<p>The Description of Green Lantern Volume 2.</p>");
    expResultVolume1.setCountOfIssues(205);
    expResultVolume1.setStartYear(1960);
    expResultVolume1.setPublisher(new SimplePublisher(10, "DC Comics"));
    expResultVolume1.setImage(new Image(
        "https://comicvine.gamespot.com/api/image/original/4457-2013-4869-1-green-lantern.jpg",
        "https://comicvine.gamespot.com/api/image/scale_avatar/4457-2013-4869-1-green-lantern.jpg"));

    final Volume expResultVolume2 = new Volume(25944L, "Green Lantern");
    expResultVolume2.setDescription("<p>The Description of Green Lantern Volume 1.</p>");
    expResultVolume2.setCountOfIssues(38);
    expResultVolume2.setStartYear(1941);
    expResultVolume2.setPublisher(new SimplePublisher(10, "DC Comics"));
    expResultVolume2.setImage(new Image(
        "https://comicvine.gamespot.com/api/image/original/732037-gl_1.jpg",
        "https://comicvine.gamespot.com/api/image/scale_avatar/732037-gl_1.jpg"));

    final URL url = getClass().getResource("/volume/volume-search-example.json");
    when(this.urlBuilderMock.buildVolumeSearchUrl(anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final VolumeSearchResult result = this.instance.searchVolumes(apiKey, searchText);
    assertEquals(expResult.getStatusCode(), result.getStatusCode());
    assertEquals(expResult.getNumberOfPageResults(), result.getNumberOfPageResults());
    assertEquals(expResult.getNumberOfTotalResults(), result.getNumberOfTotalResults());

    final int expResultItemCount = 2;
    assertEquals(expResultItemCount, result.getResult().size());

    final Volume resultVolume1 = result.getResult().get(0);
    assertEquals(expResultVolume1.getId(), resultVolume1.getId());
    assertEquals(expResultVolume1.getName(), resultVolume1.getName());
    assertEquals(expResultVolume1.getDescription(), resultVolume1.getDescription());
    assertEquals(expResultVolume1.getCountOfIssues(), resultVolume1.getCountOfIssues());
    assertEquals(expResultVolume1.getStartYear(), resultVolume1.getStartYear());

    assertEquals(expResultVolume1.getPublisher().getId(), resultVolume1.getPublisher().getId());
    assertEquals(expResultVolume1.getPublisher().getName(), resultVolume1.getPublisher().getName());

    assertEquals(expResultVolume1.getImage().getOriginalUrl(),
        resultVolume1.getImage().getOriginalUrl());
    assertEquals(expResultVolume1.getImage().getThumbUrl(), resultVolume1.getImage().getThumbUrl());

    final Volume resultVolume2 = result.getResult().get(1);
    assertEquals(expResultVolume2.getId(), resultVolume2.getId());
    assertEquals(expResultVolume2.getName(), resultVolume2.getName());
    assertEquals(expResultVolume2.getDescription(), resultVolume2.getDescription());
    assertEquals(expResultVolume2.getCountOfIssues(), resultVolume2.getCountOfIssues());
    assertEquals(expResultVolume2.getStartYear(), resultVolume2.getStartYear());

    assertEquals(expResultVolume2.getPublisher().getId(), resultVolume2.getPublisher().getId());
    assertEquals(expResultVolume2.getPublisher().getName(), resultVolume2.getPublisher().getName());

    assertEquals(expResultVolume2.getImage().getOriginalUrl(),
        resultVolume2.getImage().getOriginalUrl());
    assertEquals(expResultVolume2.getImage().getThumbUrl(), resultVolume2.getImage().getThumbUrl());
  }

  @Test
  public void testGetVolume() throws IOException {
    final long volumeId = 2839L;
    final String apiKey = "1234567890abcdef";

    final Volume expResultVolume = new Volume(2839L, "Green Lantern");
    expResultVolume.setDescription("<p>The Description of Green Lantern Volume 2.</p>");
    expResultVolume.setCountOfIssues(205);
    expResultVolume.setStartYear(1960);
    expResultVolume.setPublisher(new SimplePublisher(10, "DC Comics"));
    expResultVolume.setImage(new Image(
        "https://comicvine.gamespot.com/api/image/original/4457-2013-4869-1-green-lantern.jpg",
        "https://comicvine.gamespot.com/api/image/scale_avatar/4457-2013-4869-1-green-lantern.jpg"));
    final VolumeGetResult expResult = new VolumeGetResult(1, expResultVolume);

    final URL url = getClass().getResource("/volume/volume-get-example.json");
    when(this.urlBuilderMock.buildVolumeGetUrl(eq(volumeId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final VolumeGetResult result = this.instance.getVolume(apiKey, volumeId);
    assertEquals(expResult.getStatusCode(), result.getStatusCode());
    assertNotNull(result.getResult());

    final Volume volume = result.getResult();
    assertEquals(expResultVolume.getId(), volume.getId());
    assertEquals(expResultVolume.getName(), volume.getName());
    assertEquals(expResultVolume.getDescription(), volume.getDescription());
    assertEquals(expResultVolume.getCountOfIssues(), volume.getCountOfIssues());
    assertEquals(expResultVolume.getStartYear(), volume.getStartYear());

    assertEquals(expResultVolume.getPublisher().getId(), volume.getPublisher().getId());
    assertEquals(expResultVolume.getPublisher().getName(), volume.getPublisher().getName());

    assertEquals(expResultVolume.getImage().getOriginalUrl(), volume.getImage().getOriginalUrl());
    assertEquals(expResultVolume.getImage().getThumbUrl(), volume.getImage().getThumbUrl());
  }
}
