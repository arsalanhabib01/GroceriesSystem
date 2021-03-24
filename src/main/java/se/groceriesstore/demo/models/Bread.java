package se.groceriesstore.demo.models;

public class Bread extends Product{
    private String name;
    private int price;

    public Bread() {
        super();
    }

    public Bread(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
