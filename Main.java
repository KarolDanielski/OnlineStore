package com.example.KarDan;

public class Main {

    public static void main(String[] args) {
        //available products
        Item banana = new Item("banana",0.50);
        Item apple = new Item("apple", 0.35);
        Item pear = new Item("pear",0.70);
        Item lemon = new Item("lemon",0.90);
        Item someKindOfFruit = new Item("apple",0.70);
        //setting up store, adding assortment
        Store fruitStore = new Store();
        fruitStore.addItemToStock(banana,10);
        fruitStore.addItemToStock(apple,15);
        fruitStore.addItemToStock(pear,20);
        fruitStore.addItemToStock(lemon,80);
        fruitStore.addItemToStock(lemon,100);
        fruitStore.addItemToStock(someKindOfFruit,50);

//        fruitStore.removeItemFromStock(lemon);

        fruitStore.printoutStockList();
        //sign up of users
        User userOne = new User("Jan", "Kowalski", "Jan1");
        User userTwo = new User("Katarzyna", "Kwasniewska", "Katarzyna2");
        User userThree = new User("Maciej", "Wrobel", "Maciej3");

        fruitStore.signIn(userOne);
        fruitStore.signIn(userTwo);
        fruitStore.signIn(userThree);
        fruitStore.printOutUsers();

        //reserving item in basket
        userOne.getUserBasket().addToBasket(apple, 20, fruitStore.getStockPool());
        userOne.getUserBasket().addToBasket(apple,5,fruitStore.getStockPool());
        userOne.getUserBasket().addToBasket(apple,100,fruitStore.getStockPool());
        userOne.getUserBasket().addToBasket(lemon,52,fruitStore.getStockPool());
        userThree.getUserBasket().addToBasket(pear,10,fruitStore.getStockPool());
        userThree.getUserBasket().addToBasket(banana,20,fruitStore.getStockPool());
        userThree.getUserBasket().addToBasket(apple,6,fruitStore.getStockPool());
        userOne.getUserBasket().showBasketContent();
        userThree.getUserBasket().showBasketContent();

        fruitStore.printoutStockList();
        fruitStore.printoutStockPoolList();

//        userOne.getUserBasket().checkOut(fruitStore.getStock());
//        userOne.checkOut();
//        System.out.println(fruitStore.getStock().containsValue(apple));



    }
}
