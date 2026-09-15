package app.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditsDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("cast")
    private List<CastMemberDTO> cast;

    @JsonProperty("crew")
    private List<CrewMemberDTO> crew;
}
