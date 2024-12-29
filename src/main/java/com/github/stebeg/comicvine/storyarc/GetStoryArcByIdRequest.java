package com.github.stebeg.comicvine.storyarc;

import com.github.stebeg.comicvine.common.request.AbstractApiRequest;
import com.github.stebeg.comicvine.common.request.RequestAttribute;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;

import java.util.List;

/**
 * An API request for retrieving detailed information about a story arc.
 */
public class GetStoryArcByIdRequest extends AbstractApiRequest {

  /**
   * The URL fragment for the story arc API.
   */
  public static final String API_URL_FRAGMENT = "/story_arc";

  private final long id;

  /**
   * Creates a new API request for retrieving detailed information about a story arc.
   *
   * @param apiKey The API key for accessing the Comicvine API.
   * @param id     The unique ID of the story arc.
   */
  public GetStoryArcByIdRequest(String apiKey, long id) {
    super(apiKey);
    this.id = id;
  }

  /**
   * Returns the unique ID of the story arc.
   *
   * @return The ID of the story arc.
   */
  public long getId() {
    return this.id;
  }

  /**
   * Sets the field names to include in the response. Use this if you want to reduce the size of the response payload.
   *
   * @param fieldNames The names of the fields to retrieve.
   * @return This request.
   */
  public GetStoryArcByIdRequest withFieldNames(final List<String> fieldNames) {
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
    final String urlFragment = API_URL_FRAGMENT
        .concat("/")
        .concat("4005-").concat(String.valueOf(this.id))
        .concat("/");
    return urlFragment;
  }

  /**
   * {@inheritDoc}
   *
   * @param object {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object object) {
    if (!(object instanceof GetStoryArcByIdRequest that)) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    return this.id == that.id;
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hashCode(super.hashCode(), this.id);
  }
}
