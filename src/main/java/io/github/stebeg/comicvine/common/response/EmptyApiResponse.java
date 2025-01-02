package io.github.stebeg.comicvine.common.response;

import io.github.stebeg.comicvine.common.ComicvineEntity;

/**
 * Represents an empty response from the Comicvine API.
 *
 * @param <T> The type of the retrieved object.
 */
public class EmptyApiResponse<T extends ComicvineEntity> extends ApiResponse<T> {

  /**
   * Creates a new representation of an empty response from the Comicvine API.
   */
  public EmptyApiResponse() {
    super(StatusCode.OBJECT_NOT_FOUND.getCode(), null);
  }
}
