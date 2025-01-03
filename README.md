# cv-tools
A Java library for retrieving information from the Comicvine API.

## Adding ***cv-tools*** to your build

To add a dependency on ***cv-tools*** using Maven, use the following:
```xml
<dependency>
  <groupId>io.github.stebeg</groupId>
  <artifactId>cv-tools</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Usage

You need a Comicvine API-key to use this library.  
See [https://comicvine.gamespot.com/api/](https://comicvine.gamespot.com/api/)

The `ComicvineTools` class provides instances various retriever classes such as `VolumeRetriever`, `IssueRetriever`, and
`CharacterRetriever`, which can be used to search and retrieve information for the respective entities.

### Example for searching volumes

```java
final String apiKey = "..."; // your API key
final VolumeRetriever volumeRetriever = ComicvineTools.getVolumeRetriever();

final String searchText = "Green Lantern";
final List<String> fieldNames = List.of(
    VolumeAttribute.ID,
    VolumeAttribute.NAME,
    VolumeAttribute.DESCRIPTION,
    VolumeAttribute.START_YEAR,
    VolumeAttribute.ISSUE_COUNT,
    VolumeAttribute.IMAGE,
    VolumeAttribute.PUBLISHER);
final SearchVolumesRequest request = new SearchVolumesRequest(apiKey, searchText)
    .withFieldNames(fieldNames)
    .withLimit(100);
final ApiListResponse<VolumeListItem> response = volumeRetriever.searchVolumes(request);
final List<VolumeListItem> volumes = response.getResults();
```

### Example for retrieving a volume by its ID

```java
final String apiKey = "..."; // your API key
final VolumeRetriever volumeRetriever = ComicvineTools.getVolumeRetriever();

final long volumeId = 42808L;
final List<String> fieldNames = List.of(
    VolumeAttribute.ID,
    VolumeAttribute.NAME,
    VolumeAttribute.DESCRIPTION,
    VolumeAttribute.START_YEAR,
    VolumeAttribute.ISSUE_COUNT,
    VolumeAttribute.IMAGE,
    VolumeAttribute.PUBLISHER);
final GetVolumeByIdRequest request = new GetVolumeByIdRequest(apiKey, volumeId);
final ApiResponse<Volume> response = volumeRetriever.getVolumeById(request);
final Volume volume = response.getResult();
```

## Available retrievers

Retrievers are available for the following Comicvine entities:

* character
* issue
* location
* person
* publisher
* story arc
* team
* volume