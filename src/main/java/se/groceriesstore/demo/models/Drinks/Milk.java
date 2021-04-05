package se.groceriesstore.demo.models.Drinks;

import com.fasterxml.jackson.annotation.JsonProperty;
import se.groceriesstore.demo.models.Drink;

public class Milk extends Drink {
    private Integer id;
    private String name;
    private int price;
    private String image;
    private String volume;

    public Milk() {
        super();
    }

    public Milk(@JsonProperty("id") Integer id,
                @JsonProperty("name") String name,
                @JsonProperty("price") int price,
                @JsonProperty("image") String image,
                @JsonProperty("volume") String volume) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.volume = volume;
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

    public String getImage() {
        return image;
    }

    public String getVolume() {
        return volume;
    }
}
