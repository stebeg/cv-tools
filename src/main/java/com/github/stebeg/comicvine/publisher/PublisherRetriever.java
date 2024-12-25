package com.github.stebeg.comicvine.publisher;

import com.github.stebeg.comicvine.common.AbstractComicvineEntityRetriever;
import com.github.stebeg.comicvine.common.request.AbstractApiRequest;
import com.github.stebeg.comicvine.common.request.UrlContentReader;
import com.github.stebeg.comicvine.common.response.ApiListResponse;
import com.github.stebeg.comicvine.common.response.ApiResponse;
import com.github.stebeg.comicvine.common.response.EmptyApiListResponse;
import com.github.stebeg.comicvine.common.response.EmptyApiResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * An implementation for retrieving publishers from the Comicvine API.
 */
public class PublisherRetriever extends AbstractComicvineEntityRetriever {

  private final Gson gson;

  /**
   * Creates a new instance for retrieving publishers from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  public PublisherRetriever(UrlContentReader urlContentReader, Gson gson) {
    super(urlContentReader);
    this.gson = gson;
  }

  /**
   * Retrieves detailed information about a publisher by its unique ID.
   *
   * @param request The request to retrieve detailed information about a publisher.
   * @return The response containing detailed information about a publisher.
   * @throws IOException If an I/O error occurs.
   */
  public ApiResponse<Publisher> getPublisherById(
      final GetPublisherByIdRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiResponse<>();
    }
    final Type type = new TypeToken<ApiResponse<Publisher>>() {}.getType();
    return this.gson.fromJson(jsonObject, type);
  }

  /**
   * Retrieves a list of publishers.
   *
   * @param request The request to retrieve a list of publishers.
   * @return The response containing a list of publishers.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<PublisherListItem> getPublishers(
      final GetPublisherListRequest request) throws IOException {
    return getPublisherListItemResponse(request);
  }

  /**
   * Searches for publishers.
   *
   * @param request The request to search for publishers.
   * @return The response containing the search result.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<PublisherListItem> searchpublishers(
      final SearchPublishersRequest request) throws IOException {
    return getPublisherListItemResponse(request);
  }

  /**
   * Retrieves a list of publishers by a specific request.
   *
   * @param request The request to retrieve a list of publishers.
   * @return The response containing a list of publishers.
   * @throws IOException If an I/O error occurs.
   */
  private ApiListResponse<PublisherListItem> getPublisherListItemResponse(
      final AbstractApiRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiListResponse<>();
    }
    final Type type = new TypeToken<ApiListResponse<PublisherListItem>>() {}.getType();
    return this.gson.fromJson(jsonObject, type);
  }

}
