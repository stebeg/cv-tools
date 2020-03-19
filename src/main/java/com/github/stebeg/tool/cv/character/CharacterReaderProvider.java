package com.github.stebeg.tool.cv.character;

import com.github.stebeg.tool.cv.common.UrlContentReaderProvider;
import com.google.gson.Gson;

/**
 * Provides an instance of the implementation of the {@link CharacterReader} interface for reading
 * information from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class CharacterReaderProvider {

  private static final CharacterReader CHARACTER_READER = new CharacterReaderImpl(
      new CharacterUrlBuilderImpl(),
      UrlContentReaderProvider.getInstance(),
      new Gson());

  private CharacterReaderProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link CharacterReader}.
   * @see CharacterReader
   */
  public static final CharacterReader getInstance() {
    return CHARACTER_READER;
  }
}
