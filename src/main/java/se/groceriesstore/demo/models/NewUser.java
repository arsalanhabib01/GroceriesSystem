package se.groceriesstore.demo.models;

import java.util.Date;

public class NewUser {

    String name;
    Date date;
    String Address;
    String username;
    String password;

    public NewUser(String name, Date date, String address, String username, String password) {
        this.name = name;
        this.date = date;
        this.Address = address;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
