package com.github.stebeg.tool.cv.common;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractApiGetResult<T> {

  private static final String STATUS_CODE_ATTRIBUTE_NAME = "status_code";
  private static final String RESULT_ATTRIBUTE_NAME = "results";

  @SerializedName(value = STATUS_CODE_ATTRIBUTE_NAME)
  private final int statusCode;

  @SerializedName(value = RESULT_ATTRIBUTE_NAME)
  private final T object;

  /**
   * Creates a new representation of the result retrieved from the Comicvine API.
   *
   * @param statusCode The status code of the response. {code 1} means the request was successful.
   * @param object     The retrieved object.
   */
  public AbstractApiGetResult(int statusCode, T object) {
    this.statusCode = statusCode;
    this.object = object;
  }

  /**
   * @return The status code of the response. {code 1} means the request was successful.
   */
  public int getStatusCode() {
    return this.statusCode;
  }

  /**
   * @return The retrieved object.
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
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final AbstractApiGetResult<?> that = (AbstractApiGetResult<?>) obj;
    return this.statusCode == that.statusCode &&
        Objects.equal(this.object, that.object);
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
