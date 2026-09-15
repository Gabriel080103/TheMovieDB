package app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "crew_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CrewMember {

    @Id
    private int id;

    private boolean adult;
    private int gender;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private double popularity;
    private String profilePath;
    private String creditId;
    private String department;
    private String job;

    @ManyToOne
    @JoinColumn(name = "credits_id")
    private Credits credits;
}