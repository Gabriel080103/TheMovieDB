package app;

import app.config.HibernateConfig;
import app.service.MovieService;
import jakarta.persistence.EntityManagerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    static void main() {
        // Instances :
        MovieService movieService = new MovieService();

        // TEST : get Movie Details
        System.out.println(movieService.getMovieDetails("139"));

        // TEST : get Movie Credits
        System.out.println(movieService.getMovieCredits("139"));

    }
}
