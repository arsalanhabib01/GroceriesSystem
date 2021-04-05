package se.groceriesstore.demo.models.dto.DrinksDTO;

import javax.persistence.*;

@Entity
@Table(name = "kaffes")
public class KaffeDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int price;
    private String name;
    private String image;
    private String volume;


    public KaffeDTO(Integer id, int price, String name, String image, String volume) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.image = image;
        this.volume = volume;
    }


    public KaffeDTO() {
    }

    public KaffeDTO(String name, int price, String image, String volume) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.volume = volume;
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

    public String getImage() {
        return image;
    }

    public String getVolume() {
        return volume;
    }
}
