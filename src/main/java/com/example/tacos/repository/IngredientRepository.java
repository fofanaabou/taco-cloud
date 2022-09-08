package com.example.tacos.repository;

import com.example.tacos.domain.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
