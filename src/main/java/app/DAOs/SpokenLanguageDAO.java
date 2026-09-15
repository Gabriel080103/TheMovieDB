package app.DAOs;

import app.entities.SpokenLanguage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class SpokenLanguageDAO {

    private final EntityManagerFactory emf;

    public SpokenLanguageDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(SpokenLanguage language) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(language);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public SpokenLanguage findById(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(SpokenLanguage.class, id);
        } finally {
            em.close();
        }
    }

    public List<SpokenLanguage> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT s FROM SpokenLanguage s",
                    SpokenLanguage.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(SpokenLanguage language) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(language);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            SpokenLanguage language =
                    em.find(SpokenLanguage.class, id);

            if (language != null) {
                em.remove(language);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}