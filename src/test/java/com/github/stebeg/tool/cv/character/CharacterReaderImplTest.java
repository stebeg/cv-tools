package com.github.stebeg.tool.cv.character;

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

public class CharacterReaderImplTest extends AbstractJsonComparisonTest {

  private final CharacterUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final CharacterReader instance;

  public CharacterReaderImplTest() {
    this.urlBuilderMock = mock(CharacterUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new CharacterReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetCharacter() throws Exception {
    final long characterId = 11202L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/character/character-get-example.json");
    when(this.urlBuilderMock.buildCharacterGetUrl(eq(characterId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final CharacterGetResult result = this.instance.getCharacter(apiKey, characterId);
    assertJsonEquals("/character/character-get-example-result.json", result);
  }
}