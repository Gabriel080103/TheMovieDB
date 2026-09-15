package app.DAOs;

import app.entities.Credits;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CreditsDAO {

    private final EntityManagerFactory emf;

    public CreditsDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Credits credits) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(credits);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Credits findById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Credits.class, id);
        } finally {
            em.close();
        }
    }

    public List<Credits> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT c FROM Credits c",
                    Credits.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Credits credits) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(credits);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Credits credits = em.find(Credits.class, id);

            if (credits != null) {
                em.remove(credits);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
