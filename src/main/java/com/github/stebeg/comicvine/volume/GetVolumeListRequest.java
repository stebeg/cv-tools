package com.github.stebeg.comicvine.volume;

import com.github.stebeg.comicvine.common.request.AbstractApiRequest;
import com.github.stebeg.comicvine.common.request.RequestAttribute;
import com.google.common.base.Joiner;

import java.util.List;

/**
 * An API request for retrieving a list of volumes.
 */
public class GetVolumeListRequest extends AbstractApiRequest {

  /**
   * The URL fragment for the volumes API.
   */
  public static final String API_URL_FRAGMENT = "/volumes";

  /**
   * Creates a new API request for retrieving a list of volumes.
   *
   * @param apiKey The API key for accessing the Comicvine API.
   * @param filter The result can be filtered:
   *               <ul>
   *               <li>Single filter: filter=field:value</li>
   *               <li>Multiple filters: filter=field:value,field:value</li>
   *               <li>Date filters: filter=field:start value|end value (using datetime format)</li>
   *               </ul>
   */
  public GetVolumeListRequest(String apiKey, String filter) {
    super(apiKey);
    getParameter().put(RequestAttribute.FILTER, filter);
  }

  /**
   * Sets the sort order of the response.
   *
   * @param sort The sort order of the response.
   * @return This request.
   */
  public GetVolumeListRequest withSort(final String sort) {
    getParameter().put(RequestAttribute.SORT, sort);
    return this;
  }

  /**
   * Sets the limit of results per page.
   *
   * @param limit The limit of results per page.
   * @return This request.
   */
  public GetVolumeListRequest withLimit(int limit) {
    getParameter().put(RequestAttribute.LIMIT, String.valueOf(limit));
    return this;
  }

  /**
   * Sets the offset of results.
   *
   * @param offset The offset of results.
   * @return This request.
   */
  public GetVolumeListRequest withOffset(int offset) {
    getParameter().put(RequestAttribute.OFFSET, String.valueOf(offset));
    return this;
  }

  /**
   * Sets the field names to include in the response. Use this if you want to reduce the size of the response payload.
   *
   * @param fieldNames The names of the fields to retrieve.
   * @return This request.
   */
  public GetVolumeListRequest withFields(final List<String> fieldNames) {
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
