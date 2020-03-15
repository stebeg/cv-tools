package com.github.stebeg.tool.cv.issue;

import com.github.stebeg.tool.cv.common.AbstractApiGetListResult;
import java.util.List;

/**
 * A representation of the result retrieved from the Comicvine API when reading issues of a volume.
 *
 * @author Steffen Berger
 */
public class IssuesGetResult extends AbstractApiGetListResult<Issue> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API when reading issues
   * of a volume.
   *
   * @param statusCode           The status code of the response. {code 1} means the request was
   *                             successful.
   * @param numberOfPageResults  The number of issues in this response.
   * @param numberOfTotalResults The total number of issues of the volume.
   */
  IssuesGetResult(
      int statusCode,
      long numberOfPageResults,
      long numberOfTotalResults) {
    super(statusCode, numberOfPageResults, numberOfTotalResults);
  }

  /**
   * @return The issues of the volume in this response.
   */
  @Override
  public List<Issue> getResult() {
    return super.getResult();
  }
}
