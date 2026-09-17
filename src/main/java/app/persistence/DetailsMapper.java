package app.persistence;

import app.DTOs.DetailsDTO;
import app.DTOs.GenreDTO;
import app.DTOs.ProductionCompanyDTO;
import app.DTOs.SpokenLanguageDTO;
import app.entities.Details;
import app.entities.Genre;
import app.entities.ProductionCompany;
import app.entities.SpokenLanguage;

import java.util.ArrayList;
import java.util.List;

public class DetailsMapper {

    Details toEntity(DetailsDTO dto) {
        Details details = new Details();
        details.setId(dto.getId());
        details.setAdult(dto.isAdult());
        details.setBudget(dto.getBudget());
        details.setOriginCountry(dto.getOriginCountry());
        details.setOriginalLanguage(dto.getOriginalLanguage());
        details.setOriginalTitle(dto.getOriginalTitle());
        details.setOverview(dto.getOverview());
        details.setPopularity(dto.getPopularity());
        details.setReleaseDate(dto.getReleaseDate());
        details.setRevenue(dto.getRevenue());
        details.setRuntime(dto.getRuntime());
        details.setStatus(dto.getStatus());
        details.setTagline(dto.getTagline());
        details.setTitle(dto.getTitle());
        details.setVideo(dto.isVideo());
        details.setVoteAverage(dto.getVoteAverage());
        details.setVoteCount(dto.getVoteCount());

        //
        GenreMapper genreMapper = new GenreMapper();
        List<Genre> genreList = new ArrayList<>();
        for (GenreDTO genre : dto.getGenres()) {
            Genre entityGenre = genreMapper.toEntity(genre);
            entityGenre.setDetails(details);
            genreList.add(entityGenre);
        }
        details.setGenres(genreList);
        System.out.println("Genres fra DTO: " + dto.getGenres());
        System.out.println("Genres på entity: " + details.getGenres());
        //
        ProductionCompanyMapper productionCompanyMapper = new ProductionCompanyMapper();
        List<ProductionCompany> productionCompanyList = new ArrayList<>();
        for (ProductionCompanyDTO productionCompany : dto.getProductionCompanies()) {
            ProductionCompany productionCompanyEntity = productionCompanyMapper.toEntity(productionCompany);
            productionCompanyEntity.setDetails(details);
            productionCompanyList.add(productionCompanyEntity);
        }
        details.setProductionCompanies(productionCompanyList);
        //
        SpokenLanguageMapper spokenLanguageMapper = new SpokenLanguageMapper();
        List<SpokenLanguage> spokenLanguageList = new ArrayList<>();
        for (SpokenLanguageDTO spokenLanguageDTO : dto.getSpokenLanguages()) {
            SpokenLanguage spokenLanguageEntity = spokenLanguageMapper.toEntity(spokenLanguageDTO);
            spokenLanguageEntity.setDetails(details);
            spokenLanguageList.add(spokenLanguageEntity);
        }
        details.setSpokenLanguages(spokenLanguageList);
        //
        return details;
    }


}