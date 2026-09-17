package app.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailsDTO {

    @JsonProperty("adult")
    private boolean adult;

    @JsonProperty("budget")
    private long budget;

    @JsonProperty("genres")
    private List<GenreDTO> genres;

    @JsonProperty("id")
    private int id;

    @JsonProperty("imdb_id")
    private String imdbId;

    @JsonProperty("origin_country")
    private String[] originCountry;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("popularity")
    private double popularity;

    @JsonProperty("production_companies")
    private List<ProductionCompanyDTO> productionCompanies;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("revenue")
    private long revenue;

    @JsonProperty("runtime")
    private long runtime;

    @JsonProperty("spoken_languages")
    private List<SpokenLanguageDTO> spokenLanguages;

    @JsonProperty("status")
    private String status;

    @JsonProperty("tagline")
    private String tagline;

    @JsonProperty("title")
    private String title;

    @JsonProperty("video")
    private boolean video;

    @JsonProperty("vote_average")
    private double voteAverage;

    @JsonProperty("vote_count")
    private long voteCount;
}
