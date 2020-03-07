package com.github.stebeg.tool.cv;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * A representation of the result retrieved from the Comicvine API when reading issues of a volume.
 *
 * @author Steffen Berger
 */
public class IssuesGetResult {

    private static final String STATUS_CODE_ATTRIBUTE_NAME = "status_code";
    private static final String NUMBER_OF_PAGE_RESULTS_ATTRIBUTE_NAME = "number_of_page_results";
    private static final String NUMBER_OF_TOTAL_RESULTS_ATTRIBUTE_NAME = "number_of_total_results";
    private static final String ITEMS_ATTRIBUTE_NAME = "results";

    @SerializedName(value = STATUS_CODE_ATTRIBUTE_NAME)
    private final int statusCode;

    @SerializedName(value = NUMBER_OF_PAGE_RESULTS_ATTRIBUTE_NAME)
    private final long numberOfPageResults;

    @SerializedName(value = NUMBER_OF_TOTAL_RESULTS_ATTRIBUTE_NAME)
    private final long numberOfTotalResults;

    @SerializedName(value = ITEMS_ATTRIBUTE_NAME)
    private final List<Issue> issues = Lists.newArrayList();

    /**
     * Creates a new representation of the result retrieved from the Comicvine API when reading issues
     * of a volume.
     *
     * @param statusCode           The status code of the response. {code 1} means the request was
     *                             successful.
     * @param numberOfPageResults  The number of issues in this response.
     * @param numberOfTotalResults The total number of issues of the volume.
     */
    IssuesGetResult(
        int statusCode,
        long numberOfPageResults,
        long numberOfTotalResults) {
        this.statusCode = statusCode;
        this.numberOfPageResults = numberOfPageResults;
        this.numberOfTotalResults = numberOfTotalResults;
    }

    /**
     * @return The status code of the response. {code 1} means the request was successful.
     */
    public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * @return The number of issues in this response.
     */
    public long getNumberOfPageResults() {
        return this.numberOfPageResults;
    }

    /**
     * @return The total number of issues of the volume.
     */
    public long getNumberOfTotalResults() {
        return this.numberOfTotalResults;
    }

    /**
     * @return The issues of the volume in this response.
     */
    public List<Issue> getIssues() {
        return this.issues;
    }
}
