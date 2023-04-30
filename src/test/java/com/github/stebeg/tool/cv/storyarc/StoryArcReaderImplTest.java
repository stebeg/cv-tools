package com.github.stebeg.tool.cv.storyarc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.stebeg.tool.cv.AbstractJsonComparisonTest;
import com.github.stebeg.tool.cv.common.UrlConnectionBuilder;
import com.github.stebeg.tool.cv.common.UrlContentReader;
import com.github.stebeg.tool.cv.common.UrlContentReaderImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;

public class StoryArcReaderImplTest extends AbstractJsonComparisonTest {

  private final StoryArcUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private final StoryArcReader instance;

  public StoryArcReaderImplTest() {
    this.urlBuilderMock = mock(StoryArcUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new StoryArcReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testSearchStoryArcs() throws Exception {
    final String apiKey = "1234567890abcdef";
    final String searchText = "Blackest";
    final StoryArcSearchResult expResult = new StoryArcSearchResult(1, 1, 1);

    final URL url = getClass().getResource("/storyarc/storyarc-search-example.json");
    when(this.urlBuilderMock.buildStoryArcSearchUrl(anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final StoryArcSearchResult result = this.instance.searchStoryArcs(apiKey, searchText);
    assertEquals(expResult.getStatusCode(), result.getStatusCode());
    assertEquals(expResult.getNumberOfPageResults(), result.getNumberOfPageResults());
    assertEquals(expResult.getNumberOfTotalResults(), result.getNumberOfTotalResults());
    assertJsonEquals("/storyarc/storyarc-search-example-result.json", result);
  }

  @Test
  public void testStoryArc() throws Exception {
    final long storyArcId = 55766L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/storyarc/storyarc-get-example.json");
    when(this.urlBuilderMock.buildStoryArcGetUrl(eq(storyArcId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final StoryArcGetResult result = this.instance.getStoryArc(apiKey, storyArcId);
    assertJsonEquals("/storyarc/storyarc-get-example-result.json", result);
  }

}