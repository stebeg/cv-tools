package com.github.stebeg.tool.cv.sample;

import com.github.stebeg.tool.cv.ComicvineToolsProvider;
import com.github.stebeg.tool.cv.Issue;
import com.github.stebeg.tool.cv.IssueGetResult;
import com.github.stebeg.tool.cv.IssueReader;
import java.io.IOException;

/**
 * Sample code for retrieving issue information.
 *
 * @author Steffen Berger
 */
public class ReadIssueInformationSample {

    public static final void main() throws IOException {
        final String apiKey = "abcdef12345";
        final long issueId = 310551L;

        final IssueReader issueReader = ComicvineToolsProvider.getIssueReader();
        final IssueGetResult result = issueReader.getIssue(apiKey, issueId);

        final Issue issue = result.getIssue();
        System.out.println("Issue number = " + issue.getIssueNumber());
    }

}
