package com.github.stebeg.tool.cv.publisher;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
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

public class PublisherReaderImplTest extends AbstractJsonComparisonTest {

  private final PublisherUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final PublisherReader instance;

  public PublisherReaderImplTest() {
    this.urlBuilderMock = mock(PublisherUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new PublisherReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetPublisher() throws Exception {
    final long publisherId = 10L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/publisher/publisher-get-example.json");
    when(this.urlBuilderMock.buildPublisherGetUrl(eq(publisherId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final PublisherGetResult result = this.instance.getPublisher(apiKey, publisherId);
    assertJsonEquals("/publisher/publisher-get-example-result.json", result);
  }
}