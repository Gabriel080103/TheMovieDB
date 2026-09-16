package app.persistence;

import app.DTOs.GenreDTO;
import app.DTOs.MovieDTO;
import app.entities.Genre;
import app.entities.Movie;

public class MovieMapper {

    public Movie toEntity(MovieDTO dto) {
        Movie movie = new Movie();
        DetailsMapper detailsMapper = new DetailsMapper();
        CreditsMapper creditsMapper = new CreditsMapper();
        movie.setDetails(detailsMapper.toEntity(dto.getDetailDTO()));
        movie.setCredits(creditsMapper.toEntity(dto.getCreditsDTO()));
        return movie;
    }

    public MovieDTO toDTO(Movie entity) {
        return null;
    }
}
