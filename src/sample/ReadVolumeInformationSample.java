package com.github.stebeg.tool.cv.sample;

import com.github.stebeg.tool.cv.ComicvineToolsProvider;
import com.github.stebeg.tool.cv.Volume;
import com.github.stebeg.tool.cv.VolumeGetResult;
import com.github.stebeg.tool.cv.VolumeReader;
import java.io.IOException;

/**
 * Sample code for retrieving volume information.
 *
 * @author Steffen Berger
 */
public class ReadVolumeInformationSample {

    public static final void main() throws IOException {
        final String apiKey = "abcdef12345";
        final long volumeId = 2839L;

        final VolumeReader volumeReader = ComicvineToolsProvider.getVolumeReader();
        final VolumeGetResult result = volumeReader.getVolume(apiKey, volumeId);

        final Volume volume = result.getVolume();
        System.out.println("volume name = " + volume.getName());
    }

}
