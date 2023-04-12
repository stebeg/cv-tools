package com.github.stebeg.tool.cv.storyarc;

import com.github.stebeg.tool.cv.common.AbstractApiGetListResult;
import java.util.List;

/**
 * A representation of the result retrieved from the Comicvine API when searching for story arcs. The search result is split into pages.
 *
 * @author Steffen Berger
 */
public class StoryArcSearchResult extends AbstractApiGetListResult<StoryArc> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API when searching for story arcs. The search result is split into pages.
   *
   * @param statusCode           The status code of the response. {code 1} means the request was successful.
   * @param numberOfPageResults  The number of story arcs for the current result page.
   * @param numberOfTotalResults The total number of found story arcs.
   */
  public StoryArcSearchResult(int statusCode, long numberOfPageResults, long numberOfTotalResults) {
    super(statusCode, numberOfPageResults, numberOfTotalResults);
  }

  /**
   * @return The story arcs from the current page of the search result.
   */
  @Override
  public List<StoryArc> getResult() {
    return super.getResult();
  }
}
