package com.github.stebeg.tool.cv.character;

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
import com.github.stebeg.tool.cv.person.SimplePerson;
import com.github.stebeg.tool.cv.publisher.SimplePublisher;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;

public class CharacterReaderImplTest {

  private final CharacterUrlBuilder urlBuilderMock;
  private final UrlConnectionBuilder urlConnectionBuilderMock;

  private final CharacterReader instance;

  public CharacterReaderImplTest() {
    this.urlBuilderMock = mock(CharacterUrlBuilder.class);
    this.urlConnectionBuilderMock = mock(UrlConnectionBuilder.class);

    final UrlContentReader urlContentReader = new UrlContentReaderImpl(
        this.urlConnectionBuilderMock);
    this.instance = new CharacterReaderImpl(this.urlBuilderMock, urlContentReader, new Gson());
  }

  @Test
  public void testGetCharacter() throws IOException {
    final long characterId = 11202L;
    final String apiKey = "1234567890abcdef";

    final Character expResultCharacter = new Character(characterId, "Hal Jordan");
    expResultCharacter.setRealName("Harold Jordan");
    expResultCharacter.setDescription(
        "<p>Hal Jordan is currently returning to earth after the events of Godhead and the war against the New Gods of New Genesis that was fought over the white lantern ring and the power wielded by Kyle Rayner, the Life Equation. Kyle gained power over the source code when he crossed over to the other side of the source wall. When he returned, the New Gods sensed his power and sought to take it for their own in hopes of finally defeating Darkseid and Apokolips for good. During this battle, Hal found himself making alliances with Red Lantern Guy Gardner, Sinestro, and even Black Hand who all helped him in ending the battle when they used boom tube technology to take the fight to the New God's planet of New Genesis. These events led to Hal taking some time off on Earth. After an encounter with his earth friends at a local bar on earth he had to accept than Carol Ferris has moved on in a new relationship with Kyle Rayner and he must rebuild his life.</p>");
    expResultCharacter.setSummary(
        "With the ability to overcome great fear and harness the power of will, test-pilot Hal Jordan was chosen to be the Green Lantern of Sector 2814 inheriting the ring of the dying alien Green Lantern, Abin Sur. He later on went to creating his own power ring from his own will power. Through sheer will power and determination, Hal has established an impressive record of heroism across the galaxy with the help of his fellow Green Lanterns as well as his peers in the Justice League.");
    expResultCharacter.setBirth("Feb 20, 1974");
    expResultCharacter.setGender(1);
    expResultCharacter.getCreatorList().add(new SimplePerson(1764, "Gil Kane"));
    expResultCharacter.getCreatorList().add(new SimplePerson(48152, "John Broome"));
    expResultCharacter.setOrigin(new CharacterOrigin(4, "Human"));
    expResultCharacter.setPublisher(new SimplePublisher(10, "DC Comics"));
    expResultCharacter.setImage(new Image(
        "https://comicvine1.cbsistatic.com/uploads/original/11114/111147698/6520709-1532011657748.jpg",
        "https://comicvine1.cbsistatic.com/uploads/scale_avatar/11114/111147698/6520709-1532011657748.jpg"));
    final CharacterGetResult expResult = new CharacterGetResult(1, expResultCharacter);

    final URL url = getClass().getResource("/character/character-get-example.json");
    when(this.urlBuilderMock.buildCharacterGetUrl(eq(characterId), anyMap())).thenReturn(url);

    final URLConnection urlConnection = url.openConnection();
    when(this.urlConnectionBuilderMock.build(url)).thenReturn(urlConnection);

    final CharacterGetResult result = this.instance.getCharacter(apiKey, characterId);
    assertEquals(expResult.getStatusCode(), result.getStatusCode());
    assertNotNull(result.getResult());

    final Character character = result.getResult();
    assertEquals(expResultCharacter.getId(), character.getId());
    assertEquals(expResultCharacter.getName(), character.getName());
    assertEquals(expResultCharacter.getRealName(), character.getRealName());
    assertEquals(expResultCharacter.getDescription(), character.getDescription());
    assertEquals(expResultCharacter.getSummary(), character.getSummary());
    assertEquals(expResultCharacter.getBirth(), character.getBirth());
    assertEquals(expResultCharacter.getGender(), character.getGender());

    int expCreatorListSize = 2;
    assertEquals(expCreatorListSize, character.getCreatorList().size());
    assertEquals(
        expResultCharacter.getCreatorList().get(0).getId(),
        character.getCreatorList().get(0).getId());
    assertEquals(
        expResultCharacter.getCreatorList().get(1).getName(),
        character.getCreatorList().get(1).getName());

    assertEquals(expResultCharacter.getOrigin().getId(), character.getOrigin().getId());
    assertEquals(expResultCharacter.getOrigin().getName(), character.getOrigin().getName());

    assertEquals(expResultCharacter.getPublisher().getId(), character.getPublisher().getId());
    assertEquals(expResultCharacter.getPublisher().getName(), character.getPublisher().getName());

    assertEquals(expResultCharacter.getImage().getOriginalUrl(),
        character.getImage().getOriginalUrl());
    assertEquals(expResultCharacter.getImage().getThumbUrl(), character.getImage().getThumbUrl());
  }
}