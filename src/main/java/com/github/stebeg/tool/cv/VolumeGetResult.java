package com.github.stebeg.tool.cv;

import com.google.gson.annotations.SerializedName;

/**
 * A representation of the result retrieved from the Comicvine API when reading
 * volume information.
 * 
 * @author Steffen Berger
 */
public class VolumeGetResult {

    static final String STATUS_CODE_ATTRIBUTE_NAME = "status_code";
    static final String RESULT_ATTRIBUTE_NAME = "results";

    @SerializedName(value = STATUS_CODE_ATTRIBUTE_NAME)
    private final int statusCode;

    @SerializedName(value = RESULT_ATTRIBUTE_NAME)
    private final Volume volume;

    /**
     * Creates a new representation of the result retrieved from the Comicvine
     * API when reading volume information.
     *
     * @param statusCode The status code of the response. {code 1} means the
     * request was successful.
     * @param volume The retrieved volume.
     */
    VolumeGetResult(int statusCode, Volume volume) {
        this.statusCode = statusCode;
        this.volume = volume;
    }

    /**
     * @return The status code of the response. {code 1} means the request was
     * successful.
     */
    public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * @return The retrieved volume.
     */
    public Volume getVolume() {
        return this.volume;
    }
}
