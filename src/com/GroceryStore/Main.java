package com.GroceryStore;

import com.GroceryStore.Products.Drink;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Products.Fruit;

public class Main {
    public static void main(String[] args) {
        Product prod = new Fruit("p-001", "Apple", 89,
                "Red Apple", 5, true);
        Product prod2 = new Fruit("p-002", "Orange", 4_99, "Blood Orange", 4);
        Product prod3 = new Drink("d-001", "Whole Milk", 4_00, "Whole Milk",
                1, "Gal");
        Drink prod4 = new Drink("d-001", "Orange Juice", 4_99, "With Pulp", 2
                , 5);

        System.out.println(prod);
        System.out.println(prod3);
        System.out.println(prod4);

        Store store = new Store("test");
        store.addToInventory("d-005", "Coke", 1_99, "Coca Cola", 2, "litres");
        System.out.println(store.getInventory());
        store.addToInventory("p-008", "Mango", 2_99, "International Mango", 5
                , true);
        System.out.println(store.getInventory());

    }
}
