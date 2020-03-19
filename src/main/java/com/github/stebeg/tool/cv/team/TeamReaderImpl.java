package com.github.stebeg.tool.cv.team;

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
 * An implementation for retrieving teams from the Comicvine API.
 *
 * @author Steffen Berger
 */
class TeamReaderImpl implements TeamReader {

  private static final String FORMAT_PARAMETER_NAME = "format";
  private static final String FORMAT_PARAMETER_VALUE = "json";

  private static final List<String> TEAM_FIELD_NAMES = ImmutableList.of(
      Team.ID_ATTRIBUTE_NAME,
      Team.NAME_ATTRIBUTE_NAME,
      Team.SUMMARY_ATTRIBUTE_NAME,
      Team.DESCRIPTION_ATTRIBUTE_NAME,
      Team.PUBLISHER_ATTRIBUTE_NAME,
      Team.IMAGE_ATTRIBUTE_NAME);

  private static final String FIELD_LIST_PARAMETER_NAME = "field_list";
  private static final String TEAM_FIELD_LIST_PARAMETER_VALUE = Joiner
      .on(',').join(TEAM_FIELD_NAMES);

  private final TeamUrlBuilder urlBuilder;
  private final UrlContentReader urlContentReader;
  private final Gson gson;

  /**
   * Creates a new instance of the implementation for retrieving teams from the Comicvine API.
   *
   * @param urlBuilder       Needed for building the Comicvine API URL for reading teams.
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine
   *                         API.
   */
  TeamReaderImpl(
      TeamUrlBuilder urlBuilder,
      UrlContentReader urlContentReader,
      Gson gson) {
    this.urlBuilder = urlBuilder;
    this.urlContentReader = urlContentReader;
    this.gson = gson;
  }

  /**
   * {@inheritDoc}
   *
   * @param apiKey {@inheritDoc}
   * @param teamId {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public TeamGetResult getTeam(
      final String apiKey,
      final long teamId) throws IOException {
    final Map<String, String> parameter = ImmutableMap.<String, String>builder()
        .put(Constants.API_KEY_PARAMETER_NAME, apiKey)
        .put(FORMAT_PARAMETER_NAME, FORMAT_PARAMETER_VALUE)
        .put(FIELD_LIST_PARAMETER_NAME, TEAM_FIELD_LIST_PARAMETER_VALUE)
        .build();
    final URL apiUrl = this.urlBuilder.buildTeamGetUrl(teamId, parameter);
    final String jsonContent = this.urlContentReader.getJson(apiUrl);

    final JsonElement jsonElement = JsonParser.parseString(jsonContent);
    final JsonObject jsonObject = jsonElement.getAsJsonObject();

    return this.gson.fromJson(jsonObject, TeamGetResult.class);
  }
}
