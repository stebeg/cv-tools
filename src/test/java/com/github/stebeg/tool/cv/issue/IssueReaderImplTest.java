package com.github.stebeg.tool.cv.issue;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.stebeg.tool.cv.AbstractJsonComparisonTest;
import com.github.stebeg.tool.cv.common.UrlConnectionBuilder;
import com.github.stebeg.tool.cv.common.UrlContentReader;
import com.github.stebeg.tool.cv.common.UrlContentReaderImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;

/**
 * @author Steffen Berger
 */
public class IssueReaderImplTest extends AbstractJsonComparisonTest {

  private final IssueUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private final IssueReaderImpl instance;

  public IssueReaderImplTest() {
    this.urlBuilderMock = mock(IssueUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new IssueReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetVolumeIssues() throws Exception {
    final long volumeId = 123L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/issue/issues-get-example.json");
    when(this.urlBuilderMock.buildIssuesGetUrl(eq(volumeId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final IssuesGetResult result = this.instance.getVolumeIssues(apiKey, volumeId);
    assertJsonEquals("/issue/issues-get-example-result.json", result);
  }

  @Test
  public void testGetIssue() throws Exception {
    final long issueId = 310551L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/issue/issue-get-example.json");
    when(this.urlBuilderMock.buildIssueGetUrl(eq(issueId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final IssueGetResult result = this.instance.getIssue(apiKey, issueId);
    assertJsonEquals("/issue/issue-get-example-result.json", result);
  }

  @Test
  public void testGetIssue_FullJson() throws Exception {
    final long issueId = 164775L;
    final String apiKey = "1234567890abcdef";

    final URL url = getClass().getResource("/issue/issue-get-example-full.json");
    when(this.urlBuilderMock.buildIssueGetUrl(eq(issueId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final IssueGetResult result = this.instance.getIssue(apiKey, issueId);
    assertJsonEquals("/issue/issue-get-example-full-result.json", result);
  }
}
