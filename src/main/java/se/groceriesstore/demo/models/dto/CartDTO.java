package se.groceriesstore.demo.models.dto;
import javax.persistence.*;

@Entity
@Table(name = "carts")

public class CartDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private int order_id;
        private String product_name;
        private int product_id;
        private int amount;

    public CartDTO(Integer id, int order_id, String product_name, int product_id, int amount) {
        this.id = id;
        this.order_id = order_id;
        this.product_name = product_name;
        this.product_id = product_id;
        this.amount = amount;
    }

    public CartDTO() {
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
