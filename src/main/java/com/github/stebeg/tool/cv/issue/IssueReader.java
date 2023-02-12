package com.github.stebeg.tool.cv.issue;

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
   * @return The response from the Comicvine API containing the issues. The number of results defaults to 100 and can not exceed this number.
   * @throws IOException When the communication with the Comicvine API or reading the information fails.
   */
  IssuesGetResult getVolumeIssues(String apiKey, long volumeId) throws IOException;

  /**
   * Retrieves a list of issues of a volume from the Comicvine API.
   *
   * @param apiKey   An API key needed for retrieving information from the Comicvine API.
   * @param volumeId The unique ID of the volume the issue are retrieved for.
   * @param limit    The number of results to display per page. This value defaults to 100 and can not exceed this number.
   * @param offset   Return results starting with the object at the offset specified.
   * @return The response from the Comicvine API containing the issues.
   * @throws IOException When the communication with the Comicvine API or reading the information fails.
   */
  IssuesGetResult getVolumeIssues(String apiKey, long volumeId, Integer limit, Integer offset) throws IOException;

  /**
   * Retrieves information for an issue from the Comicvine API.
   *
   * @param apiKey  An API key needed for retrieving information from the Comicvine API.
   * @param issueId The unique ID of the issue to retrieve.
   * @return The response from the Comicvine API containing the issue.
   * @throws IOException When the communication with the Comicvine API or reading the information fails.
   */
  IssueGetResult getIssue(String apiKey, long issueId) throws IOException;

}
