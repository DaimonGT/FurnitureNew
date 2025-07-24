package by.bogdanov.factory;

import by.bogdanov.model.Furniture;
import by.bogdanov.model.Type;

import java.util.Random;

public class FurnitureFactory {
    private static final String[] MATERIALS = {"Дерево", "Металл", "Пластик", "Кожа", "Ткань", "Стекло"};
    private static final String[] COLORS = {"Красный", "Синий", "Зелёный", "Белый", "Чёрный", "Коричневый", "Серый"};
    private final Random random;

    public FurnitureFactory(Random random) {
        this.random = random;
    }

    public Furniture createRandomFurniture(int id) {
        Type type = generateRandomType();
        String material = MATERIALS[random.nextInt(MATERIALS.length)];
        String color = COLORS[random.nextInt(COLORS.length)];
        int price = random.nextInt(1000, 50000);

        return new Furniture(id, type, material, price, color);
    }

    private Type generateRandomType() {
        Type[] types = Type.values();
        return types[random.nextInt(types.length)];
    }
}
