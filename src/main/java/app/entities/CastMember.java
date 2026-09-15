package app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cast_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CastMember {

    @Id
    private int id;

    private boolean adult;
    private int gender;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private double popularity;
    private String profilePath;
    private int castId;
    private String character;
    private String creditId;
    private int castOrder;

    @ManyToOne
    @JoinColumn(name = "credits_id")
    private Credits credits;
}