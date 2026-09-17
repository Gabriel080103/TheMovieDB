package test;

import app.DAOs.MovieDAO;
import app.config.HibernateConfig;
import app.persistence.MovieMapper;
import app.service.MovieService;
import jakarta.persistence.EntityManagerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class testMain {
    public static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    static void main() {
        // Instances :
        MovieService movieService = new MovieService();
        MovieMapper movieMapper = new MovieMapper();
        MovieDAO movieDAO = new MovieDAO(emf);

        // TEST : get Movie Details
//        System.out.println(movieService.getMovieDetails("139"));

        // TEST : get Movie Credits
//        System.out.println(movieService.getMovieCredits("139"));

        // TEST : get Movie and make a MovieDTO then convert it to an entity and upload it to the DB
//        MovieDTO movieDTO = movieService.createMovieDTO("139");
//        Movie movie = movieMapper.toEntity(movieDTO);
//        movieDAO.save(movie);

        // TEST : DTO LIST
//        System.out.println(movieDTO.getDetailDTO().getGenres());
    }
}