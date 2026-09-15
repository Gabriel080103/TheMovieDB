package app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "production_companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductionCompany {

    @Id
    private int id;

    private String name;
    private String originCountry;

    @ManyToOne
    @JoinColumn(name = "details_id")
    private Details details;
}