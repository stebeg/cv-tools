package io.github.stebeg.comicvine.person;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import io.github.stebeg.comicvine.character.CharacterCredit;
import io.github.stebeg.comicvine.common.request.UrlContentReader;
import io.github.stebeg.comicvine.common.response.ApiListResponse;
import io.github.stebeg.comicvine.common.response.ApiResponse;
import io.github.stebeg.comicvine.common.response.StatusCode;
import io.github.stebeg.comicvine.image.Image;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonRetrieverTest {

  private final UrlContentReader urlContentReaderMock;
  private final PersonRetriever instance;

  public PersonRetrieverTest() {
    this.urlContentReaderMock = mock(UrlContentReader.class);
    this.instance = new PersonRetriever(urlContentReaderMock, new Gson());
  }

  @Test
  public void testGetPersonById() throws Exception {
    final long personId = 40439L;
    final GetPersonByIdRequest request = new GetPersonByIdRequest("12345", personId);

    final URL url = getClass().getResource("/comicvine/person/get-person-by-id-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final Person expResult = new Person(40439L, "Geoff Johns");
    expResult.setSummary("Geoff Johns is the CEO for Mad Ghost Productions at Warner Brothers. He previously wrote Action Comics, Justice Society of America, Flash, Aquaman, Teen Titans prior to focusing on movies. He is also known for his historic nine-year run on Green Lantern in which he greatly expanded the mythos. ");
    expResult.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    expResult.setAliases("Geoffrey Johns");
    expResult.setBirthDate("1973-01-25 00:00:00");
    expResult.setWebsite("http://www.geoffjohns.com");
    expResult.setGender(1);
    expResult.setHometown("Detroit, MI");
    expResult.setCountry("United States");

    expResult.setCharacterList(ImmutableList.of(
        new CharacterCredit(148828, "Aalok of the Komeriah"),
        new CharacterCredit(89639, "Aaron Cole"),
        new CharacterCredit(9351, "Alex Montez")
    ));

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setImageTags("All Images");
    expResult.setImage(image);

    final ApiResponse<Person> result = this.instance.getPersonById(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expResult.toString(), result.getResult().toString());
  }

  @Test
  public void testGetPersonById_NotFoundResponse() throws Exception {
    final long personId = 9999999L;
    final GetPersonByIdRequest request = new GetPersonByIdRequest("12345", personId);

    final URL url = getClass().getResource("/comicvine/error/not-found-error-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final ApiResponse<Person> result = this.instance.getPersonById(request);
    assertEquals(StatusCode.OBJECT_NOT_FOUND, result.getStatusCode());
    assertNull(result.getResult());
  }

  @Test
  public void testGetPeople() throws Exception {
    final String filter = "name:Geoff Johns";
    final GetPersonListRequest request = new GetPersonListRequest("12345", filter).withLimit(3);

    final URL url = getClass().getResource("/comicvine/person/get-people-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final PersonListItem personListItem = new PersonListItem(40439L, "Geoff Johns");
    personListItem.setSummary("Geoff Johns is the CEO for Mad Ghost Productions at Warner Brothers. He previously wrote Action Comics, Justice Society of America, Flash, Aquaman, Teen Titans prior to focusing on movies. He is also known for his historic nine-year run on Green Lantern in which he greatly expanded the mythos. ");
    personListItem.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    personListItem.setAliases("Geoffrey Johns");
    personListItem.setBirthDate("1973-01-25 00:00:00");
    personListItem.setWebsite("http://www.geoffjohns.com");
    personListItem.setGender(1);
    personListItem.setHometown("Detroit, MI");
    personListItem.setCountry("United States");

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/7/71975/1590165-3268449133_19b54820e0.jpg");
    image.setImageTags("All Images");
    personListItem.setImage(image);

    final int expNumberOfPageResults = 1;
    final int expNumberOfTotalResults = 1;
    final int expLimit = 3, expOffset = 0;
    final List<PersonListItem> expResult = ImmutableList.of(personListItem);

    final ApiListResponse<PersonListItem> result = this.instance.getPeople(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

  @Test
  public void testSearchPeople() throws Exception {
    final String searchText = "Geoff Johns";
    final SearchPeopleRequest request = new SearchPeopleRequest("12345", searchText).withLimit(3);

    final URL url = getClass().getResource("/comicvine/person/search-people-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final PersonListItem personListItem1 = new PersonListItem(40439L, "Geoff Johns");
    personListItem1.setSummary("Geoff Johns is the CEO for Mad Ghost Productions at Warner Brothers. He previously wrote Action Comics, Justice Society of America, Flash, Aquaman, Teen Titans prior to focusing on movies. He is also known for his historic nine-year run on Green Lantern in which he greatly expanded the mythos. ");
    personListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    personListItem1.setAliases("Geoffrey Johns");
    personListItem1.setBirthDate("1973-01-25 00:00:00");
    personListItem1.setWebsite("http://www.geoffjohns.com");
    personListItem1.setGender(1);
    personListItem1.setHometown("Detroit, MI");
    personListItem1.setCountry("United States");

    final Image personListItem1Image = new Image();
    personListItem1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/7/71975/1590165-3268449133_19b54820e0.jpg");
    personListItem1Image.setImageTags("All Images");
    personListItem1.setImage(personListItem1Image);

    final PersonListItem personListItem2 = new PersonListItem(81333, "W. Johns");
    personListItem2.setAliases(null);
    personListItem2.setCountry(null);
    personListItem2.setSummary("Editor.");
    personListItem2.setGender(1);

    final Image personListItem2Image = new Image();
    personListItem2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11122/111222211/6373148-blank.png");
    personListItem2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11122/111222211/6373148-blank.png");
    personListItem2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11122/111222211/6373148-blank.png");
    personListItem2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11122/111222211/6373148-blank.png");
    personListItem2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11122/111222211/6373148-blank.png");
    personListItem2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11122/111222211/6373148-blank.png");
    personListItem2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11122/111222211/6373148-blank.png");
    personListItem2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11122/111222211/6373148-blank.png");
    personListItem2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11122/111222211/6373148-blank.png");
    personListItem2Image.setImageTags(",All Images,asgard,Avatars,carpediem081108,Classified: Dark Syntinel,Custom Pack,dp,Heroes/Villains,Jeff Hardy,Kurama,Mack's Gallery,Mangekyou Sharingan,Mis,My Off-Topic Shizzzzzz,My Pics,Old pics,other,Other Pictures,Pics for my Background,pics of characters i found,Sorting,Spider-Man and Etc.. Gallery,SPIRALMIND,Stuff I Made on the Computer,yeah.");
    personListItem2.setImage(personListItem2Image);

    final PersonListItem personListItem3 = new PersonListItem(89971L, "Harold Johns");
    personListItem3.setGender(0);

    final Image personListItem3Image = new Image();
    personListItem3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11122/111222211/6373148-blank.png");
    personListItem3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11122/111222211/6373148-blank.png");
    personListItem3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11122/111222211/6373148-blank.png");
    personListItem3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11122/111222211/6373148-blank.png");
    personListItem3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11122/111222211/6373148-blank.png");
    personListItem3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11122/111222211/6373148-blank.png");
    personListItem3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11122/111222211/6373148-blank.png");
    personListItem3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11122/111222211/6373148-blank.png");
    personListItem3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11122/111222211/6373148-blank.png");
    personListItem3Image.setImageTags(",All Images,asgard,Avatars,carpediem081108,Classified: Dark Syntinel,Custom Pack,dp,Heroes/Villains,Jeff Hardy,Kurama,Mack's Gallery,Mangekyou Sharingan,Mis,My Off-Topic Shizzzzzz,My Pics,Old pics,other,Other Pictures,Pics for my Background,pics of characters i found,Sorting,Spider-Man and Etc.. Gallery,SPIRALMIND,Stuff I Made on the Computer,yeah.");
    personListItem3.setImage(personListItem3Image);

    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 29;
    final int expLimit = 3, expOffset = 0;
    final List<PersonListItem> expResult = ImmutableList.of(personListItem1, personListItem2, personListItem3);

    final ApiListResponse<PersonListItem> result = this.instance.searchPeople(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }
}