package app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genre {

    @Id
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "details_id")
    private Details details;
}