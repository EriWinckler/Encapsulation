package com.GroceryStore.Products;

public class Drink extends Product {
    public final static String [] UNITS = new String[]{"Gal", "oz",
            "litres", "ml", "pint", "quart"};
            //UNITS tem que ser maiusculo para dizer que e final para outros
            // coders
    //final can only be accessed, shortcut for a type of private item becouse
    // you can only access the value not needing a getter;
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
