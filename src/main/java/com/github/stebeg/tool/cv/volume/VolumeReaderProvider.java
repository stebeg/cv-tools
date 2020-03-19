package com.github.stebeg.tool.cv.volume;

import com.github.stebeg.tool.cv.common.UrlContentReaderProvider;
import com.google.gson.Gson;

/**
 * Provides an instance of the implementation of the {@link VolumeReader} interface for reading
 * information from the Comicvine API.
 *
 * @author Steffen Berger
 */
public class VolumeReaderProvider {

  private static final VolumeReader VOLUME_READER = new VolumeReaderImpl(
      new VolumeUrlBuilderImpl(),
      UrlContentReaderProvider.getInstance(),
      new Gson());

  private VolumeReaderProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link VolumeReader}.
   * @see VolumeReader
   */
  public static final VolumeReader getInstance() {
    return VOLUME_READER;
  }
}
