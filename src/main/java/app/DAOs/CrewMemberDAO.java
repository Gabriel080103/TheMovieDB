package app.DAOs;

import app.entities.CrewMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CrewMemberDAO {

    private final EntityManagerFactory emf;

    public CrewMemberDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(CrewMember crewMember) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(crewMember);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public CrewMember findById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(CrewMember.class, id);
        } finally {
            em.close();
        }
    }

    public List<CrewMember> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT c FROM CrewMember c",
                    CrewMember.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(CrewMember crewMember) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(crewMember);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            CrewMember crewMember =
                    em.find(CrewMember.class, id);

            if (crewMember != null) {
                em.remove(crewMember);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
