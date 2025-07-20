package by.bogdanov.service;

import by.bogdanov.model.Type;
import by.bogdanov.repository.FurniturePostgresRepository;

import java.sql.SQLException;

public class FurniturePostgresService {
    private final FurniturePostgresRepository furniturePostgresRepository;

    public FurniturePostgresService(FurniturePostgresRepository furniturePostgresRepository) {
        this.furniturePostgresRepository = furniturePostgresRepository;
    }

    public void addFurniture() throws SQLException {
        }
}
