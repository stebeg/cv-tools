package com.github.stebeg.comicvine.character;

import com.github.stebeg.comicvine.common.request.AbstractApiRequest;
import com.github.stebeg.comicvine.common.request.RequestAttribute;
import com.google.common.base.Joiner;

import java.util.List;

/**
 * An API request for retrieving a list of characters.
 */
public class GetCharacterListRequest extends AbstractApiRequest {

  /**
   * The URL fragment for the characters API.
   */
  public static final String API_URL_FRAGMENT = "/characters";

  /**
   * Creates a new API request for retrieving a list of characters.
   *
   * @param apiKey The API key for accessing the Comicvine API.
   * @param filter The result can be filtered:
   *               <ul>
   *               <li>Single filter: filter=field:value</li>
   *               <li>Multiple filters: filter=field:value,field:value</li>
   *               <li>Date filters: filter=field:start value|end value (using datetime format)</li>
   *               </ul>
   */
  public GetCharacterListRequest(String apiKey, String filter) {
    super(apiKey);
    getParameter().put(RequestAttribute.FILTER, filter);
  }

  /**
   * Sets the sort order of the response.
   *
   * @param sort The sort order of the response.
   * @return This request.
   */
  public GetCharacterListRequest withSort(final String sort) {
    getParameter().put(RequestAttribute.SORT, sort);
    return this;
  }

  /**
   * Sets the limit of results per page.
   *
   * @param limit The limit of results per page.
   * @return This request.
   */
  public GetCharacterListRequest withLimit(int limit) {
    getParameter().put(RequestAttribute.LIMIT, String.valueOf(limit));
    return this;
  }

  /**
   * Sets the offset of results.
   *
   * @param offset The offset of results.
   * @return This request.
   */
  public GetCharacterListRequest withOffset(int offset) {
    getParameter().put(RequestAttribute.OFFSET, String.valueOf(offset));
    return this;
  }

  /**
   * Sets the field names to include in the response. Use this if you want to reduce the size of the response payload.
   *
   * @param fieldNames The names of the fields to retrieve.
   * @return This request.
   */
  public GetCharacterListRequest withFields(final List<String> fieldNames) {
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
