package app.persistence;

import app.DTOs.GenreDTO;
import app.DTOs.SpokenLanguageDTO;
import app.entities.Genre;
import app.entities.SpokenLanguage;

public class SpokenLanguageMapper {
    public SpokenLanguage toEntity(SpokenLanguageDTO dto) {
        SpokenLanguage spokenLanguage = new SpokenLanguage();
        spokenLanguage.setEnglishName(dto.getEnglishName());
        spokenLanguage.setName(dto.getName());
        return spokenLanguage;
    }

    public SpokenLanguageDTO toDTO(SpokenLanguage entity) {
        return null;
    }
}

