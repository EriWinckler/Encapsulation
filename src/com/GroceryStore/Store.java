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

    public List<Product> getInventory() {
        return Inventory;
    }

    public Store(String name) { this.name = name; }

    // TODO add the given product to the collection
    public void addToInventory(Product product) {
        Inventory.add(product);
    }

    // TODO: Drink version
    public void addToInventory(String id, String name, int price,
                               String description, int volume, String volumeUnit) {
        Drink drink = new Drink(id, name, price, description, volume,
                volumeUnit);
        addToInventory(drink);
    }

    public void addToInventory(String id, String name, int price,
                               String description, int volume, int volumeUnit) {
        Drink drink = new Drink(id, name, price, description, volume,
                volumeUnit);
        addToInventory(drink);
    }

    // TODO: Fruit version
    public void addToInventory(String id, String name, int price, String description,
                               int hardness) {
        Fruit fruit = new Fruit(id, name, price, description, hardness);
        addToInventory(fruit);
    }

    public void addToInventory(String id, String name, int price, String description,
                               int hardness, boolean isOrganic) {
        Fruit fruit = new Fruit(id, name, price, description, hardness, isOrganic);
        addToInventory(fruit);
    }
}
