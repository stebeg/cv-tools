package com.github.stebeg.comicvine.common.request;

import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * An abstract implementation of an API request.
 */
public abstract class AbstractApiRequest {

  private final Map<String, String> parameter = new HashMap<>();

  /**
   * Creates a new instance of the abstract API request.
   *
   * @param apiKey The API key to be used for the request.
   */
  public AbstractApiRequest(String apiKey) {
    this.parameter.put(RequestAttribute.API_KEY, apiKey);
    getParameter().put(RequestAttribute.FORMAT_PARAMETER_NAME, RequestAttribute.JSON_FORMAT_PARAMETER_VALUE);
    getParameter().put(RequestAttribute.CLIENT, RequestAttribute.CLIENT_VALUE);
  }

  /**
   * Returns the parameters of the request as a map. The keys in the map are the parameter names and
   * the values are the parameter values.
   *
   * @return The parameters of the request.
   */
  public Map<String, String> getParameter() {
    return this.parameter;
  }

  /**
   * Returns the URL fragment for the request.
   *
   * @return The URL fragment.
   */
  protected abstract String getRequestUrlFragment();

  /**
   * Converts the request to a URL.
   *
   * @return The URL representation of the request.
   * @throws IOException If the URL could not be created.
   */
  public URL toUrl() throws IOException {
    try {
      final URIBuilder uriBuilder = new URIBuilder(RequestAttribute.API_BASE_URL.concat(getRequestUrlFragment()));
      for (final String parameterName : parameter.keySet()) {
        uriBuilder.addParameter(parameterName, parameter.get(parameterName));
      }
      return uriBuilder.build().toURL();
    } catch (final URISyntaxException uriSyntaxException) {
      throw new IOException(uriSyntaxException);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @param object {@inheritDoc}
   * @return {@inheritDoc}
   */
  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    final AbstractApiRequest that = (AbstractApiRequest) object;
    return Objects.equals(this.parameter, that.parameter);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.parameter);
  }
}
