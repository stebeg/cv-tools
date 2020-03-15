package com.github.stebeg.tool.cv.character;

import com.github.stebeg.tool.cv.common.UrlContentReaderProvider;
import com.google.gson.Gson;

public class CharacterReaderProvider {

  private static final CharacterReader CHARACTER_READER = new CharacterReaderImpl(
      new CharacterUrlBuilderImpl(),
      UrlContentReaderProvider.getInstance(),
      new Gson());

  private CharacterReaderProvider() {
    throw new UnsupportedOperationException();
  }

  public static final CharacterReader getInstance() {
    return CHARACTER_READER;
  }
}
