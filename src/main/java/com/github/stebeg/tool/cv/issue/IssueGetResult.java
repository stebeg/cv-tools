package com.github.stebeg.tool.cv.issue;

import com.github.stebeg.tool.cv.common.AbstractApiGetResult;

/**
 * A representation of the result retrieved from the Comicvine API when reading issue information.
 *
 * @author Steffen Berger
 */
public class IssueGetResult extends AbstractApiGetResult<Issue> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API when reading issue
   * information.
   *
   * @param statusCode The status code of the response. {code 1} means the request was successful.
   * @param issue      The retrieved issue.
   */
  IssueGetResult(int statusCode, Issue issue) {
    super(statusCode, issue);
  }

  /**
   * @return The retrieved issue.
   */
  @Override
  public Issue getResult() {
    return super.getResult();
  }
}
