package com.github.stebeg.tool.cv.team;

import com.github.stebeg.tool.cv.common.UrlContentReaderProvider;
import com.google.gson.Gson;

/**
 * Provides an instance of the implementation of the {@link TeamReader} interface for reading
 * information from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class TeamReaderProvider {

  private static final TeamReader TEAM_READER = new TeamReaderImpl(
      new TeamUrlBuilderImpl(),
      UrlContentReaderProvider.getInstance(),
      new Gson());

  private TeamReaderProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link TeamReader}.
   * @see TeamReader
   */
  public static final TeamReader getInstance() {
    return TEAM_READER;
  }
}
