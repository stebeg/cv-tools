package io.github.stebeg.comicvine.common.response;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import io.github.stebeg.comicvine.common.ComicvineEntity;

import java.util.List;

/**
 * A representation of a list response from the Comicvine API.
 *
 * @param <T> The type of the retrieved objects.
 */
public class ApiListResponse<T extends ComicvineEntity> {

  @SerializedName(value = ResponseAttribute.STATUS_CODE)
  private final int statusCode;

  @SerializedName(value = ResponseAttribute.RESULT)
  private final List<T> results;

  @SerializedName(value = ResponseAttribute.NUMBER_OF_PAGE_RESULTS)
  private long numberOfPageResults = 0;

  @SerializedName(value = ResponseAttribute.NUMBER_OF_TOTAL_RESULTS)
  private long numberOfTotalResults = 0;

  @SerializedName(value = ResponseAttribute.LIMIT)
  private long limit = ResponseAttribute.DEFAULT_LIMIT;

  @SerializedName(value = ResponseAttribute.OFFSET)
  private long offset = ResponseAttribute.DEFAULT_OFFSET;

  /**
   * Creates a new representation of a list response from the Comicvine API.
   *
   * @param statusCode The status code of the response. Check {@link StatusCode} for possible values.
   * @param results    The retrieved object.
   */
  public ApiListResponse(int statusCode, List<T> results) {
    this.statusCode = statusCode;
    this.results = results == null ? List.of() : results;
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
   * Returns the retrieved objects.
   *
   * @return The retrieved objects.
   */
  public List<T> getResults() {
    return this.results;
  }

  /**
   * Returns the number of results for the current result page.
   *
   * @return The number of results.
   */
  public long getNumberOfPageResults() {
    return this.numberOfPageResults;
  }

  /**
   * Sets the number of results for the current result page.
   *
   * @param numberOfPageResults The number of results.
   */
  public void setNumberOfPageResults(long numberOfPageResults) {
    this.numberOfPageResults = numberOfPageResults;
  }

  /**
   * Returns the total number of available results.
   *
   * @return The total number of available results.
   */
  public long getNumberOfTotalResults() {
    return this.numberOfTotalResults;
  }

  /**
   * Sets the total number of available results.
   *
   * @param numberOfTotalResults The total number of available results.
   */
  public void setNumberOfTotalResults(long numberOfTotalResults) {
    this.numberOfTotalResults = numberOfTotalResults;
  }

  /**
   * Returns the limit of results per page.
   *
   * @return The limit of results per page.
   */
  public long getLimit() {
    return this.limit;
  }

  /**
   * Sets the limit of results per page.
   *
   * @param limit The limit of results per page.
   */
  public void setLimit(long limit) {
    this.limit = limit;
  }

  /**
   * Returns the offset of results.
   *
   * @return The offset of results.
   */
  public long getOffset() {
    return this.offset;
  }

  /**
   * Sets the offset of results.
   *
   * @param offset The offset of results.
   */
  public void setOffset(long offset) {
    this.offset = offset;
  }

  /**
   * {@inheritDoc}
   *
   * @param obj {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof ApiListResponse<?> that)) {
      return false;
    }
    return this.statusCode == that.statusCode
        && this.numberOfPageResults == that.numberOfPageResults
        && this.numberOfTotalResults == that.numberOfTotalResults
        && this.limit == that.limit
        && this.offset == that.offset
        && Objects.equal(this.results, that.results);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(this.statusCode, this.results, this.numberOfPageResults, this.numberOfTotalResults,
        this.limit, this.offset);
  }
}
