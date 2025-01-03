package io.github.stebeg.comicvine.common.response;

/**
 * A collection of attributes of responses from the Comicvine API.
 */
public class ResponseAttribute {

  /**
   * The attribute name for the status code of the response.
   */
  public static final String STATUS_CODE = "status_code";

  /**
   * The attribute name for the result inside the response.
   */
  public static final String RESULT = "results";

  /**
   * The attribute name for the number of results on the current page.
   */
  public static final String NUMBER_OF_PAGE_RESULTS = "number_of_page_results";
  /**
   * The attribute name for the total number of results.
   */
  public static final String NUMBER_OF_TOTAL_RESULTS = "number_of_total_results";

  /**
   * The attribute name for the limit of results per page.
   */
  public static final String LIMIT = "limit";
  /**
   * The default limit for results.
   */
  public static final int DEFAULT_LIMIT = 100;

  /**
   * The attribute name for the offset of results.
   */
  public static final String OFFSET = "offset";
  /**
   * The default offset for results.
   */
  public static final int DEFAULT_OFFSET = 0;

}
