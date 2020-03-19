package com.github.stebeg.tool.cv.team;

import com.github.stebeg.tool.cv.common.AbstractApiGetResult;

/**
 * A representation of the result retrieved from the Comicvine API for reading teams.
 *
 * @author Steffen Berger
 */
public class TeamGetResult extends AbstractApiGetResult<Team> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API for reading teams.
   *
   * @param statusCode The status code of the response. {code 1} means the request was successful.
   * @param object     The retrieved team.
   */
  TeamGetResult(int statusCode, Team object) {
    super(statusCode, object);
  }

  /**
   * @return The retrieved team.
   */
  @Override
  public Team getResult() {
    return super.getResult();
  }

}
