package com.example.KarDan;

import java.util.Objects;

public class Item implements Comparable<Item>{
    private String itemName;
    private int quantity;
    private double priceOfItem;

    public Item(String itemName, double priceOfItem) {
        this.itemName = itemName;
        this.quantity = 0;
        this.priceOfItem = priceOfItem;
    }

    public int getItemQuantity() {
        return this.quantity;
    }
    public String getItemName() {
        return this.itemName;
    }
    public double getPriceOfItem() {
        return this.priceOfItem;
    }

    public boolean changeQuantity(int quantity) {
        if ((this.quantity + quantity) < 0) {
            System.out.println("Not enough " + this.itemName + "s in stock to perform this operation!" +
                    "\nCurrent quantity: " + this.quantity);
            return false;
        } else {
            this.quantity += quantity;
            return true;
        }
    }

    @Override
    public int compareTo(Item item) {
        if (item != null) {
            return this.itemName.compareTo(item.getItemName());
        }
        throw  new NullPointerException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.priceOfItem, priceOfItem) == 0 &&
                Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, priceOfItem);
    }
}
