package se.groceriesstore.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Cart extends Product{
    private Integer id;
    private int order_id;
    private String product_name;
    private int product_id;
    private int amount;


    public Cart() {
        super();
    }


    public Cart(@JsonProperty("id") Integer id,
                @JsonProperty("order_id") Integer order_id,
                @JsonProperty("product_name") String product_name,
                @JsonProperty("product_id") Integer product_id,
                @JsonProperty("amount") Integer amount)
    {
        this.id = id;
        this.order_id = order_id;
        this.product_name = product_name;
        this.product_id = product_id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getAmount() {
        return amount;
    }
}
