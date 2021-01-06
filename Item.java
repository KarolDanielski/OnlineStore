package com.example.KarDan;

public class Item {
    private String itemName;
    private int quantity;
    private double priceOfItem;

    public Item(String itemName, int quantity, double priceOfItem) {
        this.itemName = itemName;
        this.quantity = quantity;
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
        if (this.quantity < quantity) {
            System.out.println("Not enough " + this.itemName + "s in stock to perform this operation!" +
                    "\n Current quantity: " + this.quantity);
            return false;
        } else {
            this.quantity += quantity;
            return true;
        }
    }
}
