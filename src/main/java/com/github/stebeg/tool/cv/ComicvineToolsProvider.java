/**
 * The MIT License
 * <p>
 * Copyright 2019 Steffen Berger.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.github.stebeg.tool.cv;

import com.github.stebeg.tool.cv.issue.IssueReader;
import com.github.stebeg.tool.cv.issue.IssueReaderProvider;
import com.github.stebeg.tool.cv.volume.VolumeReader;
import com.github.stebeg.tool.cv.volume.VolumeReaderProvider;

/**
 * Provides instances of implementations of the interfaces for reading information from the
 * Comicvine API.
 *
 * @author Steffen Berger
 */
public final class ComicvineToolsProvider {

  private static final VolumeReader VOLUME_READER = VolumeReaderProvider.getInstance();
  private static final IssueReader ISSUE_READER = IssueReaderProvider.getInstance();

  private ComicvineToolsProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link VolumeReader}.
   * @see VolumeReader
   */
  public static VolumeReader getVolumeReader() {
    return VOLUME_READER;
  }

  /**
   * @return The only instance of the implementation of {@link IssueReader}.
   * @see IssueReader
   */
  public static IssueReader getIssueReader() {
    return ISSUE_READER;
  }
}
