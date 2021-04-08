package se.groceriesstore.demo.models.dto;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "users")
public class UserDTO {

    private String name;
    @Id
    private String email;
    private Date birthday;
    private String password;

    public UserDTO(Integer id, String name, String email, Date birthday, String password) {

        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
    }

    public UserDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
