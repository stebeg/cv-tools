package com.github.stebeg.comicvine.location;

import com.github.stebeg.comicvine.common.request.AbstractApiRequest;
import com.github.stebeg.comicvine.common.request.RequestAttribute;
import com.google.common.base.Joiner;

import java.util.List;

/**
 * An implementation of {@link AbstractApiRequest} for searching locations in the Comicvine API.
 */
public class SearchLocationsRequest extends AbstractApiRequest {

  public static final String API_URL_FRAGMENT = "/search/";
  public static final String RESOURCES_PARAMETER_VALUE = "location";

  /**
   * Creates a new request for searching locations in the Comicvine API.
   *
   * @param apiKey     The API key for accessing the Comicvine API.
   * @param searchText The text to search for.
   */
  public SearchLocationsRequest(String apiKey, String searchText) {
    super(apiKey);
    getParameter().put(RequestAttribute.QUERY, searchText);
    getParameter().put(RequestAttribute.RESOURCES, RESOURCES_PARAMETER_VALUE);
  }

  /**
   * Sets the sort order of the response.
   *
   * @param sort The sort order of the response.
   * @return This request.
   */
  public SearchLocationsRequest withSort(final String sort) {
    getParameter().put(RequestAttribute.SORT, sort);
    return this;
  }

  /**
   * Sets the limit of results per page.
   *
   * @param limit The limit of results per page.
   * @return This request.
   */
  public SearchLocationsRequest withLimit(int limit) {
    getParameter().put(RequestAttribute.LIMIT, String.valueOf(limit));
    return this;
  }

  /**
   * Sets the offset of results.
   *
   * @param offset The offset of results.
   * @return This request.
   */
  public SearchLocationsRequest withOffset(int offset) {
    getParameter().put(RequestAttribute.OFFSET, String.valueOf(offset));
    return this;
  }

  /**
   * Sets the field names to include in the response. Use this if you want to reduce the size of the response payload.
   *
   * @param fieldNames The names of the fields to retrieve.
   * @return This request.
   */
  public SearchLocationsRequest withFields(final List<String> fieldNames) {
    final String fieldNameList = Joiner.on(',').join(fieldNames);
    getParameter().put(RequestAttribute.FIELD_LIST, fieldNameList);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  protected String getRequestUrlFragment() {
    return API_URL_FRAGMENT;
  }
}
