package app.DAOs;

import app.entities.Details;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DetailsDAO {

    private final EntityManagerFactory emf;

    public DetailsDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Details details) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(details);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Details findById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Details.class, id);
        } finally {
            em.close();
        }
    }

    public List<Details> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT d FROM Details d",
                    Details.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Details details) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(details);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Details details = em.find(Details.class, id);

            if (details != null) {
                em.remove(details);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
