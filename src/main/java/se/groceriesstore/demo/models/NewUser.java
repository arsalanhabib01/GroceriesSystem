package se.groceriesstore.demo.models;

import java.util.Date;

public class NewUser {

    String name;
    Date date;
    String Address;
    String email;
    String password;

    public NewUser(String name, Date date, String address, String email, String password) {
        this.name = name;
        this.date = date;
        this.Address = address;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
