package com.github.stebeg.tool.cv.common;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.junit.jupiter.api.Test;

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
