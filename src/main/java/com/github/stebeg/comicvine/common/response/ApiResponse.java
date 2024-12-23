package com.github.stebeg.comicvine.common.response;

import com.github.stebeg.comicvine.common.ComicvineEntity;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * A representation of the response from the Comicvine API.
 *
 * @param <T> The type of the retrieved object.
 */
public class ApiResponse<T extends ComicvineEntity> {

  @SerializedName(value = ResponseAttribute.STATUS_CODE)
  private final int statusCode;

  @SerializedName(value = ResponseAttribute.RESULT)
  private final T object;

  /**
   * Creates a new representation of the response from the Comicvine API.
   *
   * @param statusCode The status code of the response. Check {@link StatusCode} for possible values.
   * @param object     The retrieved object.
   */
  public ApiResponse(int statusCode, T object) {
    this.statusCode = statusCode;
    this.object = object;
  }

  /**
   * Returns the API status code of the response.
   *
   * @return The status code. Check {@link StatusCode} for possible values.
   */
  public StatusCode getStatusCode() {
    return StatusCode.forCode(this.statusCode);
  }

  /**
   * Returns the retrieved object.
   *
   * @return The retrieved object. Is {@code null} if no object was found.
   */
  public T getResult() {
    return this.object;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof ApiResponse<?> that)) {
      return false;
    }
    return this.statusCode == that.statusCode
        && Objects.equal(this.object, that.object);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(this.statusCode, this.object);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("statusCode", this.statusCode)
        .add("object", this.object)
        .toString();
  }
}
