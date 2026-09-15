package app.DAOs;

import app.entities.ProductionCompany;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class ProductionCompanyDAO {

    private final EntityManagerFactory emf;

    public ProductionCompanyDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(ProductionCompany company) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public ProductionCompany findById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(ProductionCompany.class, id);
        } finally {
            em.close();
        }
    }

    public List<ProductionCompany> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT p FROM ProductionCompany p",
                    ProductionCompany.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(ProductionCompany company) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(company);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            ProductionCompany company =
                    em.find(ProductionCompany.class, id);

            if (company != null) {
                em.remove(company);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
