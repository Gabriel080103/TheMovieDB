package app;

import app.DAOs.DetailsDAO;
import app.DAOs.MovieDAO;
import app.DTOs.MovieDTO;
import app.config.HibernateConfig;
import app.entities.Movie;
import app.persistence.MovieMapper;
import app.service.MovieService;
import jakarta.persistence.EntityManagerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    static void main() {
        // Instances :
        MovieService movieService = new MovieService();
        MovieMapper movieMapper = new MovieMapper();
        MovieDAO movieDAO = new MovieDAO(emf);


        // TEST : get Movie Details
        System.out.println(movieService.getMovieDetails("139"));

        // TEST : get Movie Credits
        System.out.println(movieService.getMovieCredits("139"));

        // TEST : get Movie and make a MovieDTO then convert it to an entity and upload it to the DB
        MovieDTO movieDTO = movieService.createMovieDTO("139");
        Movie movie = movieMapper.toEntity(movieDTO);
        movieDAO.save(movie);

        // TEST : DTO LISTS
        System.out.println(movieDTO.getDetailDTO().getGenres());
    }
}
