package by.bogdanov;

import by.bogdanov.config.FurnitureModule;
import by.bogdanov.service.FurnitureAggregationService;
import by.bogdanov.service.FurniturePostgresService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FurnitureApplication {
    private static final Logger logger = LogManager.getLogger(FurnitureApplication.class); // переменная для логирования
    private static final String URL = "jdbc:postgresql://localhost:5432/education_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static final String MONGO_URL = "mongodb://admin:admin123@localhost:27017/?authSource=admin&authMechanism=SCRAM-SHA-1";
    private static String MONGO_DB = "furniture_db";

    public static void main(String[] args) {
        logger.info("Запуск приложения");
        Injector injector = Guice.createInjector(new FurnitureModule());
        FurnitureAggregationService transferService = injector.getInstance(FurnitureAggregationService.class);
        try {
            FurniturePostgresService pgService = injector.getInstance(FurniturePostgresService.class);
        } catch (Exception e) {
            logger.error("Ошибка при работе с БД ", e);
        }
    }
}
