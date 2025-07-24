package by.bogdanov.config;

import by.bogdanov.factory.FurnitureFactory;
import by.bogdanov.repository.FurnitureMongoRepository;
import by.bogdanov.repository.FurniturePostgresRepository;
import by.bogdanov.service.FurnitureMongoService;
import by.bogdanov.service.FurniturePostgresService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FurnitureModule extends AbstractModule {
    @Override
    protected void configure() {
/* Если есть интерфейс
bind(FurnitureRepository.class)
                .annotatedWith(Names.named("Postgres"))
                .to(FurniturePostgresRepository.class);
        bind(FurnitureRepository.class)
                .annotatedWith(Names.named("Mongo"))
                .to(FurnitureMongoRepository.class);*/
        bind(FurniturePostgresRepository.class);
        bind(FurnitureMongoRepository.class);
        bind(FurniturePostgresService.class);
        bind(FurnitureMongoService.class);
        bind(FurnitureFactory.class);
    }

    @Provides
    @Named("PostgresConnection")
    Connection providePostgresConnection() throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/education_db";
        String USER = "postgres";
        String PASSWORD = "password";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Provides
    @Named("MongoCollection")
    MongoCollection<Document> providedMongoCollection() {
        String MONGO_URL = "mongodb://admin:admin123@localhost:27017/?authSource=admin&authMechanism=SCRAM-SHA-1";
        String MONGO_DB = "furniture_db";
        String MongoCollection = "furniture";
        MongoClient mongoClient = MongoClients.create(MONGO_URL);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(MongoCollection);
        return mongoDatabase.getCollection(MongoCollection);

    }
}
