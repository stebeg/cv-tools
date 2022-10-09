package com.github.stebeg.tool.cv.person;

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

public class PersonReaderImplTest extends AbstractJsonComparisonTest {

  private final PersonUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final PersonReader instance;

  public PersonReaderImplTest() {
    this.urlBuilderMock = mock(PersonUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new PersonReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetPerson() throws Exception {
    final long personId = 40439L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/person/person-get-example.json");
    when(this.urlBuilderMock.buildPersonGetUrl(eq(personId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final PersonGetResult result = this.instance.getPerson(apiKey, personId);
    assertJsonEquals("/person/person-get-example-result.json", result);
  }
}