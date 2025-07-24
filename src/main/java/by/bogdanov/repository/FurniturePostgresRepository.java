package by.bogdanov.repository;

import by.bogdanov.model.Furniture;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FurniturePostgresRepository {

    private final Connection connection;

    @Inject
    public FurniturePostgresRepository(Connection connection) {
        this.connection = connection;
    }

    public void addFurniture(Furniture furniture) throws SQLException {
        String sql = "INSERT INTO furnitures (type, material, price, color) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, furniture.getType().name());
            preparedStatement.setString(2, furniture.getMaterial());
            preparedStatement.setInt(3, furniture.getPrice());
            preparedStatement.executeUpdate();
        }
    }

    public void addAllFurniture(List<Furniture> listFurniture) throws SQLException{
        String sql = "INSERT INTO furnitures (type, material, price, color) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (Furniture furniture: listFurniture){
                preparedStatement.setString(1, furniture.getType().name());
                preparedStatement.setString(2, furniture.getMaterial());
                preparedStatement.setInt(3, furniture.getPrice());
                preparedStatement.setString(3, furniture.getColor());
                preparedStatement.addBatch();
            }
            preparedStatement.executeUpdate();
        }
    }

    public List<Furniture> findByMaterial(String material)

}

