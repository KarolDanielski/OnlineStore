package com.example.KarDan;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Stockroom {
    private final Set<Item> stock;

    public Stockroom() {
        this.stock = new TreeSet<>();
    }

    public boolean addItemToStock(Item item, int quantity ) {
        if (item != null) {
            if (this.stock.contains(item)) {
                item.changeQuantity(quantity);
            }
            this.stock.add(item);
            return true;
        } else {
            return false;
        }
    }

    public void printoutStockList() {
        for (Item item : this.stock) {
            System.out.println("NAME --- PRICE --- QUANTITY");
            System.out.println(item.getItemName() + "---" + item.getPriceOfItem() + "---" + item.getItemQuantity());
        }
    }
}
