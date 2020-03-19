package com.github.stebeg.tool.cv.publisher;

import com.github.stebeg.tool.cv.common.UrlContentReaderProvider;
import com.google.gson.Gson;

/**
 * Provides an instance of the implementation of the {@link PublisherReader} interface for reading
 * information from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class PublisherReaderProvider {

  private static final PublisherReader PUBLISHER_READER = new PublisherReaderImpl(
      new PublisherUrlBuilderImpl(),
      UrlContentReaderProvider.getInstance(),
      new Gson());

  private PublisherReaderProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link PublisherReader}.
   * @see PublisherReader
   */
  public static final PublisherReader getInstance() {
    return PUBLISHER_READER;
  }

}
