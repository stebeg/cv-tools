package com.github.stebeg.tool.cv;

import java.io.IOException;

/**
 * An interface for retrieving issues from a comic book series from the Comicvine API.
 *
 * @author Steffen Berger
 */
public interface IssueReader {

    /**
     * Retrieves a list of issues of a volume from the Comicvine API.
     *
     * @param apiKey   An API key needed for retrieving information from the Comicvine API.
     * @param volumeId The unique ID of the volume the issue are retrieved for.
     * @return The response from the Comicvine API containing the issues.
     * @throws IOException When the communication with the Comicvine API or reading the information
     *                     fails.
     */
    IssuesGetResult getVolumeIssues(String apiKey, long volumeId) throws IOException;

    /**
     * Retrieves information for an issue from the Comicvine API.
     *
     * @param apiKey  An API key needed for retrieving information from the Comicvine API.
     * @param issueId The unique ID of the issue to retrieve.
     * @return The response from the Comicvine API containing the issue.
     * @throws IOException When the communication with the Comicvine API or reading the information
     *                     fails.
     */
    IssueGetResult getIssue(String apiKey, long issueId) throws IOException;

}
