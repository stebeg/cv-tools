package com.github.stebeg.tool.cv.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.stebeg.tool.cv.common.UrlConnectionBuilder;
import com.github.stebeg.tool.cv.common.UrlContentReader;
import com.github.stebeg.tool.cv.common.UrlContentReaderImpl;
import com.github.stebeg.tool.cv.image.Image;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;

public class PersonReaderImplTest {

  private final PersonUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final PersonReader instance;

  public PersonReaderImplTest() {
    this.urlBuilderMock = mock(PersonUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new PersonReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetPerson() throws IOException {
    final long personId = 40439L;
    final String apiKey = "1234567890abcdef";

    final Person expResultPerson = new Person(personId, "Geoff Johns");
    expResultPerson.setDescription(
        "<p>Geoff Johns hails from <a href=\"/detroit/4020-55783/\" data-ref-id=\"4020-55783\">"
            + "Detroit, Michigan</a>, and is a graduate of Michigan State University where he "
            + "studied writing for film and television. Afterwards, he moved to Los Angeles and "
            + "became an assistant to Richard Donner, well known as the director of Superman: The "
            + "Movie. Johns would eventually make his mark writing comics starting with a brief "
            + "stint on Marvel's Avengers before moving on to <a href=\"/dc-comics/4010-10/\" "
            + "data-ref-id=\"4010-10\">DC</a> to create the title "
            + "<a href=\"/stars-and-stripe/4050-6800/\" data-ref-id=\"4050-6800\">Stars and "
            + "S.T.R.I.P.E</a>. In that title Geoff created the character of "
            + "<a href=\"/stargirl/4005-4897/\" data-ref-id=\"4005-4897\">Courtney Whitmore</a>, "
            + "who is currently called Stargirl. This character is based on his own sister, "
            + "Courtney, who was among the casualties of TWA flight 800 which was lost in 1996."
            + "</p>");
    expResultPerson.setSummary(
        "Geoff Johns is the Chief Creative Officer for DC Comics. He is currently writing Justice "
            + "League and Batman: Earth One vol 2. He previously wrote Action Comics, Justice "
            + "Society of America, Flash, Aquaman, Teen Titans, and. He is also known for his "
            + "historic nine-year run on Green Lantern in which he greatly expanded the mythos. He "
            + "is one of the most well known comic writers currently.");

    expResultPerson.setBirth("1973-01-25 00:00:00");
    expResultPerson.setDeath(null);

    expResultPerson.setGender(1);
    expResultPerson.setImage(new Image(
        "https://comicvine1.cbsistatic.com/uploads/original/6/67663/6467101-6275694476-21366.jpg",
        "https://comicvine1.cbsistatic.com/uploads/scale_avatar/6/67663/6467101-6275694476-21366.jpg"));

    expResultPerson.setCountry("United States");
    expResultPerson.setHometown("Detroit, MI");
    expResultPerson.setWebsite("http://www.geoffjohns.com");

    final PersonGetResult expResult = new PersonGetResult(1, expResultPerson);

    final URL url = getClass().getResource("/person/person-get-example.json");
    when(this.urlBuilderMock.buildPersonGetUrl(eq(personId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final PersonGetResult result = this.instance.getPerson(apiKey, personId);
    assertEquals(expResult, result);
  }
}