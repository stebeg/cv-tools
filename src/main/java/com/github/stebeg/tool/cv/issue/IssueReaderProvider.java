package com.github.stebeg.tool.cv.issue;

import com.github.stebeg.tool.cv.common.UrlContentReaderProvider;
import com.google.gson.Gson;

/**
 * Provides an instance of the implementation of the {@link IssueReader} interfaces for reading
 * information from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class IssueReaderProvider {

  private static final IssueReader ISSUE_READER = new IssueReaderImpl(
      new IssueUrlBuilderImpl(),
      UrlContentReaderProvider.getInstance(),
      new Gson());

  private IssueReaderProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link IssueReader}.
   * @see IssueReader
   */
  public static final IssueReader getInstance() {
    return ISSUE_READER;
  }
}
