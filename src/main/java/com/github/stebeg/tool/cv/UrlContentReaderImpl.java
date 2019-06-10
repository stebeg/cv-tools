package com.github.stebeg.tool.cv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * An implementation for retrieving content from an {@link URL}.
 * 
 * @author Steffen Berger
 */
class UrlContentReaderImpl implements UrlContentReader {

    private final UrlConnectionBuilder urlConnectionBuilder;

    /**
     * Creates a new instance of the implementation for retrieving content from
     * an {@link URL}.
     *
     * @param urlConnectionBuilder An implementation of
     * {@link UrlConnectionBuilder} is needed to build a connection for the
     * given {@link URL}.
     */
    UrlContentReaderImpl(UrlConnectionBuilder urlConnectionBuilder) {
        this.urlConnectionBuilder = urlConnectionBuilder;
    }

    /**
     * {@inheritDoc}
     *
     * @param url {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IOException {@inheritDoc}
     */
    @Override
    public String getJson(final URL url) throws IOException {
        final URLConnection urlConnection = this.urlConnectionBuilder.build(url);
        final String jsonContent;
        try (final InputStream inputStream = urlConnection.getInputStream();
                final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            final StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            jsonContent = response.toString();
        }
        return jsonContent;
    }
}
