package com.github.stebeg.tool.cv;

import com.google.gson.annotations.SerializedName;

/**
 * A representation of the result retrieved from the Comicvine API when reading
 * issue information.
 * 
 * @author Steffen Berger
 */
public class IssueGetResult {

    private static final String STATUS_CODE_ATTRIBUTE_NAME = "status_code";
    private static final String RESULT_ATTRIBUTE_NAME = "results";

    @SerializedName(value = STATUS_CODE_ATTRIBUTE_NAME)
    private final int statusCode;

    @SerializedName(value = RESULT_ATTRIBUTE_NAME)
    private final Issue issue;

    /**
     * Creates a new representation of the result retrieved from the Comicvine
     * API when reading issue information.
     *
     * @param statusCode The status code of the response. {code 1} means the
     * request was successful.
     * @param issue The retrieved issue.
     */
    IssueGetResult(int statusCode, Issue issue) {
        this.statusCode = statusCode;
        this.issue = issue;
    }

    /**
     * @return The status code of the response. {code 1} means the request was
     * successful.
     */
    public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * @return The retrieved issue.
     */
    public Issue getIssue() {
        return this.issue;
    }
}
