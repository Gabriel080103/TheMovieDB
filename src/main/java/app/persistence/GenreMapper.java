package app.persistence;

import app.DTOs.GenreDTO;
import app.entities.Genre;

public class GenreMapper {
    public Genre toEntity(GenreDTO dto) {
        Genre genre = new Genre();
        genre.setId(dto.getId());
        genre.setName(dto.getName());
        return genre;
    }

    public GenreDTO toDTO(Genre entity) {
        return null;
    }
}