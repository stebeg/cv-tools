package io.github.stebeg.comicvine.character;

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
 * An implementation for retrieving characters from the Comicvine API.
 */
public class CharacterRetriever extends AbstractComicvineEntityRetriever {

  private final Gson gson;

  /**
   * Creates a new instance for retrieving characters from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  public CharacterRetriever(UrlContentReader urlContentReader, Gson gson) {
    super(urlContentReader);
    this.gson = gson;
  }

  /**
   * Retrieves detailed information about a character by its unique ID.
   *
   * @param request The request to retrieve detailed information about a character.
   * @return The response containing detailed information about a character.
   * @throws IOException If an I/O error occurs.
   */
  public ApiResponse<Character> getCharacterById(
      final GetCharacterByIdRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiResponse<>();
    }
    final Type type = new TypeToken<ApiResponse<Character>>() {}.getType();
    return this.gson.fromJson(jsonObject, type);
  }

  /**
   * Retrieves a list of characters.
   *
   * @param request The request to retrieve a list of characters.
   * @return The response containing a list of characters.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<CharacterListItem> getCharacters(
      final GetCharacterListRequest request) throws IOException {
    return getCharacterListItemResponse(request);
  }

  /**
   * Searches for characters.
   *
   * @param request The request to search for characters.
   * @return The response containing the search result.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<CharacterListItem> searchCharacters(
      final SearchCharactersRequest request) throws IOException {
    return getCharacterListItemResponse(request);
  }

  /**
   * Retrieves a list of characters by a specific request.
   *
   * @param request The request to retrieve a list of characters.
   * @return The response containing a list of characters.
   * @throws IOException If an I/O error occurs.
   */
  private ApiListResponse<CharacterListItem> getCharacterListItemResponse(
      final AbstractApiRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiListResponse<>();
    }
    final Type type = new TypeToken<ApiListResponse<CharacterListItem>>() {}.getType();
    return this.gson.fromJson(jsonObject, type);
  }

}
