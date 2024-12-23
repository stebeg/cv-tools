package com.github.stebeg.comicvine.common.response;

import com.github.stebeg.comicvine.common.ComicvineEntity;

import java.util.List;

/**
 * Represents an empty list response from the Comicvine API.
 *
 * @param <T> The type of the retrieved objects.
 */
public class EmptyApiListResponse<T extends ComicvineEntity> extends ApiListResponse<T> {

  /**
   * Creates a new representation of an empty list response from the Comicvine API.
   */
  public EmptyApiListResponse() {
    super(StatusCode.OBJECT_NOT_FOUND.getCode(), List.of());
  }
}
