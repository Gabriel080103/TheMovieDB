package app.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CastMemberDTO {

    @JsonProperty("adult")
    private boolean adult;

    @JsonProperty("gender")
    private int gender;

    @JsonProperty("id")
    private int id;

    @JsonProperty("known_for_department")
    private String knownForDepartment;

    @JsonProperty("name")
    private String name;

    @JsonProperty("original_name")
    private String originalName;

    @JsonProperty("popularity")
    private double popularity;

    @JsonProperty("profile_path")
    private String profilePath;

    @JsonProperty("cast_id")
    private int castId;

    @JsonProperty("character")
    private String character;

    @JsonProperty("credit_id")
    private String creditId;

    @JsonProperty("order")
    private int order;
}
