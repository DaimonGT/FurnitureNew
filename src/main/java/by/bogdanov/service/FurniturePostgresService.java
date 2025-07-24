package by.bogdanov.service;

import by.bogdanov.repository.FurniturePostgresRepository;

import javax.inject.Inject;
import java.sql.SQLException;

public class FurniturePostgresService {
    private final FurniturePostgresRepository furniturePostgresRepository;

    @Inject
    public FurniturePostgresService(FurniturePostgresRepository furniturePostgresRepository) {
        this.furniturePostgresRepository = furniturePostgresRepository;
    }

    public void addFurniture() throws SQLException {
    }
}
