package com.groceryStore;
import com.groceryStore.products.Drink;
import com.groceryStore.products.Fruit;
import com.groceryStore.products.Product;
import com.util.Formatter;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> Inventory = new ArrayList<>();
    private int balance = 500_00;
    private String name;

    public Store(String name) { this.name = name; }

    // TODO add the given product to the collection
    public void addToInventory(Product product) {
        if(product.getPrice() > balance) {
            System.out.println("Not enough funds");
            return;
        }
        balance -= product.getPrice();
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

    public void throwAway(Product product) {
        Inventory.remove(product);
    }

    public String getInventory() {
        String output = "";
        for(Product prod : Inventory) {
            output += prod + "\n";
        }
        return output;
    }

    public String getBalance() { return Formatter.getDisplayPrice(balance); }

    public String getName() { return name; }
}
