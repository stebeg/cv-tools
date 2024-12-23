package com.github.stebeg.comicvine.common.request;

import com.google.common.base.Preconditions;
import com.google.common.net.HttpHeaders;
import org.apache.http.HttpStatus;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * A factory for building {@link URLConnection}s.
 */
public class UrlConnectionBuilder {

  private static final String MEDIA_TYPE = "application/json; charset=utf-8";

  /**
   * Creates a new instance of the factory for building {@link URLConnection}s.
   */
  public UrlConnectionBuilder() {
  }

  /**
   * Builds a new {@link URLConnection} for the given {@link URL} and sets the request method to {@code GET} and the
   * content type to {@code application/json; charset=utf-8}.
   *
   * @param url The {@link URL} for which a new {@link URLConnection} should be built.
   * @return The new {@link URLConnection}.
   * @throws IOException If the {@link URLConnection} could not be built.
   * @throws IllegalStateException If the response code of the {@link URLConnection} is not {@link HttpStatus#SC_OK}.
   */
  public URLConnection build(final URL url) throws IOException {
    Preconditions.checkNotNull(url);

    final HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
    httpsURLConnection.setRequestMethod("GET");
    httpsURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
    httpsURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, MEDIA_TYPE);
    httpsURLConnection.connect();

    final int responseCode = httpsURLConnection.getResponseCode();
    Preconditions.checkState(responseCode == HttpStatus.SC_OK,
        "Response code for %s was %s", url.toString(), responseCode);

    return httpsURLConnection;
  }
}
