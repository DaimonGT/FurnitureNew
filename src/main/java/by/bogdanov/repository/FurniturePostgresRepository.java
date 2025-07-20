package by.bogdanov.repository;

import by.bogdanov.model.Furniture;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FurniturePostgresRepository {
    public void addFurniture(Furniture furniture) throws SQLException {
        String sql = "INSERT INTO furnitures (type, material, price, color) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, material);
            preparedStatement.setInt(3, price);
            preparedStatement.executeUpdate();
        }
    }
}

