package com.github.stebeg.tool.cv.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stebeg.tool.cv.Constants;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PersonUrlBuilderImplTest {

  private final PersonUrlBuilder instance;

  public PersonUrlBuilderImplTest() {
    this.instance = new PersonUrlBuilderImpl();
  }

  @Test
  public void testBuildPersonGetUrl() throws IOException {
    final long personId = 1234L;
    final String paramName = "foo", paramValue = "bar";
    final Map<String, String> parameter = ImmutableMap.of(paramName, paramValue);
    final String expPath = Constants.API_BASE_URL
        .concat(PersonUrlBuilderImpl.API_PERSON_URL_FRAGMENT)
        .concat("4040-").concat(String.valueOf(personId)).concat("/")
        .concat("?").concat(Constants.CLIENT_PARAMETER_NAME)
        .concat("=").concat(Constants.CLIENT_PARAMETER_VALUE)
        .concat("&").concat(paramName).concat("=").concat(paramValue);

    final URL result = this.instance.buildPersonGetUrl(personId, parameter);
    assertEquals(expPath, result.toString());
  }
}