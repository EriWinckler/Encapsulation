package com.GroceryStore;
import com.GroceryStore.Products.Drink;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> Inventory = new ArrayList<>();
    private int balance = 500_00;
    private String name;

    public Store(String name) {
        this.name = name;
    }

    // TODO add the given product to the collection
    public void addToInventory(Product product) {
        Inventory.add(product);
    }

    // TODO: Drink version
    public void addToInventory() {
        Drink drink = new Drink();
        addToInventory(drink);
    }

    // TODO: Fruit version
    public void addToInventory() {
        Fruit fruit = new Fruit(super);
        addToInventory(fruit);
    }
}
