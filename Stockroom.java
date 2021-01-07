package com.example.KarDan;

import java.util.Set;
import java.util.TreeSet;

public class Stockroom{
    private final Set<Item> stock;

    public Stockroom() {
        this.stock = new TreeSet<>();
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

}
