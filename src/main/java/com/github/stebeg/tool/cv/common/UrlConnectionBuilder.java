package com.github.stebeg.tool.cv.common;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * An interface for building {@link URLConnection}s.
 *
 * @author Steffen Berger
 */
public interface UrlConnectionBuilder {

    /**
     * Builds an {@link URLConnection} for an {@link URL}.
     *
     * @param url The {@link URL}.
     * @return The {@link URLConnection} for the {@link URL}.
     * @throws IOException When build the {@link URLConnection} fails.
     */
    URLConnection build(URL url) throws IOException;

}
