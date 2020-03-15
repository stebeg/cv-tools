package com.github.stebeg.tool.cv.volume;

import com.github.stebeg.tool.cv.common.AbstractApiGetListResult;
import java.util.List;

/**
 * A representation of the result retrieved from the Comicvine API when searching for volumes. The
 * search result is split into pages.
 *
 * @author Steffen Berger
 */
public class VolumeSearchResult extends AbstractApiGetListResult<Volume> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API when searching for
   * volumes. The search result is split into pages.
   *
   * @param statusCode           The status code of the response. {code 1} means the request was
   *                             successful.
   * @param numberOfPageResults  The number of volumes for the current result page.
   * @param numberOfTotalResults The total number of found volumes.
   */
  VolumeSearchResult(
      int statusCode,
      long numberOfPageResults,
      long numberOfTotalResults) {
    super(statusCode, numberOfPageResults, numberOfTotalResults);
  }

  /**
   * @return The volumes from the current page of the search result.
   */
  @Override
  public List<Volume> getResult() {
    return super.getResult();
  }

}
