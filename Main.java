package com.example.KarDan;

public class Main {

    public static void main(String[] args) {
        //available products
        Item banana = new Item("banana",0.50);
        Item apple = new Item("apple", 0.35);
        Item pear = new Item("pear",0.70);
        Item lemon = new Item("lemon",0.90);
        Item someKindOfFruit = new Item("apple",0.70);

        Stockroom storeStockroom = new Stockroom();
        storeStockroom.addItemToStock(banana,10);
        storeStockroom.addItemToStock(apple,15);
        storeStockroom.addItemToStock(pear,20);
        storeStockroom.addItemToStock(lemon,80);
        storeStockroom.addItemToStock(lemon,100);
        storeStockroom.addItemToStock(someKindOfFruit,50);

        storeStockroom.removeItemFromStock(lemon);

        storeStockroom.printoutStockList();



    }
}
