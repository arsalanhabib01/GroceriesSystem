package se.groceriesstore.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Order extends Product{
    private Integer id;
    private int customer_id;
    private String time;
    private String date;
    private String status;


    public Order() {
        super();
    }


    public Order(@JsonProperty("id") Integer id,
                 @JsonProperty("customer_id") Integer customer_id,
                 @JsonProperty("time") String time,
                 @JsonProperty("date") String date,
                 @JsonProperty("status") String status)
    {
        this.id = id;
        this.customer_id = customer_id;
        this.time = time;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
