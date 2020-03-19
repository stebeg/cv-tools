package com.github.stebeg.tool.cv.publisher;

import com.github.stebeg.tool.cv.common.AbstractApiGetResult;

/**
 * A representation of the result retrieved from the Comicvine API for reading publishers.
 *
 * @author Steffen Berger
 */
public class PublisherGetResult extends AbstractApiGetResult<Publisher> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API for reading
   * publishers.
   *
   * @param statusCode The status code of the response. {code 1} means the request was successful.
   * @param object     The retrieved publisher.
   */
  PublisherGetResult(int statusCode, Publisher object) {
    super(statusCode, object);
  }

  /**
   * @return The retrieved publisher.
   */
  @Override
  public Publisher getResult() {
    return super.getResult();
  }
}
