package io.github.stebeg.comicvine.team;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import io.github.stebeg.comicvine.character.CharacterCredit;
import io.github.stebeg.comicvine.common.request.UrlContentReader;
import io.github.stebeg.comicvine.common.response.ApiListResponse;
import io.github.stebeg.comicvine.common.response.ApiResponse;
import io.github.stebeg.comicvine.common.response.StatusCode;
import io.github.stebeg.comicvine.image.Image;
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

public class TeamRetrieverTest {

  private final UrlContentReader urlContentReaderMock;
  private final TeamRetriever instance;

  public TeamRetrieverTest() {
    this.urlContentReaderMock = mock(UrlContentReader.class);
    this.instance = new TeamRetriever(urlContentReaderMock, new Gson());
  }

  @Test
  public void testGetTeamById() throws Exception {
    final long teamId = 31815;
    final GetTeamByIdRequest request = new GetTeamByIdRequest("12345", teamId);

    final URL url = getClass().getResource("/comicvine/team/get-team-by-id-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final Team expResult = new Team(teamId, "Justice League of America");
    expResult.setAliases("JLA");
    expResult.setSummary("The Justice League (also known as the Justice League of America or the JLA) is a team comprised of the premier heroes of the DC Universe.");
    expResult.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");

    expResult.setPublisher(new PublisherCredit(10, "DC Comics"));
    expResult.setMemberList(ImmutableList.of(
        new CharacterCredit(1807, "Superman"),
        new CharacterCredit(23879, "Wally West"),
        new CharacterCredit(2048, "Wonder Woman")));

    final Image image = new Image();
    image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11142/111427220/8339053-johnjla.jpeg");
    image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11142/111427220/8339053-johnjla.jpeg");
    image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11142/111427220/8339053-johnjla.jpeg");
    image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11142/111427220/8339053-johnjla.jpeg");
    image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11142/111427220/8339053-johnjla.jpeg");
    image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11142/111427220/8339053-johnjla.jpeg");
    image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11142/111427220/8339053-johnjla.jpeg");
    image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11142/111427220/8339053-johnjla.jpeg");
    image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11142/111427220/8339053-johnjla.jpeg");
    image.setImageTags("All Images,Earth 0,rebirth,Superman");
    expResult.setImage(image);

    final ApiResponse<Team> result = this.instance.getTeamById(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expResult.toString(), result.getResult().toString());
  }

  @Test
  public void testGetTeamById_NotFoundResponse() throws Exception {
    final long teamId = 9999999L;
    final GetTeamByIdRequest request = new GetTeamByIdRequest("12345", teamId);

    final URL url = getClass().getResource("/comicvine/error/not-found-error-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final ApiResponse<Team> result = this.instance.getTeamById(request);
    assertEquals(StatusCode.OBJECT_NOT_FOUND, result.getStatusCode());
    assertNull(result.getResult());
  }

  @Test
  public void testGetTeams() throws Exception {
    final String filter = "name:Justice League";
    final GetTeamListRequest request = new GetTeamListRequest("12345", filter).withLimit(3);

    final URL url = getClass().getResource("/comicvine/team/get-teams-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final TeamListItem teamListItem1 = new TeamListItem(22672, "Injustice League");
    teamListItem1.setSummary("The Injustice League assembled to oppose the JLA, having taken various forms that consist of major villains like Joker, Lex Luthor and Cheetah.");
    teamListItem1.setDescription("<h2>Information</h2><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    teamListItem1.setPublisher(new PublisherCredit(10, "DC Comics"));

    final Image team1Image = new Image();
    team1Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/3/31666/3236888-forever_evil_2_nu6utwlniu_.jpg");
    team1Image.setImageTags("All Images,Artwork,Comics,DCnU,Injustice League,Modern Age II (2001 - present),New 52,Parallax");
    teamListItem1.setImage(team1Image);

    final TeamListItem teamListItem2 = new TeamListItem(25003, "Justice League Task Force");
    teamListItem2.setSummary("Initially formed as a special missions task force working with the UN, the JLTF eventually became the Justice League training team for younger heroes under the sometimes strict but watchful eye of J'onn J'onzz.");
    teamListItem2.setDescription("<h2>Origin</h2><p>Initially formed as a special missions task force working with the UN, the JLTF eventually became the Justice League training team for younger heroes under the sometimes strict but watchful eye of J'onn J'onzz.</p>");
    teamListItem2.setPublisher(new PublisherCredit(10, "DC Comics"));

    final Image team2Image = new Image();
    team2Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/0/1494/95535-23579-justice-league-task.jpg");
    team2Image.setImageTags("All Images");
    teamListItem2.setImage(team2Image);

    final TeamListItem teamListItem3 = new TeamListItem(26208, "Justice League International");
    teamListItem3.setAliases("JLI");
    teamListItem3.setSummary("Sanctioned by the United Nations, the Justice League International is designed to be a publicly accountable answer to the Justice League.");
    teamListItem3.setDescription("<p>Sanctioned by the United Nations, the Justice League International is designed to be a publicly accountable answer to the Justice League.</p>");
    teamListItem3.setPublisher(new PublisherCredit(10, "DC Comics"));

    final Image team3Image = new Image();
    team3Image.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11138/111381541/8728974-fbhcipyuuaebrwb.jpg");
    team3Image.setImageTags("All Images");
    teamListItem3.setImage(team3Image);

    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 28;
    final int expLimit = 3, expOffset = 0;
    final List<TeamListItem> expResult = ImmutableList.of(teamListItem1, teamListItem2, teamListItem3);

    final ApiListResponse<TeamListItem> result = this.instance.getTeams(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }

  @Test
  public void testSearchTeams() throws Exception {
    final String searchText = "Justice";
    final SearchTeamsRequest request = new SearchTeamsRequest("12345", searchText).withLimit(3);

    final URL url = getClass().getResource("/comicvine/team/search-teams-response.json");
    assertNotNull(url);

    final File jsonResultFile = new File(url.getFile());
    final byte[] bytes = Files.readAllBytes(jsonResultFile.toPath());
    final String jsonContent = new String(bytes);
    when(this.urlContentReaderMock.getJson(request.toUrl())).thenReturn(jsonContent);

    final TeamListItem teamListItem1 = new TeamListItem(61230, "Justice Incarnate");
    teamListItem1.setAliases("The Multiversity\r\nJustice League Incarnate");
    teamListItem1.setSummary("The Cosmic neighborhood Watch, the squadron of super-guardians, the Justice League of the Multiverse, a volunteer army reunited to protect the orrery of worlds against the dark forces from beyond the 52 known universes.");
    teamListItem1.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.</p>");
    teamListItem1.setPublisher(new PublisherCredit(10, "DC Comics"));

    final Image teamImage1 = new Image();
    teamImage1.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11138/111381541/8292798-justiceleagueincarnate2.jpg");
    teamImage1.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11138/111381541/8292798-justiceleagueincarnate2.jpg");
    teamImage1.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11138/111381541/8292798-justiceleagueincarnate2.jpg");
    teamImage1.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11138/111381541/8292798-justiceleagueincarnate2.jpg");
    teamImage1.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11138/111381541/8292798-justiceleagueincarnate2.jpg");
    teamImage1.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11138/111381541/8292798-justiceleagueincarnate2.jpg");
    teamImage1.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11138/111381541/8292798-justiceleagueincarnate2.jpg");
    teamImage1.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11138/111381541/8292798-justiceleagueincarnate2.jpg");
    teamImage1.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11138/111381541/8292798-justiceleagueincarnate2.png");
    teamImage1.setImageTags("All Images");
    teamListItem1.setImage(teamImage1);

    final TeamListItem teamListItem2 = new TeamListItem(60967, "Justice League 3000");
    teamListItem2.setAliases("JLA3K\r\nJustice League 3001");
    teamListItem2.setSummary("Created by Cadmus in the year 3000, the heroes from the past rise to fight the menaces of tomorrow.");
    teamListItem2.setDescription("<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>");
    teamListItem2.setPublisher(new PublisherCredit(10, "DC Comics"));

    final Image teamImage2 = new Image();
    teamImage2.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11111/111113340/5141263-3790957044-NOV15.jpg");
    teamImage2.setImageTags("All Images");
    teamListItem2.setImage(teamImage2);


    final TeamListItem teamListItem3 = new TeamListItem(62328, "United States Department of Justice");
    teamListItem3.setAliases("DOJ\r\nUS Department of Justice");
    teamListItem3.setPublisher(new PublisherCredit(159, "Non-Fictional"));

    final Image teamImage3 = new Image();
    teamImage3.setIconUrl("https://comicvine.gamespot.com/a/uploads/square_avatar/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setMediumUrl("https://comicvine.gamespot.com/a/uploads/scale_medium/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setScreenUrl("https://comicvine.gamespot.com/a/uploads/screen_medium/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setScreenLargeUrl("https://comicvine.gamespot.com/a/uploads/screen_kubrick/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setSmallUrl("https://comicvine.gamespot.com/a/uploads/scale_small/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setSuperUrl("https://comicvine.gamespot.com/a/uploads/scale_large/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setThumbUrl("https://comicvine.gamespot.com/a/uploads/scale_avatar/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setTinyUrl("https://comicvine.gamespot.com/a/uploads/square_mini/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setOriginalUrl("https://comicvine.gamespot.com/a/uploads/original/11/114183/5158897-720px-seal_of_the_united_states_department_of_justice.svg.png");
    teamImage3.setImageTags("All Images");
    teamListItem3.setImage(teamImage3);

    final List<TeamListItem> expResult = ImmutableList.of(teamListItem1, teamListItem2, teamListItem3);
    final int expNumberOfPageResults = 3;
    final int expNumberOfTotalResults = 94;
    final int expLimit = 3, expOffset = 0;

    final ApiListResponse<TeamListItem> result = this.instance.searchTeams(request);
    assertEquals(StatusCode.OKAY, result.getStatusCode());
    assertEquals(expNumberOfPageResults, result.getNumberOfPageResults());
    assertEquals(expNumberOfTotalResults, result.getNumberOfTotalResults());
    assertEquals(expLimit, result.getLimit());
    assertEquals(expOffset, result.getOffset());
    assertEquals(expResult.toString(), result.getResults().toString());
  }
}