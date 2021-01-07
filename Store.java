package com.example.KarDan;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Store {
    private final Set<Item> stock;
    private Map<Integer, User> users;

    public Store() {
        this.stock = new TreeSet<>();
        this.users = new HashMap<>();
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
        for (Map.Entry<Integer,User> user : this.users.entrySet()) {
            System.out.println(user.getKey() + "---" + user.getValue());
        }
    }
    public boolean addItemToStock(Item item, int quantity ) {
        if (item != null) {
            item.changeQuantity(quantity);
            this.stock.add(item);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeItemFromStock(Item item) {
        if (item != null && this.stock.contains(item)) {
            this.stock.remove(item);
            return true;
        }
        return false;
    }

    public void printoutStockList() {
        System.out.println("NAME --- PRICE --- QUANTITY");
        for (Item item : this.stock) {
            System.out.println(item.getItemName() + "---" + item.getPriceOfItem() + "---" + item.getItemQuantity());
        }
    }

    public Set<Item> getStock() { //returns copy of store stock
        return new TreeSet<>(this.stock);
    }

}
