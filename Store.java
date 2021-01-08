package com.example.KarDan;

import java.util.*;

public class Store {
    private final Map<String, Item> stock;
    private Map<String, Item> unreservedItems;
    private Map<Integer, User> users;

    public Store() {
        this.stock = new TreeMap<>();
        this.users = new HashMap<>();
        this.unreservedItems = new TreeMap<>();
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
            Item copyItem = new Item(item.getItemName(),item.getPriceOfItem(),item.getItemQuantity()); //new instance of item with old item details
            this.unreservedItems.put(copyItem.getItemName(), copyItem); //updating user available item pool
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

    public void printoutStockPoolList() {
        System.out.println("===STOCK POOL LIST===" +
                "\nNAME --- PRICE --- QUANTITY");
        for (Map.Entry<String, Item> item : this.unreservedItems.entrySet()) {
            System.out.println(item.getValue().getItemName() + "---" + item.getValue().getPriceOfItem() + "---" + item.getValue().getItemQuantity());
        }
    }
    public void printoutStockList() {
        System.out.println("===STOCK LIST===" +
                "\nNAME --- PRICE --- QUANTITY");
        for (Map.Entry<String, Item> item : this.stock.entrySet()) {
            System.out.println(item.getValue().getItemName() + "---" + item.getValue().getPriceOfItem() + "---" + item.getValue().getItemQuantity());
        }
    }

    public Map<String, Item> getStockPool() { //returns copy of store stock
        return this.unreservedItems;
    }
    public Map<String, Item> getStock() { //returns store stock
        return this.stock;
    }


}
