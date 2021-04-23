package se.groceriesstore.demo.models.dto;
import javax.persistence.*;

@Entity
@Table(name = "orders")

public class OrderDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private int customer_id;
        private String time;
        private String date;
        private String status;

    public OrderDTO(Integer id, int customer_id, String time, String date, String status) {
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

    public OrderDTO() {
    }

}
