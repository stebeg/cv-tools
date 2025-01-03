package io.github.stebeg.comicvine.common;

import com.google.common.base.Strings;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.stebeg.comicvine.common.request.AbstractApiRequest;
import io.github.stebeg.comicvine.common.request.UrlContentReader;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * An abstract implementation for retrieving entities from the Comicvine API.
 */
public abstract class AbstractComicvineEntityRetriever {

  private final UrlContentReader urlContentReader;

  /**
   * Creates a new instance for retrieving entities from the Comicvine API.
   *
   * @param urlContentReader Reads the response from the Comicvine API.
   */
  protected AbstractComicvineEntityRetriever(UrlContentReader urlContentReader) {
    this.urlContentReader = urlContentReader;
  }

  /**
   * Retrieves a JSON object from the Comicvine API.
   *
   * @param request The request to retrieve the JSON object.
   * @return The JSON object retrieved from the Comicvine API.
   * @throws IOException If an I/O error occurs.
   */
  protected JsonObject getJsonObject(final AbstractApiRequest request) throws IOException {
    final URL url = request.toUrl();
    final String jsonContent = this.urlContentReader.getJson(url);
    if (Strings.isNullOrEmpty(jsonContent) || Objects.equals(jsonContent, "[]")) {
      return null;
    }
    final JsonElement jsonElement = JsonParser.parseString(jsonContent);
    return jsonElement.getAsJsonObject();
  }

}
