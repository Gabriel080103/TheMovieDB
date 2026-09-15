package app.DAOs;

import app.entities.CastMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CastMemberDAO {

    private final EntityManagerFactory emf;

    public CastMemberDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(CastMember castMember) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(castMember);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public CastMember findById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(CastMember.class, id);
        } finally {
            em.close();
        }
    }

    public List<CastMember> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT c FROM CastMember c",
                    CastMember.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(CastMember castMember) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(castMember);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            CastMember castMember =
                    em.find(CastMember.class, id);

            if (castMember != null) {
                em.remove(castMember);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
