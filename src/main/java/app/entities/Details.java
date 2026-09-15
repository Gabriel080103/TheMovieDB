package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Details {

    @Id
    private int id;

    private boolean adult;
    private long budget;

    @ElementCollection
    private List<String> originCountry;

    private String originalLanguage;
    private String originalTitle;

    @Column(length = 5000)
    private String overview;

    private double popularity;
    private LocalDate releaseDate;
    private long revenue;
    private long runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double voteAverage;
    private long voteCount;

    private String imdbId;

    @OneToMany(mappedBy = "details")
    private List<Genre> genres;

    @OneToMany(mappedBy = "details")
    private List<ProductionCompany> productionCompanies;

    @OneToMany(mappedBy = "details")
    private List<SpokenLanguage> spokenLanguages;
}