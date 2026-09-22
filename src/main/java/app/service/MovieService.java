package app.service;

import app.DAOs.MovieDAO;
import app.DTOs.CreditsDTO;
import app.DTOs.DetailsDTO;
import app.DTOs.MovieDTO;
import app.DTOs.MovieSearchDTO;
import app.entities.Movie;
import app.persistence.MovieMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

import static app.Main.emf;

public class MovieService {
    // APIKEY
    private static final String apiKey = System.getenv("api_key");

    //APIReader instance
    private static final APIReader apiReader = new APIReader();

    //Instances
    MovieMapper movieMapper = new MovieMapper();

    // API URLs - Named after operation:
    private static final String getMovieDetailsURL = "https://api.themoviedb.org/3/movie/MOVIEID?api_key=" + apiKey;
    private static final String getMovieCreditsURL = "https://api.themoviedb.org/3/movie/MOVIEID/credits?api_key=" + apiKey;
    private static final String getDanishMoviesWithin5Years = "https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey + "&with_origin_country=DK&primary_release_date.gte=2021-09-17&primary_release_date.lte=2026-09-17&page=PAGE";

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

    public Movie saveMovie(int movieId, EntityManagerFactory emf) {
        MovieDAO movieDAO = new MovieDAO(emf);
        MovieDTO movieDTO = createMovieDTO(movieId);
        Movie movie = movieMapper.toEntity(movieDTO);
        movieDAO.save(movie);
        return movie;
    }

    public void saveAllDanishMovies() {
        String url1 = getDanishMoviesWithin5Years;
        url1 = url1.replace("PAGE", "1");
        MovieSearchDTO result = apiReader.getWithJackson(url1, MovieSearchDTO.class);
        int totalPages = result.getTotal_pages();
        int movieCounter = 0;
        List<Integer> savedMovieDTOIds = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            String url = getDanishMoviesWithin5Years;
            url = url.replace("PAGE", String.valueOf(i));
            MovieSearchDTO resultPage = apiReader.getWithJackson(url, MovieSearchDTO.class);
            List<MovieDTO> moviesOnPage = resultPage.getResults();
            for (MovieDTO movieDTO : moviesOnPage) {
                if(!savedMovieDTOIds.contains(movieDTO.getId())) {
                savedMovieDTOIds.add(movieDTO.getId());
                System.out.println("PAGE " + i + " -> Saving movie: " + movieDTO.getId());
                System.out.println("Saving movie: " + movieDTO.getId());
                saveMovie(movieDTO.getId(), emf);
                movieCounter++;
                }
            }
        }
        System.out.println(movieCounter);
    }
}
