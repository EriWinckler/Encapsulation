package com.GroceryStore.Products;

public class Drink extends Product {
    public final static String [] UNITS = new String[]{"Gal", "oz",
            "litres", "ml", "pint", "quart"};

    private int volume;
    private String volumeUnit;

    public Drink(String id, String name, int price, String description,
                 int volume, String volumeUnit) {
        super(id, name, price, description);
        this.volume = volume;
        this.volumeUnit = volumeUnit;
    }

    //Overload
    public Drink(String id, String name, int price, String description,
                 int volume, int volumeUnit) {
        super(id, name, price, description);
        this.volume = volume;
        this.volumeUnit = UNITS[volumeUnit];
    }

    public String toString() {
        return super.toString() + "Volume: " + volume + " " + volumeUnit;
    }
}
