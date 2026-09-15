package app.DAOs;

import app.entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class GenreDAO {

    private final EntityManagerFactory emf;

    public GenreDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Genre genre) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(genre);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Genre findById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Genre.class, id);
        } finally {
            em.close();
        }
    }

    public List<Genre> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT g FROM Genre g",
                    Genre.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Genre genre) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(genre);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Genre genre = em.find(Genre.class, id);

            if (genre != null) {
                em.remove(genre);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
