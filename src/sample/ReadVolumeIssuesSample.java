package com.github.stebeg.tool.cv.sample;

import com.github.stebeg.tool.cv.ComicvineToolsProvider;
import com.github.stebeg.tool.cv.Issue;
import com.github.stebeg.tool.cv.IssueReader;
import com.github.stebeg.tool.cv.IssuesGetResult;
import java.io.IOException;

/**
 * Sample code for retrieving issues information for a volume.
 *
 * @author Steffen Berger
 */
public class ReadVolumeIssuesSample {

    public static final void main() throws IOException {
        final String apiKey = "abcdef12345";
        final long volumeId = 2839L;

        final IssueReader issueReader = ComicvineToolsProvider.getIssueReader();
        final IssuesGetResult result = issueReader.getVolumeIssues(apiKey, volumeId);

        for (final Issue issue : result.getIssues()) {
            System.out.println("Issue number = " + issue.getIssueNumber());
        }
    }

}
