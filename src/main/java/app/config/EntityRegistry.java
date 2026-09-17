package app.config;

import app.entities.*;
import org.hibernate.cfg.Configuration;

final class EntityRegistry {

    private EntityRegistry() {
    }

    static void registerEntities(Configuration configuration) {
        configuration.addAnnotatedClass(Movie.class);
        configuration.addAnnotatedClass(Details.class);
        configuration.addAnnotatedClass(Genre.class);
        configuration.addAnnotatedClass(ProductionCompany.class);
        configuration.addAnnotatedClass(SpokenLanguage.class);
        configuration.addAnnotatedClass(Credits.class);
        configuration.addAnnotatedClass(CastMember.class);
        configuration.addAnnotatedClass(CrewMember.class);
        // TODO: Add more entities here...
    }
}