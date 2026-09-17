package app.persistence;


import app.DTOs.GenreDTO;
import app.DTOs.ProductionCompanyDTO;
import app.entities.Genre;
import app.entities.ProductionCompany;

public class ProductionCompanyMapper {

    public ProductionCompany toEntity(ProductionCompanyDTO dto) {
        ProductionCompany productionCompany = new ProductionCompany();
        productionCompany.setId(dto.getId());
        productionCompany.setName(dto.getName());
        productionCompany.setOriginCountry(dto.getOriginCountry());
        return productionCompany;
    }
}
