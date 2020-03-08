package com.github.stebeg.tool.cv.common;

/**
 * Provides an instance of an implementation of the {@link UrlContentReader} interface for reading
 * content from an URL.
 */
public class UrlContentReaderProvider {

  private static final UrlContentReader URL_CONTENT_READER
      = new UrlContentReaderImpl(new UrlConnectionBuilderImpl());

  private UrlContentReaderProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link UrlContentReader}.
   * @see UrlContentReader
   */
  public static final UrlContentReader getInstance() {
    return URL_CONTENT_READER;
  }
}
