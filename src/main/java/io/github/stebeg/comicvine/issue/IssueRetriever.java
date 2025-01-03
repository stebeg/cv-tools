package io.github.stebeg.comicvine.issue;

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
 * An implementation for retrieving issues from the Comicvine API.
 */
public class IssueRetriever extends AbstractComicvineEntityRetriever {

  private final Gson gson;

  /**
   * Creates a new instance for retrieving issues from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  public IssueRetriever(UrlContentReader urlContentReader, Gson gson) {
    super(urlContentReader);
    this.gson = gson;
  }

  /**
   * Retrieves detailed information about an issue by its unique ID.
   *
   * @param request The request to retrieve detailed information about an issue.
   * @return The response containing detailed information about an issue.
   * @throws IOException If an I/O error occurs.
   */
  public ApiResponse<Issue> getIssueById(
      final GetIssueByIdRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiResponse<>();
    }
    final Type type = new TypeToken<ApiResponse<Issue>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

  /**
   * Retrieves a list of issues.
   *
   * @param request The request to retrieve a list of issues.
   * @return The response containing a list of issues.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<IssueListItem> getIssues(
      final GetIssueListRequest request) throws IOException {
    return getIssueListItemResponse(request);
  }

  /**
   * Searches for issues.
   *
   * @param request The request to search for issues.
   * @return The response containing the search result.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<IssueListItem> searchIssues(
      final SearchIssuesRequest request) throws IOException {
    return getIssueListItemResponse(request);
  }

  /**
   * Retrieves a list of issues by a specific request.
   *
   * @param request The request to retrieve a list of issues.
   * @return The response containing a list of issues.
   * @throws IOException If an I/O error occurs.
   */
  private ApiListResponse<IssueListItem> getIssueListItemResponse(
      final AbstractApiRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiListResponse<>();
    }
    final Type type = new TypeToken<ApiListResponse<IssueListItem>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

}
