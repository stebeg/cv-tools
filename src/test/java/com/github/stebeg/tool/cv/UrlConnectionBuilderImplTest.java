package com.github.stebeg.tool.cv;

import org.junit.jupiter.api.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Steffen Berger
 */
public class UrlConnectionBuilderImplTest {

    private final UrlConnectionBuilderImpl instance;

    public UrlConnectionBuilderImplTest() {
        this.instance = new UrlConnectionBuilderImpl();
    }

    @Test
    public void testBuild() throws IOException {
        final URL url = new URL("https://www.google.de");
        final URLConnection result = this.instance.build(url);
        assertTrue(result instanceof HttpsURLConnection);
    }
}
