package com.github.stebeg.tool.cv.person;

import com.github.stebeg.tool.cv.common.AbstractApiGetResult;
import com.google.common.base.MoreObjects;

/**
 * A representation of the result retrieved from the Comicvine API for reading a person.
 *
 * @author Steffen Berger
 */
public class PersonGetResult extends AbstractApiGetResult<Person> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API for reading a
   * person.
   *
   * @param statusCode The status code of the response. {code 1} means the request was successful.
   * @param object     The retrieved person.
   */
  PersonGetResult(int statusCode, Person object) {
    super(statusCode, object);
  }

  /**
   * @return The retrieved person.
   */
  @Override
  public Person getResult() {
    return super.getResult();
  }

}
