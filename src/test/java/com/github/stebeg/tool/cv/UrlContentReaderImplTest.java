package com.github.stebeg.tool.cv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

/**
 * @author Steffen Berger
 */
public class UrlContentReaderImplTest {

  private final UrlConnectionBuilder urlConnectionBuilderMock;
  private final UrlContentReaderImpl instance;

  public UrlContentReaderImplTest() {
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);
    this.instance = new UrlContentReaderImpl(urlConnectionBuilderMock);
  }

  @Test
  public void testGetJson() throws Exception {
    final URL url = getClass().getResource("/volume-search-example.json");
    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final String expResult = new String(Files.readAllBytes(Paths.get(url.toURI())))
        .replace("\r\n", "");
    final String result = this.instance.getJson(url);
    assertEquals(expResult, result);
  }
}
