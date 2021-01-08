package com.example.KarDan;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private Basket userBasket;
    private static int userID = 0;

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userBasket = new Basket(this.firstName + " " + this.lastName);
    }

    public Basket getUserBasket() {
        return  this.userBasket;
    }

    public static int getUserID() {
        return userID;
    }
    public static void incrementUserID() {
        userID++;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
