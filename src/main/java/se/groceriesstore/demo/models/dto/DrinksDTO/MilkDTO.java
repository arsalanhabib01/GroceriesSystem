package se.groceriesstore.demo.models.dto.DrinksDTO;

import javax.persistence.*;

@Entity
@Table(name = "milk")
public class MilkDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int price;
    private String name;


    public MilkDTO(Integer id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }


    public MilkDTO() {
    }

    public MilkDTO(String name, int price) {
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
