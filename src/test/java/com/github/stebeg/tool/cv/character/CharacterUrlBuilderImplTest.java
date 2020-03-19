package com.github.stebeg.tool.cv.character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.Constants;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class CharacterUrlBuilderImplTest {

  private final CharacterUrlBuilder instance;

  public CharacterUrlBuilderImplTest() {
    this.instance = new CharacterUrlBuilderImpl();
  }

  @Test
  public void buildCharacterGetUrl() throws IOException {
    final long characterId = 1234L;
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(CharacterUrlBuilderImpl.API_CHARACTER_URL_FRAGMENT)
        .concat("4005-").concat(String.valueOf(characterId)).concat("/")
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildCharacterGetUrl(characterId, parameter);
    assertEquals(expPath, result.toString());
  }
}