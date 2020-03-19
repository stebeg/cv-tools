package com.github.stebeg.tool.cv.character;

import com.github.stebeg.tool.cv.common.UrlContentReader;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * An implementation for retrieving characters from the Comicvine API.
 *
 * @author Steffen Berger
 */
class CharacterReaderImpl implements CharacterReader {

  private static final String API_KEY_PARAMETER_NAME = "api_key";

  private static final String FORMAT_PARAMETER_NAME = "format";
  private static final String FORMAT_PARAMETER_VALUE = "json";

  private static final List<String> CHARACTER_FIELD_NAMES = ImmutableList.of(
      Character.ID_ATTRIBUTE_NAME,
      Character.NAME_ATTRIBUTE_NAME,
      Character.REAL_NAME_ATTRIBUTE_NAME,
      Character.SUMMARY_ATTRIBUTE_NAME,
      Character.DESCRIPTION_ATTRIBUTE_NAME,
      Character.PUBLISHER_ATTRIBUTE_NAME,
      Character.IMAGE_ATTRIBUTE_NAME,
      Character.GENDER_ATTRIBUTE_NAME,
      Character.ORIGIN_ATTRIBUTE_NAME,
      Character.BIRTH_ATTRIBUTE_NAME,
      Character.CREATORS_ATTRIBUTE_NAME,
      Character.FIRST_APPEARED_IN_ATTRIBUTE_NAME);

  private static final String FIELD_LIST_PARAMETER_NAME = "field_list";
  private static final String CHARACTER_FIELD_LIST_PARAMETER_VALUE = Joiner
      .on(',').join(CHARACTER_FIELD_NAMES);

  private final CharacterUrlBuilder urlBuilder;
  private final UrlContentReader urlContentReader;
  private final Gson gson;

  /**
   * Creates a new instance of the implementation for retrieving characters from the Comicvine API.
   *
   * @param urlBuilder       Needed for building the Comicvine API URL for reading characters.
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine
   *                         API.
   */
  CharacterReaderImpl(CharacterUrlBuilder urlBuilder,
      UrlContentReader urlContentReader, Gson gson) {
    this.urlBuilder = urlBuilder;
    this.urlContentReader = urlContentReader;
    this.gson = gson;
  }

  /**
   * {@inheritDoc}
   *
   * @param apiKey      {@inheritDoc}
   * @param characterId {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public CharacterGetResult getCharacter(
      final String apiKey,
      final long characterId) throws IOException {
    final Map<String, String> parameter = ImmutableMap.<String, String>builder()
        .put(API_KEY_PARAMETER_NAME, apiKey)
        .put(FORMAT_PARAMETER_NAME, FORMAT_PARAMETER_VALUE)
        .put(FIELD_LIST_PARAMETER_NAME, CHARACTER_FIELD_LIST_PARAMETER_VALUE)
        .build();
    final URL apiUrl = this.urlBuilder.buildCharacterGetUrl(characterId, parameter);
    final String jsonContent = this.urlContentReader.getJson(apiUrl);

    final JsonElement jsonElement = JsonParser.parseString(jsonContent);
    final JsonObject jsonObject = jsonElement.getAsJsonObject();

    return this.gson.fromJson(jsonObject, CharacterGetResult.class);
  }
}
