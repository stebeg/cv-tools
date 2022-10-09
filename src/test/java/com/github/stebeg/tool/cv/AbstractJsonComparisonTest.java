package com.github.stebeg.tool.cv;

import com.github.stebeg.tool.cv.common.AbstractApiGetResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.junit.jupiter.api.Assertions;

public class AbstractJsonComparisonTest {

  private final Gson gson;

  public AbstractJsonComparisonTest() {
    this.gson = new GsonBuilder().setPrettyPrinting().create();
  }

  protected void assertJsonEquals(
      final String expResultFilePath,
      final AbstractApiGetResult result) throws Exception {

    final URL expResultFileUrl = getClass().getResource(expResultFilePath);
    final byte[] expResultFileBytes = Files.readAllBytes(new File(expResultFileUrl.toURI()).toPath());
    final String expResultJson = new String(expResultFileBytes, StandardCharsets.UTF_8).replace("\r\n", "\n");

    final String resultJson = this.gson.toJson(result);
    Assertions.assertEquals(expResultJson, resultJson);
  }

}
