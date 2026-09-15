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

    @OneToMany(mappedBy = "credits")
    private List<CastMember> cast;

    @OneToMany(mappedBy = "credits")
    private List<CrewMember> crew;
}
