package com.example.KarDan;

import java.util.*;

public class Store {
    private final Map<String, Item> stock;
    private Map<String, Item> unreservedItems;
    private Map<Integer, User> users;

    public Store() {
        this.stock = new TreeMap<>();
        this.users = new HashMap<>();
        this.unreservedItems = new TreeMap<>(this.stock);
    }

    public boolean signIn(User user) {
        if (user != null) {
            this.users.put(User.getUserID(), user);
            User.incrementUserID();
            return true;
        }
        return false;
    }
    public void printOutUsers() {
        System.out.println("----------------------------------------" +
                "\nUsers list:" +
                "\nID---First & Last name");
        for (Map.Entry<Integer,User> user : this.users.entrySet()) {
            System.out.println(user.getKey() + "---" + user.getValue());
        }
    }
    public boolean addItemToStock(Item item, int quantity ) {
        if (item != null) {
            item.changeQuantity(quantity);
            this.stock.put(item.getItemName(), item);
            this.unreservedItems.put(item.getItemName(), item); //updating user available item pool
//            System.out.println("adding");
            return true;
        } else {
            return false;
        }
    }

    public boolean removeItemFromStock(Item item) {
        if (item != null && this.stock.containsValue(item)) {
            this.stock.remove(item.getItemName());
            return true;
        }
        return false;
    }

    public void printoutStockList() {
        System.out.println("NAME --- PRICE --- QUANTITY");
        for (Map.Entry<String, Item> item : this.unreservedItems.entrySet()) {
            System.out.println(item.getValue().getItemName() + "---" + item.getValue().getPriceOfItem() + "---" + item.getValue().getItemQuantity());
        }
    }

    public Map<String, Item> getStock() { //returns copy of store stock
        return this.unreservedItems;
    }


}
