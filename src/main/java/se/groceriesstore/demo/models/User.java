package se.groceriesstore.demo.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
public class User {
    String name;
    String email;
    Date birthday;
    String address;
    public User(@JsonProperty("name") String name,
                @JsonProperty("email") String email,
                @JsonProperty("birthday") Date birthday,
                @JsonProperty("address") String address) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}