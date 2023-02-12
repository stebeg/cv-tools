package com.github.stebeg.tool.cv.issue;

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
 * An implementation for retrieving issues from a comic book series from the Comicvine API.
 *
 * @author Steffen Berger
 */
class IssueReaderImpl implements IssueReader {

  private static final String FORMAT_PARAMETER_NAME = "format";
  private static final String FORMAT_PARAMETER_VALUE = "json";

  private static final String LIMIT_PARAMETER_NAME = "limit";
  private static final Integer DEFAULT_LIMIT_PARAMETER_VALUE = 100;

  private static final String OFFSET_PARAMETER_NAME = "offset";
  private static final Integer DEFAULT_OFFSET_PARAMETER_VALUE = 0;

  private static final List<String> VOLUME_ISSUES_FIELD_NAMES = ImmutableList.of(
      Issue.ID_ATTRIBUTE_NAME,
      Issue.NAME_ATTRIBUTE_NAME,
      Issue.DESCRIPTION_ATTRIBUTE_NAME,
      Issue.ISSUE_NUMBER_ATTRIBUTE_NAME,
      Issue.COVER_DATE_ATTRIBUTE_NAME,
      Issue.IN_STORE_DATE_ATTRIBUTE_NAME,
      Issue.IMAGE_ATTRIBUTE_NAME,
      Issue.VOLUME_ATTRIBUTE_NAME);
  private static final List<String> ISSUE_FIELD_NAMES = ImmutableList.<String>builder()
      .addAll(VOLUME_ISSUES_FIELD_NAMES)
      .add(Issue.CHARACTER_CREDITS_ATTRIBUTE_NAME)
      .add(Issue.TEAM_CREDITS_ATTRIBUTE_NAME)
      .add(Issue.LOCATION_CREDITS_ATTRIBUTE_NAME)
      .add(Issue.PERSON_CREDITS_ATTRIBUTE_NAME)
      .add(Issue.STORY_ARC_CREDITS_ATTRIBUTE_NAME)
      .add(Issue.WEB_URL_ATTRIBUTE_NAME)
      .add(Issue.API_URL_ATTRIBUTE_NAME)
      .build();

  private static final String FIELD_LIST_PARAMETER_NAME = "field_list";
  private static final String VOLUME_ISSUES_FIELD_LIST_PARAMETER_VALUE = Joiner
      .on(',').join(VOLUME_ISSUES_FIELD_NAMES);
  private static final String ISSUE_FIELD_LIST_PARAMETER_VALUE = Joiner
      .on(',').join(ISSUE_FIELD_NAMES);

  private final IssueUrlBuilder urlBuilder;
  private final UrlContentReader urlContentReader;
  private final Gson gson;

  /**
   * Creates a new instance of the implementation for retrieving issues from a comic book series from the Comicvine API.
   *
   * @param urlBuilder       Needed for building the Comicvine API URL for reading issue.
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  IssueReaderImpl(
      IssueUrlBuilder urlBuilder,
      UrlContentReader urlContentReader,
      Gson gson) {
    this.urlBuilder = urlBuilder;
    this.urlContentReader = urlContentReader;
    this.gson = gson;
  }

  /**
   * {@inheritDoc}
   *
   * @param apiKey   {@inheritDoc}
   * @param volumeId {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public IssuesGetResult getVolumeIssues(
      final String apiKey,
      final long volumeId) throws IOException {
    return getVolumeIssues(apiKey, volumeId, DEFAULT_LIMIT_PARAMETER_VALUE, DEFAULT_OFFSET_PARAMETER_VALUE);
  }

  /**
   * {@inheritDoc}
   *
   * @param apiKey   {@inheritDoc}
   * @param volumeId {@inheritDoc}
   * @param limit    {@inheritDoc}
   * @param offset   {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public IssuesGetResult getVolumeIssues(
      final String apiKey,
      final long volumeId,
      final Integer limit,
      final Integer offset) throws IOException {
    final Integer limitValue = limit != null ? limit : DEFAULT_LIMIT_PARAMETER_VALUE;
    final Integer offsetValue = offset != null ? offset : DEFAULT_OFFSET_PARAMETER_VALUE;

    final Map<String, String> parameter = ImmutableMap.<String, String>builder()
        .put(Constants.API_KEY_PARAMETER_NAME, apiKey)
        .put(FORMAT_PARAMETER_NAME, FORMAT_PARAMETER_VALUE)
        .put(LIMIT_PARAMETER_NAME, limitValue.toString())
        .put(OFFSET_PARAMETER_NAME, offsetValue.toString())
        .put(FIELD_LIST_PARAMETER_NAME, VOLUME_ISSUES_FIELD_LIST_PARAMETER_VALUE)
        .build();
    final URL apiUrl = this.urlBuilder.buildIssuesGetUrl(volumeId, parameter);
    final String jsonContent = this.urlContentReader.getJson(apiUrl);

    final JsonElement jsonElement = JsonParser.parseString(jsonContent);
    final JsonObject jsonObject = jsonElement.getAsJsonObject();

    return this.gson.fromJson(jsonObject, IssuesGetResult.class);
  }

  /**
   * {@inheritDoc}
   *
   * @param apiKey  {@inheritDoc}
   * @param issueId {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public IssueGetResult getIssue(
      final String apiKey,
      final long issueId) throws IOException {
    final Map<String, String> parameter = ImmutableMap.<String, String>builder()
        .put(Constants.API_KEY_PARAMETER_NAME, apiKey)
        .put(FORMAT_PARAMETER_NAME, FORMAT_PARAMETER_VALUE)
        .put(LIMIT_PARAMETER_NAME, DEFAULT_LIMIT_PARAMETER_VALUE.toString())
        .put(FIELD_LIST_PARAMETER_NAME, ISSUE_FIELD_LIST_PARAMETER_VALUE)
        .build();
    final URL apiUrl = this.urlBuilder.buildIssueGetUrl(issueId, parameter);
    final String jsonContent = this.urlContentReader.getJson(apiUrl);

    final JsonElement jsonElement = JsonParser.parseString(jsonContent);
    final JsonObject jsonObject = jsonElement.getAsJsonObject();

    return this.gson.fromJson(jsonObject, IssueGetResult.class);
  }
}
