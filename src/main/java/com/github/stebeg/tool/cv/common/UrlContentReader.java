package com.github.stebeg.tool.cv.common;

import java.io.IOException;
import java.net.URL;

/**
 * An interface for retrieving content from an {@link URL}.
 *
 * @author Steffen Berger
 */
public interface UrlContentReader {

    /**
     * Retrieves JSON content from an {@link URL}.
     *
     * @param url The {@link URL}.
     * @return The JSON content as {@link String}.
     * @throws IOException When reading the content from the {@link URL} fails, i.e. the {@link URL}
     *                     is invalid.
     */
    String getJson(URL url) throws IOException;

}
