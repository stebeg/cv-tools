package com.github.stebeg.tool.cv.common;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractApiGetListResult<T> extends AbstractApiGetResult<List<T>> {

  static final String NUMBER_OF_PAGE_RESULTS_ATTRIBUTE_NAME = "number_of_page_results";
  static final String NUMBER_OF_TOTAL_RESULTS_ATTRIBUTE_NAME = "number_of_total_results";

  @SerializedName(NUMBER_OF_PAGE_RESULTS_ATTRIBUTE_NAME)
  private final long numberOfPageResults;

  @SerializedName(NUMBER_OF_TOTAL_RESULTS_ATTRIBUTE_NAME)
  private final long numberOfTotalResults;

  public AbstractApiGetListResult(
      int statusCode,
      long numberOfPageResults,
      long numberOfTotalResults) {
    super(statusCode, new ArrayList<>());
    this.numberOfPageResults = numberOfPageResults;
    this.numberOfTotalResults = numberOfTotalResults;
  }

  /**
   * @return The number of volumes for the current result page.
   */
  public long getNumberOfPageResults() {
    return this.numberOfPageResults;
  }

  /**
   * @return The total number of found volumes.
   */
  public long getNumberOfTotalResults() {
    return this.numberOfTotalResults;
  }

}
