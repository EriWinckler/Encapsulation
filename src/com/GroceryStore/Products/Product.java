package com.GroceryStore.Products;

import java.text.NumberFormat;

public class Product {
    private String id;
    private String name;
    private int price;
    private String description;

    public Product(String id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    private String getDisplayPrice() {
        return NumberFormat.getCurrencyInstance().format(price / 100.0);
    }

    @Override
    public String toString() {
        String output =
                "id " + id + " | name: " + name + " | price: " + getDisplayPrice() + " | ";
        return output;
    }
}
