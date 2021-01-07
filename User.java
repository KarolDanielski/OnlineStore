package com.example.KarDan;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private Basket userBasket;

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userBasket = new Basket(this.firstName + this.lastName);
    }
}
