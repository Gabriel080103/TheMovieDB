package app.persistence;

import app.DTOs.MovieDTO;
import app.entities.Movie;

public class MovieMapper {

    public Movie toEntity(MovieDTO dto) {
        Movie movie = new Movie();
        DetailsMapper detailsMapper = new DetailsMapper();
        CreditsMapper creditsMapper = new CreditsMapper();
        movie.setId(dto.getId());
        movie.setDetails(detailsMapper.toEntity(dto.getDetailDTO()));
        movie.setCredits(creditsMapper.toEntity(dto.getCreditsDTO()));
        return movie;
    }
}
