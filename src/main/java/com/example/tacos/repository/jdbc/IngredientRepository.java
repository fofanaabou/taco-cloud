package com.example.tacos.repository.jdbc;

import com.example.tacos.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
