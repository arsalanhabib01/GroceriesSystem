package se.groceriesstore.demo.models.dto;

import javax.persistence.*;

@Entity
@Table(name = "vegetables")
public class VegetableDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int price;
    private String name;


    public VegetableDTO(Integer id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }


    public VegetableDTO() {
    }

    public VegetableDTO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
