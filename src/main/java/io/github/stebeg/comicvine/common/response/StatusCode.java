package io.github.stebeg.comicvine.common.response;

/**
 * Represents the status codes of the Comicvine API.
 */
public enum StatusCode {

  /**
   * OK
   */
  OKAY(1),
  /**
   * Invalid API Key
   */
  INVALID_API_KEY(100),
  /**
   * Object Not Found
   */
  OBJECT_NOT_FOUND(101),
  /**
   * Error in URL Format
   */
  ERROR_IN_URL_FORMAT(102),
  /**
   * JSONP requires a 'json_callback' argument
   */
  JSONP_REQUIRES_JSON_CALLBACK_ARGUMENT(103),
  /**
   * Filter Error
   */
  FILTER_ERROR(104);

  private final int code;

  /**
   * Creates a new status code enum value.
   *
   * @param code The status code.
   */
  StatusCode(int code) {
    this.code = code;
  }

  /**
   * Returns the status code enum value for the given status code.
   *
   * @param statusCode The status code.
   * @return The status code enum value.
   */
  public static StatusCode forCode(final int statusCode) {
    for (final StatusCode status : StatusCode.values()) {
      if (status.getCode() == statusCode) {
        return status;
      }
    }
    return null;
  }

  /**
   * Returns the status code for this enum value.
   *
   * @return The status code.
   */
  public int getCode() {
    return this.code;
  }
}
