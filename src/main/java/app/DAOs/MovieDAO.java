package app.DAOs;

import app.entities.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class MovieDAO {

    private final EntityManagerFactory emf;

    public MovieDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Movie movie) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Movie findById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Movie.class, id);
        } finally {
            em.close();
        }
    }

    public List<Movie> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT m FROM Movie m",
                    Movie.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Movie movie) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(movie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Movie movie = em.find(Movie.class, id);

            if (movie != null) {
                em.remove(movie);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
