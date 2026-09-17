package app.service;

import app.DTOs.CreditsDTO;
import app.DTOs.DetailsDTO;
import app.DTOs.MovieDTO;

public class MovieService {
    // APIKEY
    private static final String apiKey = System.getenv("api_key");

    //APIReader instance
    private static final APIReader apiReader = new APIReader();

    // API URLs - Named after operation:
    private static final String getMovieDetailsURL = "https://api.themoviedb.org/3/movie/MOVIEID?api_key=" + apiKey;
    private static final String getMovieCreditsURL = "https://api.themoviedb.org/3/movie/MOVIEID/credits?api_key=" + apiKey;

    public DetailsDTO getMovieDetails(String movieId) {
        String url = getMovieDetailsURL.replace("MOVIEID", movieId);
        return apiReader.getWithJackson(url, DetailsDTO.class);
    }

    public CreditsDTO getMovieCredits(String creditId) {
        String url = getMovieCreditsURL.replace("MOVIEID", creditId);
        return apiReader.getWithJackson(url, CreditsDTO.class);
    }

    public MovieDTO createMovieDTO(String movieId) {
        DetailsDTO detailsDTO = getMovieDetails(movieId);
        CreditsDTO creditsDTO = getMovieCredits(movieId);
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setDetailDTO(detailsDTO);
        movieDTO.setCreditsDTO(creditsDTO);
        return movieDTO;
    }
}
