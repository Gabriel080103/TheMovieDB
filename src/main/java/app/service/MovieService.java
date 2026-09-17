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

    public DetailsDTO getMovieDetails(int movieId) {
        String url = getMovieDetailsURL.replace("MOVIEID", String.valueOf(movieId));
        return apiReader.getWithJackson(url, DetailsDTO.class);
    }

    public CreditsDTO getMovieCredits(int movieId) {
        String url = getMovieCreditsURL.replace("MOVIEID", String.valueOf(movieId));
        return apiReader.getWithJackson(url, CreditsDTO.class);
    }

    public MovieDTO createMovieDTO(int movieId) {
        DetailsDTO detailsDTO = getMovieDetails(movieId);
        CreditsDTO creditsDTO = getMovieCredits(movieId);
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieId);
        movieDTO.setDetailDTO(detailsDTO);
        movieDTO.setCreditsDTO(creditsDTO);
        return movieDTO;
    }
}
