package com.groceryStore.console;

import com.groceryStore.Store;
import com.groceryStore.products.Drink;
import com.groceryStore.products.Fruit;
import com.groceryStore.products.Product;

import java.util.Scanner;

public class UI {
    private static Scanner scan = new Scanner(System.in);
    private Store store;

    public final static String [] MENU = new String[] {
            "1 - Add product to inventory",
            "2 - Throw away a product",
            "3 - list products available",
            "4 - Sell a product",
            "5 - Quit"
    };

    public final static String[] PRODUCT_TYPES = new String[] {
            "1 - Drink",
            "2 - Fruit"
    };

    public static void welcome(String name) {
        System.out.println("Welcome to " + name + "!");
    }

    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for(String option : options) {
            System.out.println(option);
        }
    }

    public static void start(Store store) {
        welcome(store.getName());
        displayOptions("What would you like to do?", MENU);
        int choice = getInt(1, 5, "Enter selection between 1 and 5:");
        handleMenuSelection(choice);
    }

    public static int getInt(int min, int max, String prompt) {
        int option = 0;
        do {
            System.out.println(prompt);
            String input = scan.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println(e);
                option = min--;
            }

        } while (option < min || option > max);
        return option;
    }

    public static String getString(String prompt, boolean isRequired) {
        String input;

        do{
            System.out.println(prompt);
            input = scan.nextLine();
            if(isRequired && input.length() == 0) {
                System.out.println("Must enter something");
                continue;
            }
            break;
        } while(true);
        return input;
    }

    public static void handleMenuSelection(int choice) {
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> throwAwayProduct();
            case 3 -> displayProducts();
            case 4 -> sellProduct();
            case 5 -> System.exit(0);
            default -> System.out.println("Invalid number received");
        }
    }

    public void addProduct() {
        displayOptions("What kind of procuts?", PRODUCT_TYPES);
        int choice = getInt(1, PRODUCT_TYPES.length, "enter a value");
        Product newProduct;
        switch (choice) {
            case 1 -> newProduct = getDrinkDetails();
            //TODO getFruitDetails
            case 2 -> newProduct = getFruitDetails();
            default -> {
                System.out.println("error bad type");
                newProduct = null;
            }
        }
        store.addToInventory(newProduct);
    }

    public static Drink getDrinkDetails() {
        return new Drink(
                getString("Id: ", true),
                getString("Drink Name", true),
                getInt(1, Integer.MAX_VALUE, "Price?"),
                getString("Description: ", false),
                getInt(1, Integer.MAX_VALUE, "Volume"),
                getInt( 0, Drink.UNITS.length - 1, "Volume Unit")
        );
    }

    public static Fruit getFruitDetails() {
        return new Fruit(
                getString("Id: ", true),
                getString("Fruit Name", true),
                getInt(1, Integer.MAX_VALUE, "Price?"),
                getString("Description: ", false),
                getInt(1, Integer.MAX_VALUE, "Hardness"),
                getInt( 0, Drink.UNITS.length - 1, "Volume Unit")
        );
    }
    String id, String name, int price, String description,
    int hardness, boolean isOrganic

    public void throwAwayProduct() {
        Product prod = selectProduct("With product id to throw away? press " +
                "enter to cancel");
        if(prod == null) {
            System.out.println("404 - Product not Found");
            return;
        }
        store.throwAway(prod);
    }

    public void displayProducts() {
        System.out.println(store.getInventory());
    }

    private Product selectProduct(String prompt) {
        displayProducts();
        String choice = getString(prompt, false);
        return store.getProduct(choice);
    }



    public void sellProduct() {
        Product prod = selectProduct("With product id to purchase? press " +
                "enter to cancel");
        if(prod == null) {
            System.out.println("404 - Product not Found");
            return;
        }
        store.purchase(prod);
    }
}
