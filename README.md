# cv-tools
A Java library for retrieving information from the Comicvine API.

## Usage

You need a Comicvine API-key to use this library.  
See [https://comicvine.gamespot.com/api/](https://comicvine.gamespot.com/api/)

The `ComicvineToolsProvider` class provides instances for `CharacterReader` `VolumeReader` and 
`IssueReader`, which can be used to search volumes and retrive informations for charcters volumes 
and issues.

### Search volumes

        final String apiKey = "abcdef12345";
        final String searchText = "Green Lantern";

        final VolumeReader volumeReader = ComicvineToolsProvider.getVolumeReader();
        final VolumeSearchResult result = volumeReader.searchVolumes(apiKey, searchText);

        for (final Volume volume : result.getVolumes()) {
            System.out.println("volume name = " + volume.getName());
        }

### Reading volume information

        final String apiKey = "abcdef12345";
        final long volumeId = 2839L;

        final VolumeReader volumeReader = ComicvineToolsProvider.getVolumeReader();
        final VolumeGetResult result = volumeReader.getVolume(apiKey, volumeId);

        final Volume volume = result.getVolume();
        System.out.println("volume name = " + volume.getName());
    

### Reading volume issues

        final String apiKey = "abcdef12345";
        final long volumeId = 2839L;

        final IssueReader issueReader = ComicvineToolsProvider.getIssueReader();
        final IssuesGetResult result = issueReader.getVolumeIssues(apiKey, volumeId);

        for (final Issue issue : result.getIssues()) {
            System.out.println("Issue number = " + issue.getIssueNumber());
        }

### Reading issue information

        final String apiKey = "abcdef12345";
        final long issueId = 310551L;

        final IssueReader issueReader = ComicvineToolsProvider.getIssueReader();
        final IssueGetResult result = issueReader.getIssue(apiKey, issueId);

        final Issue issue = result.getIssue();
        System.out.println("Issue number = " + issue.getIssueNumber());

### Reading character information

        final String apiKey = "abcdef12345";
        final long characterId = 11202L;
        
        final CharacterReader characterReader = ComicvineToolsProvider.getCharacterReader();
        final CharacterGetResult characterGetResult = characterReader.getCharacter(apiKey, characterId);
        
        final Character character = characterGetResult.getResult();
        System.out.println(character.getRealName());

### Reading team information

        final String apiKey = "abcdef12345";
        final long teamId = 11202L;
        
        final TeamReader teamReader = ComicvineToolsProvider.getTeamReader();
        final TeamGetResult teamGetResult = teamReader.getTeam(apiKey, teamId);
        
        final Team team = teamGetResult.getResult();
        System.out.println(team.getName());

### Reading publisher information

        final String apiKey = "abcdef12345";
        final long publisherId = 10L;

        final PublisherReader publisherReader = ComicvineToolsProvider.getPublisherReader();
        final PublisherGetResult publisherGetResult = publisherReader.getPublisher(apiKey, publisherId);

        final Publisher publisher = publisherGetResult.getResult();
        System.out.println(publisher.getName());

### Reading person information

        final String apiKey = "abcdef12345";
        final long personId = 40439L;

        final PersonReader personReader = ComicvineToolsProvider.getPersonReader();
        final PersonGetResult personGetResult = personReader.getPerson(apiKey, personId);

        final Person person = personGetResult.getResult();
        System.out.println(person.getName());