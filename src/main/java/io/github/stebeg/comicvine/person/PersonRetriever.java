package io.github.stebeg.comicvine.person;

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
 * An implementation for retrieving people from the Comicvine API.
 */
public class PersonRetriever extends AbstractComicvineEntityRetriever {

  private final Gson gson;

  /**
   * Creates a new instance for retrieving people from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  public PersonRetriever(UrlContentReader urlContentReader, Gson gson) {
    super(urlContentReader);
    this.gson = gson;
  }

  /**
   * Retrieves detailed information about a person by its unique ID.
   *
   * @param request The request to retrieve detailed information about a person.
   * @return The response containing detailed information about a person.
   * @throws IOException If an I/O error occurs.
   */
  public ApiResponse<Person> getPersonById(
      final GetPersonByIdRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (isEmptyObjectResponse(jsonObject)) {
      return new EmptyApiResponse<>();
    }
    final Type type = new TypeToken<ApiResponse<Person>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

  /**
   * Retrieves a list of people.
   *
   * @param request The request to retrieve a list of people.
   * @return The response containing a list of people.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<PersonListItem> getPeople(
      final GetPersonListRequest request) throws IOException {
    return getPersonListItemResponse(request);
  }

  /**
   * Searches for people.
   *
   * @param request The request to search for people.
   * @return The response containing the search result.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<PersonListItem> searchPeople(
      final SearchPeopleRequest request) throws IOException {
    return getPersonListItemResponse(request);
  }

  /**
   * Retrieves a list of people by a specific request.
   *
   * @param request The request to retrieve a list of people.
   * @return The response containing a list of people.
   * @throws IOException If an I/O error occurs.
   */
  private ApiListResponse<PersonListItem> getPersonListItemResponse(
      final AbstractApiRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiListResponse<>();
    }
    final Type type = new TypeToken<ApiListResponse<PersonListItem>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

}
