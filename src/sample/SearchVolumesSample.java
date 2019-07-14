package com.github.stebeg.tool.cv.sample;

import com.github.stebeg.tool.cv.ComicvineToolsProvider;
import com.github.stebeg.tool.cv.Volume;
import com.github.stebeg.tool.cv.VolumeReader;
import com.github.stebeg.tool.cv.VolumeSearchResult;
import java.io.IOException;

/**
 * Sample code for searching volumes.
 *
 * @author Steffen Berger
 */
public class SearchVolumesSample {

    public static final void main() throws IOException {
        final String apiKey = "abcdef12345";
        final String searchText = "Green Lantern";

        final VolumeReader volumeReader = ComicvineToolsProvider.getVolumeReader();
        final VolumeSearchResult result = volumeReader.searchVolumes(apiKey, searchText);

        for (final Volume volume : result.getVolumes()) {
            System.out.println("volume name = " + volume.getName());
        }
    }

}
