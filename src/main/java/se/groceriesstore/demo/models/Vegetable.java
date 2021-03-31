package se.groceriesstore.demo.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Vegetable extends Product{
    private Integer id;
    private String name;
    private int price;

    public Vegetable(){
        super();
    }

    public Vegetable(@JsonProperty("id") Integer id,
                     @JsonProperty("name") String name,
                     @JsonProperty("price") int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

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
