package app.entities;

import app.persistence.CastMemberMapper;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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

    @JdbcTypeCode(SqlTypes.ARRAY)
    private String[] originCountry;

    private String originalLanguage;
    private String originalTitle;

    @Column(length = 5000)
    private String overview;

    private double popularity;
    private String releaseDate;
    private long revenue;
    private long runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double voteAverage;
    private long voteCount;

    private String imdbId;

    @OneToMany(mappedBy = "details", cascade = CascadeType.ALL)
    private List<Genre> genres;

    @OneToMany(mappedBy = "details", cascade = CascadeType.ALL)
    private List<ProductionCompany> productionCompanies;

    @OneToMany(mappedBy = "details", cascade = CascadeType.ALL)
    private List<SpokenLanguage> spokenLanguages;
}