package com.github.stebeg.tool.cv.publisher;

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
 * An implementation for retrieving publishers from the Comicvine API.
 *
 * @author Steffen Berger
 */
class PublisherReaderImpl implements PublisherReader {

  private static final String FORMAT_PARAMETER_NAME = "format";
  private static final String FORMAT_PARAMETER_VALUE = "json";

  private static final List<String> PUBLISHER_FIELD_NAMES = ImmutableList.of(
      Publisher.ID_ATTRIBUTE_NAME,
      Publisher.NAME_ATTRIBUTE_NAME,
      Publisher.SUMMARY_ATTRIBUTE_NAME,
      Publisher.DESCRIPTION_ATTRIBUTE_NAME,
      Publisher.IMAGE_ATTRIBUTE_NAME,
      Publisher.CITY_ATTRIBUTE_NAME,
      Publisher.STATE_ATTRIBUTE_NAME);

  private static final String FIELD_LIST_PARAMETER_NAME = "field_list";
  private static final String PUBLISHER_FIELD_LIST_PARAMETER_VALUE = Joiner
      .on(',').join(PUBLISHER_FIELD_NAMES);

  private final PublisherUrlBuilder urlBuilder;
  private final UrlContentReader urlContentReader;
  private final Gson gson;

  /**
   * Creates a new instance of the implementation for retrieving publishers from the Comicvine API.
   *
   * @param urlBuilder       Needed for building the Comicvine API URL for reading publishers.
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine
   *                         API.
   */
  PublisherReaderImpl(
      PublisherUrlBuilder urlBuilder,
      UrlContentReader urlContentReader,
      Gson gson) {
    this.urlBuilder = urlBuilder;
    this.urlContentReader = urlContentReader;
    this.gson = gson;
  }

  /**
   * {@inheritDoc}
   *
   * @param apiKey      {@inheritDoc}
   * @param publisherId {@inheritDoc}
   * @return {@inheritDoc}
   * @throws IOException {@inheritDoc}
   */
  @Override
  public PublisherGetResult getPublisher(
      final String apiKey,
      final long publisherId) throws IOException {
    final Map<String, String> parameter = ImmutableMap.<String, String>builder()
        .put(Constants.API_KEY_PARAMETER_NAME, apiKey)
        .put(FORMAT_PARAMETER_NAME, FORMAT_PARAMETER_VALUE)
        .put(FIELD_LIST_PARAMETER_NAME, PUBLISHER_FIELD_LIST_PARAMETER_VALUE)
        .build();
    final URL apiUrl = this.urlBuilder.buildPublisherGetUrl(publisherId, parameter);
    final String jsonContent = this.urlContentReader.getJson(apiUrl);

    final JsonElement jsonElement = JsonParser.parseString(jsonContent);
    final JsonObject jsonObject = jsonElement.getAsJsonObject();

    return this.gson.fromJson(jsonObject, PublisherGetResult.class);
  }

}
