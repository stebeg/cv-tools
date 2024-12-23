package com.github.stebeg.comicvine;

import com.github.stebeg.comicvine.character.CharacterRetriever;
import com.github.stebeg.comicvine.common.request.UrlConnectionBuilder;
import com.github.stebeg.comicvine.common.request.UrlContentReader;
import com.google.gson.Gson;

public class ComicvineTools {

  private static final CharacterRetriever CHARACTER_RETRIEVER = new CharacterRetriever(
      new UrlContentReader(new UrlConnectionBuilder()),
      new Gson());

  /**
   * Retrieves a singleton instance of the {@link CharacterRetriever}.
   *
   * @return A singleton instance of the {@link CharacterRetriever}.
   */
  public static CharacterRetriever getCharacterRetriever() {
    return CHARACTER_RETRIEVER;
  }

}
