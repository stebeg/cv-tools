package com.github.stebeg.tool.cv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.character.CharacterReader;
import com.github.stebeg.tool.cv.issue.IssueReader;
import com.github.stebeg.tool.cv.team.TeamReader;
import com.github.stebeg.tool.cv.volume.VolumeReader;
import org.junit.jupiter.api.Test;

/**
 * @author Steffen Berger
 */
public class ComicvineToolsProviderTest {

  @Test
  public void testGetCharacterReader() {
    final CharacterReader characterReader1 = ComicvineToolsProvider.getCharacterReader();
    final CharacterReader characterReader2 = ComicvineToolsProvider.getCharacterReader();
    assertEquals(characterReader1, characterReader2);
  }

  @Test
  public void testGetTeamReader() {
    final TeamReader teamReader1 = ComicvineToolsProvider.getTeamReader();
    final TeamReader teamReader2 = ComicvineToolsProvider.getTeamReader();
    assertEquals(teamReader1, teamReader2);
  }

  @Test
  public void testGetVolumeReader() {
    final VolumeReader volumeReader1 = ComicvineToolsProvider.getVolumeReader();
    final VolumeReader volumeReader2 = ComicvineToolsProvider.getVolumeReader();
    assertEquals(volumeReader1, volumeReader2);
  }

  @Test
  public void testGetIssueReader() {
    final IssueReader issueReader1 = ComicvineToolsProvider.getIssueReader();
    final IssueReader issueReader2 = ComicvineToolsProvider.getIssueReader();
    assertEquals(issueReader1, issueReader2);
  }

}
