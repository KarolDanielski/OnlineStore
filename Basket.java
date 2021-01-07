package com.example.KarDan;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Basket {
    private String owner;
    private Set<Item> inBasket;

    public Basket(String owner) {
        this.owner = owner;
        this.inBasket = new LinkedHashSet<>();
    }

    public boolean addToBasket(Item item, int quantity, Map<String, Item> availableStock) {
        if (item != null && quantity > 0 && availableStock != null
                && availableStock.containsValue(item)
                && availableStock.get(item.getItemName()).getItemQuantity() >= quantity
        ) {
            Item tempItem = new Item(item.getItemName(),item.getPriceOfItem(),quantity);
            this.inBasket.add(tempItem);
            return true;
        }
        System.out.println("Sorry, no such item found or not enough of the product.");
        return false;
    }
    public void showBasketContent() {
        System.out.println("In " + this.owner + "'s basket:" +
                "\nITEM --- AMOUNT --- PRICE TOTAL");
        for (Item item : this.inBasket) {
            System.out.println(item.getItemName() + " --- " + item.getItemQuantity() +
                    " ------- " + item.getItemQuantity() * item.getPriceOfItem());
        }
    }
}
