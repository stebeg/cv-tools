package com.github.stebeg.comicvine.location;

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
 * An implementation for retrieving locations from the Comicvine API.
 */
public class LocationRetriever extends AbstractComicvineEntityRetriever {

  private final Gson gson;

  /**
   * Creates a new instance for retrieving locations from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  public LocationRetriever(UrlContentReader urlContentReader, Gson gson) {
    super(urlContentReader);
    this.gson = gson;
  }

  /**
   * Retrieves detailed information about a location by its unique ID.
   *
   * @param request The request to retrieve detailed information about a location.
   * @return The response containing detailed information about a location.
   * @throws IOException If an I/O error occurs.
   */
  public ApiResponse<Location> getLocationById(
      final GetLocationByIdRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiResponse<>();
    }
    final Type type = new TypeToken<ApiResponse<Location>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

  /**
   * Retrieves a list of locations.
   *
   * @param request The request to retrieve a list of locations.
   * @return The response containing a list of locations.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<LocationListItem> getLocations(
      final GetLocationListRequest request) throws IOException {
    return getLocationListItemResponse(request);
  }

  /**
   * Searches for locations.
   *
   * @param request The request to search for locations.
   * @return The response containing the search result.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<LocationListItem> searchLocations(
      final SearchLocationsRequest request) throws IOException {
    return getLocationListItemResponse(request);
  }

  /**
   * Retrieves a list of locations by a specific request.
   *
   * @param request The request to retrieve a list of locations.
   * @return The response containing a list of locations.
   * @throws IOException If an I/O error occurs.
   */
  private ApiListResponse<LocationListItem> getLocationListItemResponse(
      final AbstractApiRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiListResponse<>();
    }
    final Type type = new TypeToken<ApiListResponse<LocationListItem>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

}
