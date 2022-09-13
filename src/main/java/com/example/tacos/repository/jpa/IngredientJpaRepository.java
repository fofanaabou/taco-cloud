package com.example.tacos.repository.jpa;

import com.example.tacos.domain.Ingredient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface IngredientJpaRepository extends CrudRepository<Ingredient, String> {
}
