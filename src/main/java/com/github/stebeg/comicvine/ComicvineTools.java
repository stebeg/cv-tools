package com.github.stebeg.comicvine;

import com.github.stebeg.comicvine.character.CharacterRetriever;
import com.github.stebeg.comicvine.common.request.UrlConnectionBuilder;
import com.github.stebeg.comicvine.common.request.UrlContentReader;
import com.github.stebeg.comicvine.publisher.PublisherRetriever;
import com.google.gson.Gson;

/**
 * Provides access to the Comicvine API.
 */
public class ComicvineTools {

  private static final CharacterRetriever CHARACTER_RETRIEVER = new CharacterRetriever(
      new UrlContentReader(new UrlConnectionBuilder()),
      new Gson());

  private static final PublisherRetriever PUBLISHER_RETRIEVER = new PublisherRetriever(
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

  /**
   * Retrieves a singleton instance of the {@link PublisherRetriever}.
   *
   * @return A singleton instance of the {@link PublisherRetriever}.
   */
  public static PublisherRetriever getPublisherRetriever() {
    return PUBLISHER_RETRIEVER;
  }

}
