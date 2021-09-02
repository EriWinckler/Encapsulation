package com.groceryStore.console;

import com.groceryStore.Store;
import com.groceryStore.products.Drink;
import com.groceryStore.products.Fruit;
import com.groceryStore.products.Product;
import com.languages.Languages;
import com.languages.regions.English;
import com.languages.regions.Portuguese;

import java.util.Scanner;

public class UI {
    private static Scanner scan = new Scanner(System.in);
    private Store store;
    private Languages languageChoice = new English();

    public void welcome(String name) {
        System.out.println("Welcome to " + name + "!");
        System.out.println("Please select your language: | Por favor selecione a sua linguagem:");
        System.out.println("English or/ou Portuguese");
        String lang = scan.nextLine().toLowerCase();
        languageChoice = languageSelector(lang);
    }

    public Languages languageSelector(String language) {
        switch(language) {
            case "english":
                return languageChoice = new English();
            case "portuguese":
                return languageChoice = new Portuguese();
            default:
                System.out.println("Invalid choice, please try again");
        }
        return null;
    }

    public final String [] MENU = languageChoice.menuText();

    public final String[] PRODUCT_TYPES = languageChoice.productTypesText();



    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for(String option : options) {
            System.out.println(option);
        }
    }

    public void start(Store store) {
        this.store = store;
        welcome(store.getName());
        displayOptions(languageChoice.welcomeText(), MENU);
        int choice = getInt(1, 5, languageChoice.startPromptText());
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

    public static boolean getBoolean(String prompt, boolean isOrganic) {
        String option;
        do {
            System.out.println(prompt + " 1 - True | 2 - False.");
            option = scan.nextLine();
            switch (option) {
                case "1" -> isOrganic = true;
                case "2" -> isOrganic = false;
                default -> System.out.println("Invalid choice, try again.");
            }
            break;
        } while (true);
        return isOrganic;
    }

    public void handleMenuSelection(int choice) {
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
                getBoolean("Is it organic?", false)
        );
    }

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
