package se.groceriesstore.demo.models.Drinks;

import com.fasterxml.jackson.annotation.JsonProperty;
import se.groceriesstore.demo.models.Drink;

public class Soda extends Drink {
    private Integer id;
    private String name;
    private int price;

    public Soda() {
        super();
    }

    public Soda(@JsonProperty("id") Integer id,
                @JsonProperty("name") String name,
                @JsonProperty("price") int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
