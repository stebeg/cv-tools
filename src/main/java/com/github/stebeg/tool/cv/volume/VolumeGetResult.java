package com.github.stebeg.tool.cv.volume;

import com.github.stebeg.tool.cv.common.AbstractApiGetResult;

/**
 * A representation of the result retrieved from the Comicvine API when reading volume information.
 *
 * @author Steffen Berger
 */
public class VolumeGetResult extends AbstractApiGetResult<Volume> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API when reading volume
   * information.
   *
   * @param statusCode The status code of the response. {code 1} means the request was successful.
   * @param object     The retrieved volume.
   */
  VolumeGetResult(int statusCode, Volume object) {
    super(statusCode, object);
  }

  /**
   * @return The retrieved volume.
   */
  @Override
  public Volume getResult() {
    return super.getResult();
  }
}
