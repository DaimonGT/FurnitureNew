package by.bogdanov.service;

import by.bogdanov.model.Furniture;
import by.bogdanov.model.Type;
import by.bogdanov.repository.FurnitureMongoRepository;

import javax.inject.Inject;

public class FurnitureMongoService {
    private final FurnitureMongoRepository furnitureMongoRepository;
    @Inject
    public FurnitureMongoService(FurnitureMongoRepository furnitureMongoRepository){
        this.furnitureMongoRepository = furnitureMongoRepository;
    }

    public void addFurniture(int id,
                             Type type,
                             String material,
                             int price,
                             String color){
        Furniture furniture = new Furniture(id, type, material, price, color);
        furnitureMongoRepository.addFurniture(furniture);
    }
}
