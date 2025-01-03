package io.github.stebeg.comicvine.storyarc;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.github.stebeg.comicvine.common.AbstractComicvineEntityRetriever;
import io.github.stebeg.comicvine.common.request.AbstractApiRequest;
import io.github.stebeg.comicvine.common.request.UrlContentReader;
import io.github.stebeg.comicvine.common.response.ApiListResponse;
import io.github.stebeg.comicvine.common.response.ApiResponse;
import io.github.stebeg.comicvine.common.response.EmptyApiListResponse;
import io.github.stebeg.comicvine.common.response.EmptyApiResponse;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * An implementation for retrieving story arcs from the Comicvine API.
 */
public class StoryArcRetriever extends AbstractComicvineEntityRetriever {

  private final Gson gson;

  /**
   * Creates a new instance for retrieving story arcs from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  public StoryArcRetriever(UrlContentReader urlContentReader, Gson gson) {
    super(urlContentReader);
    this.gson = gson;
  }

  /**
   * Retrieves detailed information about a story arc by its unique ID.
   *
   * @param request The request to retrieve detailed information about a story arc.
   * @return The response containing detailed information about a story arc.
   * @throws IOException If an I/O error occurs.
   */
  public ApiResponse<StoryArc> getStoryArcById(
      final GetStoryArcByIdRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiResponse<>();
    }
    final Type type = new TypeToken<ApiResponse<StoryArc>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

  /**
   * Retrieves a list of story arcs.
   *
   * @param request The request to retrieve a list of story arcs.
   * @return The response containing a list of story arcs.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<StoryArcListItem> getStoryArcs(
      final GetStoryArcListRequest request) throws IOException {
    return getStoryArcListItemResponse(request);
  }

  /**
   * Searches for story arcs.
   *
   * @param request The request to search for story arcs.
   * @return The response containing the search result.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<StoryArcListItem> searchStoryArcss(
      final SearchStoryArcsRequest request) throws IOException {
    return getStoryArcListItemResponse(request);
  }

  /**
   * Retrieves a list of story arcs by a specific request.
   *
   * @param request The request to retrieve a list of story arcs.
   * @return The response containing a list of story arcs.
   * @throws IOException If an I/O error occurs.
   */
  private ApiListResponse<StoryArcListItem> getStoryArcListItemResponse(
      final AbstractApiRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiListResponse<>();
    }
    final Type type = new TypeToken<ApiListResponse<StoryArcListItem>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

}
