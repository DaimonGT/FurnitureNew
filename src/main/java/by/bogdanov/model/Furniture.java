package by.bogdanov.model;

public class Furniture {
    private final int id;
    private Type type;
    private final String material;
    private final int price;
    private final String color;

    public Furniture(int id, Type type, String material, int price, String color) {
        this.id = id;
        this.type = type;
        this.material = material;
        this.price = price;
        this.color = color;
    }


    public int getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Material: " + material + " Color: " + " Price: " + price;
    }
}
