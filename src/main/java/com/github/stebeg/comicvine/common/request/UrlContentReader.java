package com.github.stebeg.comicvine.common.request;

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
public class UrlContentReader {

  private final UrlConnectionBuilder urlConnectionBuilder;

  /**
   * Creates a new instance of the implementation for retrieving json content from an {@link URL}.
   *
   * @param urlConnectionBuilder An implementation of {@link UrlConnectionBuilder} is needed to build a connection for
   *                             the given {@link URL}.
   */
  public UrlContentReader(UrlConnectionBuilder urlConnectionBuilder) {
    this.urlConnectionBuilder = urlConnectionBuilder;
  }

  /**
   * Retrieves the content from the given {@link URL} as a json string.
   *
   * @param url The {@link URL} from which the content should be retrieved.
   * @return The content from the given {@link URL} as a json string.
   * @throws IOException If an I/O error occurs.
   */
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
