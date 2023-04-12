package com.github.stebeg.tool.cv.volume;

import java.io.IOException;

/**
 * An interface for retrieving volumes from the Comicvine API.
 *
 * @author Steffen Berger
 */
public interface VolumeReader {

  /**
   * Searches for volumes by name via Comicvine API.
   *
   * @param apiKey     An API key needed for retrieving information from the Comicvine API.
   * @param searchText The name of the volumes to be searched. It can also be a fragment of the name.
   * @return The search result containing the volumes.
   * @throws IOException When the communication with the Comicvine API or reading the information fails.
   */
  VolumeSearchResult searchVolumes(String apiKey, String searchText) throws IOException;

  /**
   * Searches for volumes by name via Comicvine API.
   *
   * @param apiKey     An API key needed for retrieving information from the Comicvine API.
   * @param searchText The name of the volumes to be searched. It can also be a fragment of the name.
   * @param limit      The number of results to display per page. This value defaults to 100 and can not exceed this number.
   * @param offset     Return results starting with the object at the offset specified.
   * @return The search result containing the volumes.
   * @throws IOException When the communication with the Comicvine API or reading the information fails.
   */
  VolumeSearchResult searchVolumes(String apiKey, String searchText, Integer limit, Integer offset) throws IOException;

  /**
   * Retrieves information for a volume from the Comicvine API.
   *
   * @param apiKey   An API key needed for retrieving information from the Comicvine API.
   * @param volumeId The unique ID of the volume to retrieve.
   * @return The response from the Comicvine API containing the volume.
   * @throws IOException When the communication with the Comicvine API or reading the information fails.
   */
  VolumeGetResult getVolume(String apiKey, long volumeId) throws IOException;

}
