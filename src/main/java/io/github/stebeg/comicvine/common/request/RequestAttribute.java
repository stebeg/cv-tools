package io.github.stebeg.comicvine.common.request;

/**
 * A collection of attributes of requests to the Comicvine API.
 */
public class RequestAttribute {

  /**
   * The base URL to the Comicvine API.
   */
  public static final String API_BASE_URL = "https://comicvine.gamespot.com/api";

  /**
   * For retrieving data from the Comicvine API, a parameter for an API key is needed. This is the
   * name of this parameter.
   */
  public static final String API_KEY = "api_key";

  /**
   * For retrieving data from the Comicvine API, a parameter is needed to identify the software.
   * This is the name of this parameter.
   */
  public static final String CLIENT = "client";

  /**
   * For retrieving data from the Comicvine API, a parameter is needed to identify the software.
   * This is the value of this parameter.
   */
  public static final String CLIENT_VALUE = "cv-tools";

  /**
   * The Name of the parameter that defines the format of the response.
   */
  public static final String FORMAT_PARAMETER_NAME = "format";

  /**
   * The value for the format parameter to request JSON formatted responses.
   */
  public static final String JSON_FORMAT_PARAMETER_VALUE = "json";

  /**
   * The name of the parameter for the field names to include in the response. Use this if you want to
   * reduce the size of the response payload.
   */
  public static final String FIELD_LIST = "field_list";

  /**
   * The name of the parameter for filtering the response.
   */
  public static final String FILTER = "filter";

  /**
   * The name of the parameter for the query.
   */
  public static final String QUERY = "query";

  /**
   * The name of the parameter for the resources to search in.
   */
  public static final String RESOURCES = "resources";

  /**
   * The name of the parameter for sorting the response.
   */
  public static final String SORT = "sort";

  /**
   * The attribute name for the limit of results per page.
   */
  public static final String LIMIT = "limit";

  /**
   * The attribute name for the offset of results.
   */
  public static final String OFFSET = "offset";

}
