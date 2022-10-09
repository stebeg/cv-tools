package com.github.stebeg.tool.cv.storyarc;

import com.github.stebeg.tool.cv.common.UrlContentReaderProvider;
import com.google.gson.Gson;

/**
 * Provides an instance of the implementation of the {@link StoryArcReader} interface for reading information from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class StoryArcReaderProvider {

  private static final StoryArcReader STORY_ARC_READER = new StoryArcReaderImpl(
      new StoryArcUrlBuilderImpl(),
      UrlContentReaderProvider.getInstance(),
      new Gson());

  private StoryArcReaderProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link StoryArcReader}.
   * @see StoryArcReader
   */
  public static final StoryArcReader getInstance() {
    return STORY_ARC_READER;
  }

}
