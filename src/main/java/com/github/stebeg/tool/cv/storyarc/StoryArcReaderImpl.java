package com.github.stebeg.tool.cv.storyarc;

import com.github.stebeg.tool.cv.Constants;
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
 * An implementation for retrieving story arcs from the Comicvine API.
 *
 * @author Steffen Berger
 */
class StoryArcReaderImpl implements StoryArcReader {

  private static final String QUERY_PARAMETER_NAME = "query";

  private static final String FORMAT_PARAMETER_NAME = "format";
  private static final String FORMAT_PARAMETER_VALUE = "json";

  private static final String LIMIT_PARAMETER_NAME = "limit";
  private static final Integer LIMIT_PARAMETER_VALUE = 50;

  private static final String RESOURCES_PARAMETER_NAME = "resources";
  private static final String RESOURCES_PARAMETER_VALUE = "story_arc";

  private static final List<String> STORY_ARC_FIELD_NAMES = ImmutableList.of(
      StoryArc.ID_ATTRIBUTE_NAME,
      StoryArc.NAME_ATTRIBUTE_NAME,
      StoryArc.DESCRIPTION_ATTRIBUTE_NAME,
      StoryArc.ISSUES_ATTRIBUTE_NAME,
      StoryArc.PUBLISHER_ATTRIBUTE_NAME,
      StoryArc.IMAGE_ATTRIBUTE_NAME);

  private static final String FIELD_LIST_PARAMETER_NAME = "field_list";
  private static final String STORY_ARC_FIELD_LIST_PARAMETER_VALUE = Joiner
      .on(',').join(STORY_ARC_FIELD_NAMES);

  private final StoryArcUrlBuilder urlBuilder;
  private final UrlContentReader urlContentReader;
  private final Gson gson;

  /**
   * Creates a new instance of the implementation for retrieving story arcs from the Comicvine API.
   *
   * @param urlBuilder       Needed for building the Comicvine API URL for reading story arcs.
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  StoryArcReaderImpl(
      StoryArcUrlBuilder urlBuilder,
      UrlContentReader urlContentReader,
      Gson gson) {
    this.urlBuilder = urlBuilder;
    this.urlContentReader = urlContentReader;
    this.gson = gson;
  }

  /**
   * {@inheritDoc}
   *
   * @param apiKey     {@inheritDoc}
   * @param searchText {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public StoryArcSearchResult searchStoryArcs(
      final String apiKey,
      final String searchText) throws IOException {
    final Map<String, String> parameter = ImmutableMap.<String, String>builder()
        .put(Constants.API_KEY_PARAMETER_NAME, apiKey)
        .put(FORMAT_PARAMETER_NAME, FORMAT_PARAMETER_VALUE)
        .put(LIMIT_PARAMETER_NAME, LIMIT_PARAMETER_VALUE.toString())
        .put(RESOURCES_PARAMETER_NAME, RESOURCES_PARAMETER_VALUE)
        .put(FIELD_LIST_PARAMETER_NAME, STORY_ARC_FIELD_LIST_PARAMETER_VALUE)
        .put(QUERY_PARAMETER_NAME, searchText)
        .build();
    final URL apiUrl = this.urlBuilder.buildStoryArcSearchUrl(parameter);
    final String jsonContent = this.urlContentReader.getJson(apiUrl);

    final JsonElement jsonElement = JsonParser.parseString(jsonContent);
    final JsonObject jsonObject = jsonElement.getAsJsonObject();

    return this.gson.fromJson(jsonObject, StoryArcSearchResult.class);
  }

  /**
   * {@inheritDoc}
   *
   * @param apiKey     {@inheritDoc}
   * @param storyArcId {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public StoryArcGetResult getStoryArc(
      final String apiKey,
      final long storyArcId) throws IOException {
    final Map<String, String> parameter = ImmutableMap.<String, String>builder()
        .put(Constants.API_KEY_PARAMETER_NAME, apiKey)
        .put(FORMAT_PARAMETER_NAME, FORMAT_PARAMETER_VALUE)
        .put(FIELD_LIST_PARAMETER_NAME, STORY_ARC_FIELD_LIST_PARAMETER_VALUE)
        .build();
    final URL apiUrl = this.urlBuilder.buildStoryArcGetUrl(storyArcId, parameter);
    final String jsonContent = this.urlContentReader.getJson(apiUrl);

    final JsonElement jsonElement = JsonParser.parseString(jsonContent);
    final JsonObject jsonObject = jsonElement.getAsJsonObject();

    return this.gson.fromJson(jsonObject, StoryArcGetResult.class);
  }
}
