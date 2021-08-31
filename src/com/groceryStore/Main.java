package com.groceryStore;

public class Main {
    public static void main(String[] args) {

        Store store = new Store("Eri's Store");

        store.addToInventory("p-001", "Apple", 89,
                "Red Apple", 5, true);
        store.addToInventory("p-002", "Orange", 4_99, "Blood Orange", 4);
        store.addToInventory("d-001", "Whole Milk", 4_00, "Whole Milk",
                1, "Gal");
        store.addToInventory("d-001", "Orange Juice", 4_99, "With Pulp", 2
                , 5);


        System.out.println(store.getInventory());

    }
}
