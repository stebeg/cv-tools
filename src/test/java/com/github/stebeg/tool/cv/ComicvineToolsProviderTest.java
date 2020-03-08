package com.github.stebeg.tool.cv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.issue.IssueReader;
import com.github.stebeg.tool.cv.volume.VolumeReader;
import org.junit.jupiter.api.Test;

/**
 * @author Steffen Berger
 */
public class ComicvineToolsProviderTest {

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
