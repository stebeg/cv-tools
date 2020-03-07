package com.github.stebeg.tool.cv;

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
     * @param searchText The name of the volumes to be search. It can also be a fragment of the name.
     * @return The search result containing the volumes.
     * @throws IOException When the communication with the Comicvine API or reading the information
     *                     fails.
     */
    VolumeSearchResult searchVolumes(String apiKey, String searchText) throws IOException;

    /**
     * Retrieves information for a volume from the Comicvine API.
     *
     * @param apiKey   An API key needed for retrieving information from the Comicvine API.
     * @param volumeId The unique ID of the volume to retrieve.
     * @return The response from the Comicvine API containing the volume.
     * @throws IOException When the communication with the Comicvine API or reading the information
     *                     fails.
     */
    VolumeGetResult getVolume(String apiKey, long volumeId) throws IOException;

}
