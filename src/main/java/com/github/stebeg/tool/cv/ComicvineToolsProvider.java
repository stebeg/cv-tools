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

import com.github.stebeg.tool.cv.character.CharacterReader;
import com.github.stebeg.tool.cv.character.CharacterReaderProvider;
import com.github.stebeg.tool.cv.issue.IssueReader;
import com.github.stebeg.tool.cv.issue.IssueReaderProvider;
import com.github.stebeg.tool.cv.person.PersonReader;
import com.github.stebeg.tool.cv.person.PersonReaderProvider;
import com.github.stebeg.tool.cv.publisher.PublisherReader;
import com.github.stebeg.tool.cv.publisher.PublisherReaderProvider;
import com.github.stebeg.tool.cv.storyarc.StoryArcReader;
import com.github.stebeg.tool.cv.storyarc.StoryArcReaderProvider;
import com.github.stebeg.tool.cv.team.TeamReader;
import com.github.stebeg.tool.cv.team.TeamReaderProvider;
import com.github.stebeg.tool.cv.volume.VolumeReader;
import com.github.stebeg.tool.cv.volume.VolumeReaderProvider;

/**
 * Provides instances of implementations of the interfaces for reading information from the
 * Comicvine API.
 *
 * @author Steffen Berger
 */
public final class ComicvineToolsProvider {

  private static final CharacterReader CHARACTER_READER = CharacterReaderProvider.getInstance();
  private static final TeamReader TEAM_READER = TeamReaderProvider.getInstance();
  private static final PublisherReader PUBLISHER_READER = PublisherReaderProvider.getInstance();
  private static final PersonReader PERSON_READER = PersonReaderProvider.getInstance();
  private static final VolumeReader VOLUME_READER = VolumeReaderProvider.getInstance();
  private static final IssueReader ISSUE_READER = IssueReaderProvider.getInstance();
  private static final StoryArcReader STORY_ARC_READER = StoryArcReaderProvider.getInstance();

  private ComicvineToolsProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The only instance of the implementation of {@link CharacterReader}.
   * @see CharacterReader
   */
  public static CharacterReader getCharacterReader() {
    return CHARACTER_READER;
  }

  /**
   * @return The only instance of the implementation of {@link TeamReader}.
   * @see TeamReader
   */
  public static TeamReader getTeamReader() {
    return TEAM_READER;
  }

  /**
   * @return The only instance of the implementation of {@link PublisherReader}.
   * @see PublisherReader
   */
  public static PublisherReader getPublisherReader() {
    return PUBLISHER_READER;
  }

  /**
   * @return The only instance of the implementation of {@link PersonReader}.
   * @see PersonReader
   */
  public static PersonReader getPersonReader() {
    return PERSON_READER;
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

  /**
   * @return The only instance of the implementation of {@link StoryArcReader}.
   * @see StoryArcReader
   */
  public static StoryArcReader getStoryArcReader() {
    return STORY_ARC_READER;
  }
}
