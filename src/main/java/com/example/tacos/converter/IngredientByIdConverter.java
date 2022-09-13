package com.example.tacos.converter;

import com.example.tacos.domain.Ingredient;
import com.example.tacos.repository.jpa.IngredientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientJpaRepository ingredientJpaRepository;


    @Override
    public Ingredient convert(String id) {
        return ingredientJpaRepository.findById(id).orElse(null);
    }

}
