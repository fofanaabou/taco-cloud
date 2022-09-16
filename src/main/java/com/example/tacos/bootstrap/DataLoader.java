package com.example.tacos.bootstrap;

import com.example.tacos.domain.Ingredient;
import com.example.tacos.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final IngredientRepository ingredientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadData();
    }

    @Transactional
    void loadData() {

        List<Ingredient> ingredients = List.of(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
        new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
        new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
        new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
        new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
        new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
        new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
        new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
        new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
        new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));

        ingredientRepository.saveAll(ingredients);
    }
}
