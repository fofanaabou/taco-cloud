package com.example.tacos.domain;

public class TacoUDRUtils {

    public static IngredientUDT toIngredientUDT(Ingredient ingredient){
        return new IngredientUDT(ingredient.getType());
    }
}
