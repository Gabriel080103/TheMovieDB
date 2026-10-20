package app;

import app.config.HibernateConfig;
import app.DAOs.MovieDAO;
import app.service.MovieService;
import com.sun.net.httpserver.HttpServer;
import jakarta.persistence.EntityManagerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf =
                HibernateConfig.getEntityManagerFactory();

        MovieDAO movieDAO = new MovieDAO(emf);
        MovieService movieService = new MovieService();

        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0", 7070), 0
        );

        server.createContext("/", exchange -> {
            byte[] response = """
                    {
                      "status": "ok",
                      "service": "MovieDB",
                      "message": "Backend is running"
                    }
                    """.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders()
                    .set("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("MovieDB HTTP server running on port 7070");
    }
}