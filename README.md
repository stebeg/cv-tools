# cv-tools
A Java library for retrieving information from the Comicvine API.

## Usage

You need a Comicvine API-key to use this library.  
See [https://comicvine.gamespot.com/api/](https://comicvine.gamespot.com/api/)

The `ComicvineToolsProvider` class provides instances for `VolumeReader` and `IssueReader`, which can be used to search volumes and retrive informations for volumes and issues.

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

    