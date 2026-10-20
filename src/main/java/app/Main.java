
package app;

import app.config.HibernateConfig;
import app.DAOs.MovieDAO;
import app.service.MovieService;
import jakarta.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;

        try {
            System.out.println("Starting MovieDB backend...");

            // Initialize Hibernate and the database connection
            emf = HibernateConfig.getEntityManagerFactory();

            // Initialize existing backend components
            MovieDAO movieDAO = new MovieDAO(emf);
            MovieService movieService = new MovieService();

            System.out.println("Database connection initialized.");
            System.out.println("MovieDAO initialized.");
            System.out.println("MovieService initialized.");
            System.out.println("MovieDB backend started successfully.");

            // Keep the backend process alive
            Thread.currentThread().join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("MovieDB backend shutting down.");

        } catch (Exception e) {
            System.err.println("Failed to start MovieDB backend.");
            e.printStackTrace();
            System.exit(1);

        } finally {
            if (emf != null && !Thread.currentThread().isInterrupted()) {
                emf.close();
            }
        }
    }
}