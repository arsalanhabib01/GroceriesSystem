package se.groceriesstore.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Bread extends Product{
    private UUID id;
    private String name;
    private int price;

    public Bread() {
        super();
    }


    public Bread(@JsonProperty("id") UUID id,
                 @JsonProperty("name") String name,
                 @JsonProperty("price") int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

//    @Override
  //  public void setName(String name) {
    //    this.name = name;
   // }

    @Override
    public int getPrice() {
        return price;
    }

    //@Override
    //public void setPrice(int price) {
    //    this.price = price;
    //}
}
