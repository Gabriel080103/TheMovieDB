package app.DTOs;

import lombok.Data;
import java.util.List;

@Data
public class MovieSearchDTO {

    private int page;
    private List<MovieDTO> results;
    private int total_pages;
    private int total_results;
}