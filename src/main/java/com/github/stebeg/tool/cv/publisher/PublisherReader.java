package com.github.stebeg.tool.cv.publisher;

import java.io.IOException;

/**
 * An interface for retrieving publishers from the Comicvine API.
 *
 * @author Steffen Berger
 */
public interface PublisherReader {

  /**
   * Retrieves information for a publisher from the Comicvine API.
   *
   * @param apiKey      An API key needed for retrieving information from the Comicvine API.
   * @param publisherId The unique ID of the publisher to retrieve.
   * @return The response from the Comicvine API containing the publisher.
   * @throws IOException When the communication with the Comicvine API or reading the information
   *                     fails.
   */
  PublisherGetResult getPublisher(String apiKey, long publisherId) throws IOException;
}
