package io.github.stebeg.comicvine.volume;

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
 * An implementation for retrieving volumes from the Comicvine API.
 */
public class VolumeRetriever extends AbstractComicvineEntityRetriever {

  private final Gson gson;

  /**
   * Creates a new instance for retrieving volumes from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   * @param gson             Builds objects from the JSON response retrieved from the Comicvine API.
   */
  public VolumeRetriever(UrlContentReader urlContentReader, Gson gson) {
    super(urlContentReader);
    this.gson = gson;
  }

  /**
   * Retrieves detailed information about a volume by its unique ID.
   *
   * @param request The request to retrieve detailed information about a volume.
   * @return The response containing detailed information about a volume.
   * @throws IOException If an I/O error occurs.
   */
  public ApiResponse<Volume> getVolumeById(
      final GetVolumeByIdRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (isEmptyObjectResponse(jsonObject)) {
      return new EmptyApiResponse<>();
    }
    final Type type = new TypeToken<ApiResponse<Volume>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

  /**
   * Retrieves a list of volumes.
   *
   * @param request The request to retrieve a list of volumes.
   * @return The response containing a list of volumes.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<VolumeListItem> getVolumes(
      final GetVolumeListRequest request) throws IOException {
    return getVolumeListItemResponse(request);
  }

  /**
   * Searches for volumes.
   *
   * @param request The request to search for volumes.
   * @return The response containing the search result.
   * @throws IOException If an I/O error occurs.
   */
  public ApiListResponse<VolumeListItem> searchVolumes(
      final SearchVolumesRequest request) throws IOException {
    return getVolumeListItemResponse(request);
  }

  /**
   * Retrieves a list of volumes by a specific request.
   *
   * @param request The request to retrieve a list of volumes.
   * @return The response containing a list of volumes.
   * @throws IOException If an I/O error occurs.
   */
  private ApiListResponse<VolumeListItem> getVolumeListItemResponse(
      final AbstractApiRequest request) throws IOException {
    final JsonObject jsonObject = super.getJsonObject(request);
    if (jsonObject == null) {
      return new EmptyApiListResponse<>();
    }
    final Type type = new TypeToken<ApiListResponse<VolumeListItem>>() {
    }.getType();
    return this.gson.fromJson(jsonObject, type);
  }

}
