package com.github.stebeg.tool.cv.publisher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

public class PublisherReaderImplTest {

  private final PublisherUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final PublisherReader instance;

  public PublisherReaderImplTest() {
    this.urlBuilderMock = mock(PublisherUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new PublisherReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetPublisher() throws IOException {
    final long publisherId = 10L;
    final String apiKey = "1234567890abcdef";

    final Publisher expResultPublisher = new Publisher(publisherId, "DC Comics");
    expResultPublisher.setDescription(
        "<h2>Current Personnel</h2><ul><li><a href=\"/diane-nelson/4040-60224/\" data-ref-id=\"4040-60224\">Diane Nelson</a>: President</li><li><a href=\"/jim-lee/4040-2399/\" data-ref-id=\"4040-2399\">Jim Lee</a> &amp; <a href=\"/dan-didio/4040-51584/\" data-ref-id=\"4040-51584\">Dan Didio</a>: Co-Publishers</li><li><a href=\"/bob-harras/4040-40985/\" data-ref-id=\"4040-40985\">Bob Harras</a>: Editor-In-Chief</li><li><a href=\"/geoff-johns/4040-40439/\" data-ref-id=\"4040-40439\">Geoff Johns</a>: Chief Creative Officer</li><li><a href=\"/john-rood/4040-71914/\" data-ref-id=\"4040-71914\">John Rood</a>: Executive Vice President, Sales, Marketing and Business Development</li></ul>");
    expResultPublisher.setSummary(
        "Originally known as \"National Publications\", DC is a publisher of comic books featuring iconic characters and teams such as Superman, Batman, Wonder Woman, Green Lantern, the Justice League of America, and the Teen Titans, and is considered the originator of the American superhero genre. DC, along with rival Marvel Comics, is one of the \"big two\" American comic book publishers. DC Entertainment is a subsidiary of Warner Brothers and its parent company Time Warner.");
    expResultPublisher.setImage(new Image(
        "https://comicvine1.cbsistatic.com/uploads/original/0/40/5213245-dc_logo_blue_final.jpg",
        "https://comicvine1.cbsistatic.com/uploads/scale_avatar/0/40/5213245-dc_logo_blue_final.jpg"));
    expResultPublisher.setCity("Burbank");
    expResultPublisher.setState("California");

    final PublisherGetResult expResult = new PublisherGetResult(1, expResultPublisher);

    final URL url = getClass().getResource("/publisher/publisher-get-example.json");
    when(this.urlBuilderMock.buildPublisherGetUrl(eq(publisherId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final PublisherGetResult result = this.instance.getPublisher(apiKey, publisherId);
    assertEquals(expResult.getStatusCode(), result.getStatusCode());
    assertNotNull(result.getResult());

    final Publisher publisher = result.getResult();
    assertEquals(expResultPublisher.getId(), publisher.getId());
    assertEquals(expResultPublisher.getName(), publisher.getName());
    assertEquals(expResultPublisher.getDescription(), publisher.getDescription());
    assertEquals(expResultPublisher.getSummary(), publisher.getSummary());

    assertEquals(
        expResultPublisher.getImage().getOriginalUrl(),
        publisher.getImage().getOriginalUrl());
    assertEquals(expResultPublisher.getImage().getThumbUrl(), publisher.getImage().getThumbUrl());

    assertEquals(expResultPublisher.getCity(), publisher.getCity());
    assertEquals(expResultPublisher.getState(), publisher.getState());
  }
}