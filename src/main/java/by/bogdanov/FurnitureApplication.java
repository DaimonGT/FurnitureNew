package by.bogdanov;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.sql.Connection;
import java.sql.DriverManager;

public class FurnitureApplication {
    private static final String URL = "jdbc:postgresql://localhost:5432/education_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static final String MONGO_URL = "mongodb://admin:admin123@localhost:27017/?authSource=admin&authMechanism=SCRAM-SHA-1";
    private static String MONGO_DB = "furniture_db";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             MongoClient mongoClient = MongoClients.create(MONGO_URL)) {
        } catch (Exception e) {
            System.err.println("Ошибка при работе с БД " + e.getMessage());
        }
    }
}
