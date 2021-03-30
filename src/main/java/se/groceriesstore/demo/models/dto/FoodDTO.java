package se.groceriesstore.demo.models.dto;

import java.util.UUID;

@Entity
@Table (name = "products")
public class FoodDTO {

    public FoodDTO() {
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public FoodDTO(UUID id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String type;
    private String name;
}
