package com.example.KarDan;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Basket {
    private String owner;
    private Map<String, Item> inBasket;

    public Basket(String owner) {
        this.owner = owner;
        this.inBasket = new LinkedHashMap<>();
    }

    public boolean addToBasket(Item item, int quantity, Map<String, Item> availableStock) {
        if (item != null && quantity > 0
                && availableStock != null
                && availableStock.containsValue(item)
                && availableStock.get(item.getItemName()).getItemQuantity() >= quantity
        ) {
            availableStock.get(item.getItemName()).changeQuantity(-quantity);
            if (this.inBasket.containsKey(item.getItemName())) {
                quantity += this.inBasket.get(item.getItemName()).getItemQuantity();
            }
            Item tempItem = new Item(item.getItemName(),item.getPriceOfItem(),quantity);
            this.inBasket.put(item.getItemName(), tempItem);
            return true;
        }
        System.out.println("Sorry, no such item found, quantity equals zero or not enough of the product.");
        return false;
    }
    public boolean removeFromBasket(Item item) {
        if (item != null && this.inBasket.containsKey(item.getItemName())) {
            this.inBasket.remove(item.getItemName());
            return true;
        }
        return false;
    }
    public void showBasketContent() {
        System.out.println("In " + this.owner + "'s basket:" +
                "\nITEM --- AMOUNT --- PRICE TOTAL");
        for (Map.Entry<String, Item> item : this.inBasket.entrySet()) {
            String priceTotal = String.format("%.2f",item.getValue().getItemQuantity() * item.getValue().getPriceOfItem()); //formatting to 2 decimal points
            System.out.println(item.getKey() + " --- " + item.getValue().getItemQuantity() +
                    " ------- " + priceTotal);
        }
    }
    public boolean checkOut(Map<String, Item> storeStock) {
        return false;
    }
}
