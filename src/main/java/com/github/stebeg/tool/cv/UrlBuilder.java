package com.github.stebeg.tool.cv;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * An interface for building Comicvine API URLs.
 * 
 * @author Steffen Berger
 */
interface UrlBuilder {

    /**
     * Builds an URL for searching volumes via Comicvine API.
     *
     * @param parameter The query parameters which will be added to the search
     * URL. The keys in this map represent the parameter names. The values of
     * this map represent the parameter values.
     * @return The URL for searching volumes via Comicvine API.
     * @throws IOException When building the URL fails.
     */
    URL buildVolumeSearchUrl(Map<String, String> parameter) throws IOException;

    /**
     * Builds an URL for retrieving volume information from the Comicvine API.
     *
     * @param volumeId The ID of the volume.
     * @param parameter The additional parameters which will be added to the
     * URL. The keys in this map represent the parameter names. The values of
     * this map represent the parameter values.
     * @return The URL for retrieving volume information from the Comicvine API.
     * @throws IOException When building the URL fails.
     */
    URL buildVolumeGetUrl(long volumeId, Map<String, String> parameter) throws IOException;

    /**
     * Builds an URL for retrieving issue information for a volume from the
     * Comicvine API.
     *
     * @param volumeId The ID of the volume.
     * @param parameter The additional parameters which will be added to the
     * URL. The keys in this map represent the parameter names. The values of
     * this map represent the parameter values.
     * @return The URL for retrieving issue information for a volume from the
     * Comicvine API.
     * @throws IOException When building the URL fails.
     */
    URL buildIssuesGetUrl(long volumeId, Map<String, String> parameter) throws IOException;

    /**
     * Builds an URL for retrieving issue information from the Comicvine API.
     *
     * @param issueId The ID of the Issue.
     * @param parameter The additional parameters which will be added to the
     * URL. The keys in this map represent the parameter names. The values of
     * this map represent the parameter values.
     * @return The URL for retrieving issue information from the Comicvine API.
     * @throws IOException When building the URL fails.
     */
    URL buildIssueGetUrl(long issueId, Map<String, String> parameter) throws IOException;

}
