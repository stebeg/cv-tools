package com.github.stebeg.tool.cv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Steffen Berger
 */
public class ComicvineToolsProviderTest {

  @Test
  public void testGetVolumeReader() {
    final VolumeReader volumeReader1 = ComicvineToolsProvider.getVolumeReader();
    final VolumeReader volumeReader2 = ComicvineToolsProvider.getVolumeReader();

    assertTrue(volumeReader1 instanceof VolumeReaderImpl);
    assertEquals(volumeReader1, volumeReader2);
  }

  @Test
  public void testGetIssueReader() {
    final IssueReader issueReader1 = ComicvineToolsProvider.getIssueReader();
    final IssueReader issueReader2 = ComicvineToolsProvider.getIssueReader();

    assertTrue(issueReader1 instanceof IssueReaderImpl);
    assertEquals(issueReader1, issueReader2);
  }

}
