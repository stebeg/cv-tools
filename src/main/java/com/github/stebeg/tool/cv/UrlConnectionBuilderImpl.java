package com.github.stebeg.tool.cv;

import com.google.common.base.Preconditions;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpStatus;

/**
 * An implementation for building {@link URLConnection}s.
 *
 * @author Steffen Berger
 */
class UrlConnectionBuilderImpl implements UrlConnectionBuilder {

    private static final String MEDIA_TYPE = "application/json; charset=utf-8";

    /**
     * Creates a new instance of the implementation for building {@link URLConnection}s.
     */
    UrlConnectionBuilderImpl() {
    }

    /**
     * {@inheritDoc} The request method of the created {@link URLConnection} is set to {@code GET}.
     *
     * @param url {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IOException {@inheritDoc}
     */
    @Override
    public URLConnection build(final URL url) throws IOException {
        Preconditions.checkNotNull(url);

        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpsURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, MEDIA_TYPE);
        httpsURLConnection.connect();

        final int responseCode = httpsURLConnection.getResponseCode();
        Preconditions.checkState(responseCode == HttpStatus.SC_OK);

        return httpsURLConnection;
    }
}
