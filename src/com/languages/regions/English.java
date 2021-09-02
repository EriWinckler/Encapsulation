package com.languages.regions;

import com.languages.Languages;

public class English extends Languages {

    @Override
    public String[] menuText() {
        return new String[] {
                "1 - Add product to inventory",
                "2 - Throw away a product",
                "3 - list products available",
                "4 - Sell a product",
                "5 - Quit"
        };
    }

    @Override
    public String[] productTypesText() {
        return new String[] {
                "1 - Drink",
                "2 - Fruit"
        };
    }

    @Override
    public String welcomeText() {
        return "What would you like to do?";
    }

    @Override
    public String startPromptText() {
        return "Enter selection between 1 and 5:";
    }
}
