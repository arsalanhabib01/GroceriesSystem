package se.groceriesstore.demo.models;

import java.util.UUID;

public class Bread extends Product{
    private String name;
    private int price;

    public Bread() {
        super();
    }

    public Bread(UUID id, String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
