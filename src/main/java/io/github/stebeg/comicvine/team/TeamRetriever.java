package io.github.stebeg.comicvine.team;

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
 * An implementation for retrieving teams from the Comicvine API.
 */
public class TeamRetriever extends AbstractComicvineEntityRetriever {

  private final Gson gson;

  /**
   * Creates a new instance for retrieving teams from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  public TeamRetriever(UrlContentReader urlContentReader, Gson gson) {
    super(urlContentReader);
    this.gson = gson;
  }

  /**
   * Retrieves detailed information about a team by its unique ID.
   *
   * @param request The request to retrieve detailed information about a team.
   * @return The response containing detailed information about a team.
   * @throws IOException If an I/O error occurs.
   */
  public ApiResponse<Team> getTeamById(
      final GetTeamByIdRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (isEmptyObjectResponse(jsonObject)) {
      return new EmptyApiResponse<>();
    }
    final Type type = new TypeToken<ApiResponse<Team>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

  /**
   * Retrieves a list of teams.
   *
   * @param request The request to retrieve a list of teams.
   * @return The response containing a list of teams.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<TeamListItem> getTeams(
      final GetTeamListRequest request) throws IOException {
    return getTeamListItemResponse(request);
  }

  /**
   * Searches for teams.
   *
   * @param request The request to search for teams.
   * @return The response containing the search result.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<TeamListItem> searchTeams(
      final SearchTeamsRequest request) throws IOException {
    return getTeamListItemResponse(request);
  }

  /**
   * Retrieves a list of teams by a specific request.
   *
   * @param request The request to retrieve a list of teams.
   * @return The response containing a list of teams.
   * @throws IOException If an I/O error occurs.
   */
  private ApiListResponse<TeamListItem> getTeamListItemResponse(
      final AbstractApiRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiListResponse<>();
    }
    final Type type = new TypeToken<ApiListResponse<TeamListItem>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

}
