package com.github.stebeg.tool.cv;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Steffen Berger
 */
public class UrlBuilderImplTest {

    private final UrlBuilderImpl instance;

    public UrlBuilderImplTest() {
        this.instance = new UrlBuilderImpl();
    }

    @Test
    public void testBuildSearchUrl() throws IOException {
        final String paramName = "foo", paramValue = "bar";
        final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
        final String expPath = UrlBuilderImpl.API_BASE_URL
                .concat(UrlBuilderImpl.API_SEARCH_URL_FRAGMENT)
                .concat("?").concat(UrlBuilderImpl.CLIENT_PARAMETER_NAME)
                .concat("=").concat(UrlBuilderImpl.CLIENT_PARAMETER_VALUE)
                .concat("&").concat(paramName).concat("=").concat(paramValue);

        final URL result = this.instance.buildVolumeSearchUrl(parameter);
        assertEquals(expPath, result.toString());
    }

    @Test
    public void testBuildVolumeGetUrl() throws IOException {
        final long volumeId = 1234L;
        final String paramName = "foo", paramValue = "bar";
        final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
        final String expPath = UrlBuilderImpl.API_BASE_URL
                .concat(UrlBuilderImpl.API_VOLUME_URL_FRAGMENT)
                .concat("4050-").concat(String.valueOf(volumeId)).concat("/")
                .concat("?").concat(UrlBuilderImpl.CLIENT_PARAMETER_NAME)
                .concat("=").concat(UrlBuilderImpl.CLIENT_PARAMETER_VALUE)
                .concat("&").concat(paramName).concat("=").concat(paramValue);

        final URL result = this.instance.buildVolumeGetUrl(volumeId, parameter);
        assertEquals(expPath, result.toString());
    }

    @Test
    public void testBuildIssuesGetUrl() throws IOException {
        final long volumeId = 1234L;
        final String paramName = "foo", paramValue = "bar";
        final String filterParamName = "filter", filterParamValue = "volume%3A1234";
        final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
        final String expPath = UrlBuilderImpl.API_BASE_URL
                .concat(UrlBuilderImpl.API_ISSUES_URL_FRAGMENT)
                .concat("?").concat(UrlBuilderImpl.CLIENT_PARAMETER_NAME)
                .concat("=").concat(UrlBuilderImpl.CLIENT_PARAMETER_VALUE)
                .concat("&").concat(paramName).concat("=").concat(paramValue)
                .concat("&").concat(filterParamName).concat("=").concat(filterParamValue);

        final URL result = this.instance.buildIssuesGetUrl(volumeId, parameter);
        assertEquals(expPath, result.toString());
    }

    @Test
    public void testBuildIssueGetUrl() throws IOException {
        final long issueId = 1234L;
        final String paramName = "foo", paramValue = "bar";
        final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
        final String expPath = UrlBuilderImpl.API_BASE_URL
                .concat(UrlBuilderImpl.API_ISSUE_URL_FRAGMENT)
                .concat("4000-").concat(String.valueOf(issueId)).concat("/")
                .concat("?").concat(UrlBuilderImpl.CLIENT_PARAMETER_NAME)
                .concat("=").concat(UrlBuilderImpl.CLIENT_PARAMETER_VALUE)
                .concat("&").concat(paramName).concat("=").concat(paramValue);

        final URL result = this.instance.buildIssueGetUrl(issueId, parameter);
        assertEquals(expPath, result.toString());
    }
}
