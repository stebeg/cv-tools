package com.github.stebeg.tool.cv.person;

import com.github.stebeg.tool.cv.common.UrlContentReaderProvider;
import com.google.gson.Gson;

/**
 * Provides an instance of the implementation of the {@link PersonReader} interface for reading
 * information from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class PersonReaderProvider {

  private static final PersonReader PERSON_READER = new PersonReaderImpl(
      new PersonUrlBuilderImpl(),
      UrlContentReaderProvider.getInstance(),
      new Gson());

  private PersonReaderProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link PersonReader}.
   * @see PersonReader
   */
  public static final PersonReader getInstance() {
    return PERSON_READER;
  }

}
