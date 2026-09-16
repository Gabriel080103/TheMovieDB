package app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "spoken_languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpokenLanguage {
    public SpokenLanguage(String englishName, String name) {
        this.englishName = englishName;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String englishName;
    private String name;

    @ManyToOne
    @JoinColumn(name = "details_id")
    private Details details;
}