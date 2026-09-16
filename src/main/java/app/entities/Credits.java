package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "credits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Credits {

    @Id
    private int id;

    @OneToMany(mappedBy = "credits", cascade = CascadeType.ALL)
    private List<CastMember> cast;

    @OneToMany(mappedBy = "credits", cascade = CascadeType.ALL)
    private List<CrewMember> crew;

    public Credits(List<CrewMember> crew, List<CastMember> cast) {
        this.cast = cast;
        this.crew = crew;
    }
}
