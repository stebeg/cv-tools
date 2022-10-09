package com.github.stebeg.tool.cv.volume;

import static org.mockito.Mockito.anyMap;
import static org.mockito.Mockito.eq;
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

/**
 * @author Steffen Berger
 */
public class VolumeReaderImplTest extends AbstractJsonComparisonTest {

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
  public void testSearchVolumes() throws Exception {
    final String apiKey = "1234567890abcdef";
    final String searchText = "Green Lantern";
    final VolumeSearchResult expResult = new VolumeSearchResult(1, 2, 544);

    final URL url = getClass().getResource("/volume/volume-search-example.json");
    when(this.urlBuilderMock.buildVolumeSearchUrl(anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final VolumeSearchResult result = this.instance.searchVolumes(apiKey, searchText);
    assertJsonEquals("/volume/volume-search-example-result.json", result);
  }

  @Test
  public void testGetVolume() throws Exception {
    final long volumeId = 2839L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/volume/volume-get-example.json");
    when(this.urlBuilderMock.buildVolumeGetUrl(eq(volumeId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final VolumeGetResult result = this.instance.getVolume(apiKey, volumeId);
    assertJsonEquals("/volume/volume-get-example-result.json", result);
  }
}
