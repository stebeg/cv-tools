package com.github.stebeg.tool.cv.storyarc;

import com.github.stebeg.tool.cv.common.AbstractApiGetResult;

/**
 * A representation of the result retrieved from the Comicvine API for reading story arcs.
 *
 * @author Steffen Berger
 */
public class StoryArcGetResult extends AbstractApiGetResult<StoryArc> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API for reading story arcs.
   *
   * @param statusCode The status code of the response. {code 1} means the request was successful.
   * @param object     The retrieved story arc.
   */
  StoryArcGetResult(int statusCode, StoryArc object) {
    super(statusCode, object);
  }

  /**
   * @return The retrieved story arc.
   */
  @Override
  public StoryArc getResult() {
    return super.getResult();
  }

}
