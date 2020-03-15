package com.github.stebeg.tool.cv.character;

import com.github.stebeg.tool.cv.common.AbstractApiGetResult;

/**
 * A representation of the result retrieved from the Comicvine API for reading characters.
 *
 * @author Steffen Berger
 */
public class CharacterGetResult extends AbstractApiGetResult<Character> {

  /**
   * Creates a new representation of the result retrieved from the Comicvine API for reading
   * characters.
   *
   * @param statusCode The status code of the response. {code 1} means the request was successful.
   * @param object     The retrieved character.
   */
  CharacterGetResult(int statusCode, Character object) {
    super(statusCode, object);
  }

  /**
   * @return The retrieved character.
   */
  @Override
  public Character getResult() {
    return super.getResult();
  }
}
