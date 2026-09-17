package app.DAOs;

import app.DTOs.MovieDTO;
import app.config.HibernateConfig;
import app.entities.Movie;
import app.persistence.MovieMapper;
import app.service.APIReader;
import app.service.MovieService;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieDAOTest {

    private static EntityManagerFactory emf;
    private MovieDAO movieDAO;

    @BeforeAll
    static void setupClass() {
        emf = HibernateConfig.getEntityManagerFactory();
    }

    @BeforeEach
    void setup() {

        movieDAO = new MovieDAO(emf);
    }

    @AfterAll
    static void teardownClass() {
        emf.close();
    }


    @Test
    void save() {
        Movie movie = new Movie();
        MovieService movieService = new MovieService();
        MovieMapper movieMapper = new MovieMapper();
        MovieDTO movieDTO = movieService.createMovieDTO(27);
        System.out.println(movieDTO.getId());
        movie = movieMapper.toEntity(movieDTO);

        movieDAO.save(movie);

        Movie movie2 = new Movie();
        MovieDTO movieDTO2 = movieService.createMovieDTO(139);
        System.out.println(movieDTO2.getId());
        movie2 = movieMapper.toEntity(movieDTO2);

        movieDAO.save(movie2);

        Movie result = movieDAO.findById(27);
        Movie result2 = movieDAO.findById(139);

        assertNotNull(result);
        assertEquals("9 Songs", result.getDetails().getTitle());
        assertNotNull(result2);
        assertEquals("Mifune", result2.getDetails().getTitle());
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
        Movie movie = movieDAO.findById(27);
        movieDAO.delete(27);
        assertNull(movie);
    }
}