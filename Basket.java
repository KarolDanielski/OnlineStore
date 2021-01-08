package com.example.KarDan;

import java.util.LinkedHashMap;
import java.util.Map;

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
        double totalInBasket = 0;
        for (Map.Entry<String, Item> item : this.inBasket.entrySet()) {
            if (item.getValue() != null) {
                double sumTotalPerItem = item.getValue().getItemQuantity() * item.getValue().getPriceOfItem();
                String priceTotal = String.format("%.2f",sumTotalPerItem); //formatting to 2 decimal points
                System.out.println(item.getKey() + " --- " + item.getValue().getItemQuantity() +
                        " ------- " + priceTotal);
                totalInBasket += sumTotalPerItem;
            }
        }
        String s = String.format("%.2f",totalInBasket);
        System.out.println("=======================================" +
                "\nTOTAL: " + s + "$");
    }
    public void checkOut(Map<String, Item> storeStock) {
        for (Map.Entry<String, Item> entryInBasket : this.inBasket.entrySet()) {
            Item inBasketItem = entryInBasket.getValue();
            int inBasketQuantity = inBasketItem.getItemQuantity();
            if (storeStock.containsKey(entryInBasket.getKey())
                    && storeStock.get(entryInBasket.getKey()).getItemQuantity() >= entryInBasket.getValue().getItemQuantity())
            {
                storeStock.get(entryInBasket.getKey()).changeQuantity(-inBasketQuantity);
            } else {
                System.out.println("Sorry, but the stock of " + entryInBasket.getKey() + " has changed in the meantime. " +
                        "We were not able to handle your request and the item wasn't bought.");
                entryInBasket.setValue(null);
            }
        }
        showBasketContent();
        System.out.println("Your items has been bought!");
        this.inBasket.clear();
    }
}
