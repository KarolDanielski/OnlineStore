package com.example.KarDan;

import java.util.LinkedHashSet;
import java.util.Set;

public class Basket {
    private String owner;
    private Set<Item> inBasket;

    public Basket(String owner) {
        this.owner = owner;
        this.inBasket = new LinkedHashSet<>();
    }
}
