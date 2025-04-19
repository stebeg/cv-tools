package io.github.stebeg.comicvine.character;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import io.github.stebeg.comicvine.common.request.UrlContentReader;
import io.github.stebeg.comicvine.common.response.ApiListResponse;
import io.github.stebeg.comicvine.common.response.ApiResponse;
import io.github.stebeg.comicvine.common.response.StatusCode;
import io.github.stebeg.comicvine.image.Image;
import io.github.stebeg.comicvine.person.PersonCredit;
import io.github.stebeg.comicvine.publisher.PublisherCredit;
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

public class CharacterRetrieverTest {

  private final UrlContentReader urlContentReaderMock;
  private final CharacterRetriever instance;

  public CharacterRetrieverTest() {
    this.urlContentReaderMock = mock(UrlContentReader.class);
    this.instance = new CharacterRetriever(urlContentReaderMock, new Gson());
  }

  @Test
  public void testGetCharacterById() throws Exception {
    final long characterId = 11202L;
    final GetCharacterByIdRequest request = new GetCharacterByIdRequest("12345", characterId);

    final URL url = getClass().getResource("/comicvine/character/get-character-by-id-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final Character expResult = new Character(characterId, "Hal Jordan");
    expResult.setRealName("Harold Jordan");
    expResult.setSummary("With the ability to overcome great fear and harness the power of will, test-pilot Hal Jordan was chosen to be the Green Lantern of Sector 2814.");
    expResult.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>");
    expResult.setAliases("Harold Jordan\nGreen Lantern\nParallax\nSpectre");
    expResult.setPublisher(new PublisherCredit(10, "DC Comics"));
    expResult.setOrigin(new CharacterOrigin(4, "Human"));
    expResult.setGender(1);
    expResult.setBirth("Feb 20, 1974");

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/12/124259/9439462-green-lantern-16-main-cover-675x1024.jpg");
    image.setImageTags("All Images");
    expResult.setImage(image);

    final PersonCredit personCredit1 = new PersonCredit(1764, "Gil Kane");
    final PersonCredit personCredit2 = new PersonCredit(48152, "John Broome");
    expResult.setCreatorList(ImmutableList.of(personCredit1, personCredit2));

    final ApiResponse<Character> result = this.instance.getCharacterById(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expResult.toString(), result.getResult().toString());
  }

  @Test
  public void testGetCharacterById_NotFoundResponse() throws Exception {
    final long characterId = 9999999L;
    final GetCharacterByIdRequest request = new GetCharacterByIdRequest("12345", characterId);

    final URL url = getClass().getResource("/comicvine/error/not-found-error-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final ApiResponse<Character> result = this.instance.getCharacterById(request);
    assertEquals(StatusCode.OBJECT_NOT_FOUND, result.getStatusCode());
    assertNull(result.getResult());
  }

  @Test
  public void testGetCharacters() throws Exception {
    final String filter = "name:Green Lantern";
    final GetCharacterListRequest request = new GetCharacterListRequest("12345", filter).withLimit(3);

    final URL url = getClass().getResource("/comicvine/character/get-characters-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final CharacterListItem characterListItem1 = new CharacterListItem(45112, "Green Lantern (Tangent)");
    characterListItem1.setAliases("Goddess of the Dead\nLady of the Lantern\nLois Lane\nZatanna\nGreen Lantern");
    characterListItem1.setSummary("Green Lantern is a woman who carries a lantern that can resurrect someone until they finish their unfinished business, if she places it on their grave.");
    characterListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.</p>");
    characterListItem1.setGender(2);
    characterListItem1.setPublisher(new PublisherCredit(10, "DC Comics"));
    characterListItem1.setOrigin(new CharacterOrigin(7, "God/Eternal"));

    final Image character1Image = new Image();
    character1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setImageTags("All Images,Green Lantern");
    characterListItem1.setImage(character1Image);

    final CharacterListItem characterListItem2 = new CharacterListItem(50779, "Green Lantern of Sector 555");
    characterListItem2.setSummary("Honored Fallen Lantern of Space Sector 555");
    characterListItem2.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.</p>");
    characterListItem2.setGender(1);
    characterListItem2.setPublisher(new PublisherCredit(10, "DC Comics"));
    characterListItem2.setOrigin(new CharacterOrigin(3, "Alien"));

    final Image character2Image = new Image();
    character2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/1/13181/296364-2083-green-lantern-of-sec.jpg");
    character2Image.setImageTags("All Images,Green Lantern of Sector 555");
    characterListItem2.setImage(character2Image);

    final CharacterListItem characterListItem3 = new CharacterListItem(51000, "Green Lantern of Xanador");
    characterListItem3.setSummary("Honored Fallen Lantern of Space Sector 1416.");
    characterListItem3.setDescription("<p>Green Lantern</p><p>Status: Deceased</p>");
    characterListItem3.setGender(1);
    characterListItem3.setPublisher(new PublisherCredit(10, "DC Comics"));
    characterListItem3.setOrigin(new CharacterOrigin(3, "Alien"));

    final Image character3Image = new Image();
    character3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/1/13181/302927-149165-green-lantern-of-xan.jpg");
    character3Image.setImageTags("All Images,Green Lantern of Xanador");
    characterListItem3.setImage(character3Image);

    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 38;
    final int expLimit = 3, expOffset = 0;
    final List<CharacterListItem> expResult = ImmutableList.of(characterListItem1, characterListItem2, characterListItem3);

    final ApiListResponse<CharacterListItem> result = this.instance.getCharacters(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

  @Test
  public void testSearchCharacters() throws Exception {
    final String searchText = "Green Lantern";
    final SearchCharactersRequest request = new SearchCharactersRequest("12345", searchText).withLimit(3);

    final URL url = getClass().getResource("/comicvine/character/search-characters-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final CharacterListItem characterListItem1 = new CharacterListItem(45112, "Green Lantern (Tangent)");
    characterListItem1.setAliases("Goddess of the Dead\nLady of the Lantern\nLois Lane\nZatanna\nGreen Lantern");
    characterListItem1.setSummary("Green Lantern is a woman who carries a lantern that can resurrect someone until they finish their unfinished business, if she places it on their grave.");
    characterListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.</p>");
    characterListItem1.setGender(2);
    characterListItem1.setPublisher(new PublisherCredit(10, "DC Comics"));
    characterListItem1.setOrigin(new CharacterOrigin(7, "God/Eternal"));

    final Image character1Image = new Image();
    character1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/2/25835/753969-greenlantern__earth_9_.jpg");
    character1Image.setImageTags("All Images,Green Lantern");
    characterListItem1.setImage(character1Image);

    final CharacterListItem characterListItem2 = new CharacterListItem(86357, "Green Lantern of the Milky Way");
    characterListItem2.setAliases("Green Lantern \nHal Jordan III");
    characterListItem2.setRealName("Hal Jordan III");
    characterListItem2.setSummary("The grandson of Hal Jordan.");
    characterListItem2.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.</p>");
    characterListItem2.setGender(1);
    characterListItem2.setPublisher(new PublisherCredit(10, "DC Comics"));
    characterListItem2.setOrigin(new CharacterOrigin(4, "Human"));

    final Image character2Image = new Image();
    character2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/13/139809/2685232-hal_jordan__earth_12_.jpg");
    character2Image.setImageTags("All Images");
    characterListItem2.setImage(character2Image);

    final CharacterListItem characterListItem3 = new CharacterListItem(64457, "Green Lantern: Circa 2029");
    characterListItem3.setAliases("Green Lantern\nLantern");
    characterListItem3.setSummary("The Green Lantern of year 2029 is an enormous whale who comes to the aid of an aged Animal Man during a flash forward to the heroes \"last days\". It is unknown if this Lantern was the appointed Green Lantern of Sector 2814, or was operating outside of his assigned Space Sector.");
    characterListItem3.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>");
    characterListItem3.setGender(1);
    characterListItem3.setPublisher(new PublisherCredit(10, "DC Comics"));
    characterListItem3.setOrigin(new CharacterOrigin(8, "Animal"));

    final Image character3Image = new Image();
    character3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/1/13181/903373-untitled.jpg");
    character3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/1/13181/903373-untitled.jpg");
    character3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/1/13181/903373-untitled.jpg");
    character3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/1/13181/903373-untitled.jpg");
    character3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/1/13181/903373-untitled.jpg");
    character3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/1/13181/903373-untitled.jpg");
    character3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/1/13181/903373-untitled.jpg");
    character3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/1/13181/903373-untitled.jpg");
    character3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/1/13181/903373-untitled.jpg");
    character3Image.setImageTags("All Images,Green Lantern");
    characterListItem3.setImage(character3Image);

    final List<CharacterListItem> expResult = ImmutableList.of(characterListItem1, characterListItem2, characterListItem3);
    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 390;
    final int expLimit = 3, expOffset = 0;

    final ApiListResponse<CharacterListItem> result = this.instance.searchCharacters(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }
}