package com.groceryStore.products;

public class Fruit extends Product {
    private String type;
    private String supplier;
    private boolean isOrganic;
    private int hardness;

    public Fruit(String id, String name, int price, String description,
                 int hardness) {
        super(id, name, price, description);
        isOrganic = false;
        this.hardness = hardness;
    }

    //Overload
    public Fruit(String id, String name, int price, String description,
                 int hardness, boolean isOrganic) {
        super(id, name, price, description);
        this.isOrganic = isOrganic;
        this.hardness = hardness;
    }

    public int getHardness() {
        return hardness;
    }

    public String toString() {
        return super.toString() + "Is Organic: " + isOrganic + " | hardness: " + hardness;
    }
}
