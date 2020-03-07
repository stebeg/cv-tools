package com.github.stebeg.tool.cv;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;

/**
 * An implementation for building Comicvine API URLs.
 *
 * @author Steffen Berger
 */
class UrlBuilderImpl implements UrlBuilder {

    /**
     * The base URL to the Comicvine API.
     */
    static final String API_BASE_URL = "https://comicvine.gamespot.com/api/";

    /**
     * The URL fragment appended to {@link UrlBuilderImpl#API_BASE_URL} to build the URL for searching
     * volumes via Comicvine API.
     */
    static final String API_SEARCH_URL_FRAGMENT = "searchVolumes/";

    /**
     * The URL fragment appended to {@link UrlBuilderImpl#API_BASE_URL} to build the URL for
     * retrieving volume information from the Comicvine API.
     */
    static final String API_VOLUME_URL_FRAGMENT = "volume/";

    /**
     * The URL fragment appended to {@link UrlBuilderImpl#API_BASE_URL} to build the URL for
     * retrieving issue information for a volume from the Comicvine API.
     */
    static final String API_ISSUES_URL_FRAGMENT = "issues/";

    /**
     * The URL fragment appended to {@link UrlBuilderImpl#API_BASE_URL} to build the URL for
     * retrieving issue information from the Comicvine API.
     */
    static final String API_ISSUE_URL_FRAGMENT = "issue/";

    /**
     * For retrieving data from the Comicvine API, a parameter is needed to identify the software.
     * This is the name of this parameter.
     */
    static final String CLIENT_PARAMETER_NAME = "client";

    /**
     * For retrieving data from the Comicvine API, a parameter is needed to identify the software.
     * This is the value of this parameter.
     */
    static final String CLIENT_PARAMETER_VALUE = "cv-tools";

    /**
     * Creates a new instance of the implementation for building Comicvine API URLs.
     */
    UrlBuilderImpl() {
    }

    /**
     * {@inheritDoc}
     *
     * @param parameter {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IOException {@inheritDoc}
     */
    @Override
    public URL buildVolumeSearchUrl(final Map<String, String> parameter) throws IOException {
        try {
            final URIBuilder uriBuilder = new URIBuilder(
                API_BASE_URL.concat(API_SEARCH_URL_FRAGMENT));
            uriBuilder.addParameter(
                CLIENT_PARAMETER_NAME,
                CLIENT_PARAMETER_VALUE);
            for (final String parameterName : parameter.keySet()) {
                uriBuilder.addParameter(parameterName, parameter.get(parameterName));
            }
            return uriBuilder.build().toURL();
        } catch (URISyntaxException uriSyntaxException) {
            throw new IOException(uriSyntaxException);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param volumeId  {@inheritDoc}
     * @param parameter {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IOException {@inheritDoc}
     */
    @Override
    public URL buildVolumeGetUrl(
        final long volumeId,
        final Map<String, String> parameter) throws IOException {
        try {
            final String url = API_BASE_URL
                .concat(API_VOLUME_URL_FRAGMENT)
                .concat("4050-").concat(String.valueOf(volumeId))
                .concat("/");
            final URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter(
                CLIENT_PARAMETER_NAME,
                CLIENT_PARAMETER_VALUE);
            for (final String parameterName : parameter.keySet()) {
                uriBuilder.addParameter(parameterName, parameter.get(parameterName));
            }
            return uriBuilder.build().toURL();
        } catch (URISyntaxException uriSyntaxException) {
            throw new IOException(uriSyntaxException);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param volumeId  {@inheritDoc}
     * @param parameter {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IOException {@inheritDoc}
     */
    @Override
    public URL buildIssuesGetUrl(
        final long volumeId,
        final Map<String, String> parameter) throws IOException {
        final String filterParameterName = "filter";
        final String filterParameterValue = "volume:".concat(String.valueOf(volumeId));
        try {
            final String url = API_BASE_URL
                .concat(API_ISSUES_URL_FRAGMENT);
            final URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter(
                CLIENT_PARAMETER_NAME,
                CLIENT_PARAMETER_VALUE);
            for (final String parameterName : parameter.keySet()) {
                uriBuilder.addParameter(parameterName, parameter.get(parameterName));
            }
            uriBuilder.addParameter(filterParameterName, filterParameterValue);
            return uriBuilder.build().toURL();
        } catch (URISyntaxException uriSyntaxException) {
            throw new IOException(uriSyntaxException);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param issueId   {@inheritDoc}
     * @param parameter {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IOException {@inheritDoc}
     */
    @Override
    public URL buildIssueGetUrl(
        final long issueId,
        final Map<String, String> parameter) throws IOException {
        try {
            final String url = API_BASE_URL
                .concat(API_ISSUE_URL_FRAGMENT)
                .concat("4000-").concat(String.valueOf(issueId))
                .concat("/");
            final URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter(
                CLIENT_PARAMETER_NAME,
                CLIENT_PARAMETER_VALUE);
            for (final String parameterName : parameter.keySet()) {
                uriBuilder.addParameter(parameterName, parameter.get(parameterName));
            }
            return uriBuilder.build().toURL();
        } catch (URISyntaxException uriSyntaxException) {
            throw new IOException(uriSyntaxException);
        }
    }

}
