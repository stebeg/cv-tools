package com.github.stebeg.tool.cv;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * A representation of the result retrieved from the Comicvine API when searching for volumes. The
 * search result is split into pages.
 *
 * @author Steffen Berger
 */
public class VolumeSearchResult {

    static final String STATUS_CODE_ATTRIBUTE_NAME = "status_code";
    static final String NUMBER_OF_PAGE_RESULTS_ATTRIBUTE_NAME = "number_of_page_results";
    static final String NUMBER_OF_TOTAL_RESULTS_ATTRIBUTE_NAME = "number_of_total_results";
    static final String ITEMS_ATTRIBUTE_NAME = "results";

    @SerializedName(STATUS_CODE_ATTRIBUTE_NAME)
    private final int statusCode;

    @SerializedName(NUMBER_OF_PAGE_RESULTS_ATTRIBUTE_NAME)
    private final long numberOfPageResults;

    @SerializedName(NUMBER_OF_TOTAL_RESULTS_ATTRIBUTE_NAME)
    private final long numberOfTotalResults;

    @SerializedName(ITEMS_ATTRIBUTE_NAME)
    private final List<Volume> volumes = Lists.newArrayList();

    /**
     * Creates a new representation of the result retrieved from the Comicvine API when searching for
     * volumes. The search result is split into pages.
     *
     * @param statusCode           The status code of the response. {code 1} means the request was
     *                             successful.
     * @param numberOfPageResults  The number of volumes for the current result page.
     * @param numberOfTotalResults The total number of found volumes.
     */
    VolumeSearchResult(
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
     * @return The number of volumes for the current result page.
     */
    public long getNumberOfPageResults() {
        return this.numberOfPageResults;
    }

    /**
     * @return The total number of found volumes.
     */
    public long getNumberOfTotalResults() {
        return this.numberOfTotalResults;
    }

    /**
     * @return The volumes from the current page of the search result.
     */
    public List<Volume> getVolumes() {
        return this.volumes;
    }

}
