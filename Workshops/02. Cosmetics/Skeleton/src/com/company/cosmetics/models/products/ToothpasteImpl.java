package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {
    private List<String> ingredients;
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        if(ingredients == null){
            throw new IllegalArgumentException("Ingreadients list cannot be null");
        }
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public String print() {
        String str = String.format("#%s %s%n #Price: $%.2f%n #Gender: %s%n #Ingredients: [%s]%n ===",
                super.getName(),
                super.getBrand(),
                super.getPrice(),
                super.getGender(),
                String.join(",", ingredients)
        );
        return str;
    }
    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(this.ingredients);
    }
}
