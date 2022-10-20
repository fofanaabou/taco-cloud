package com.example.tacos.application;

import com.example.tacos.domain.Ingredient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author AFO
 * @Date 20/10/2022
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationClient {

    private final RestTemplate restTemplate;

    public Ingredient getIngredientByIdWithGetForObject(String ingredientId) {

        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI url = UriComponentsBuilder.fromHttpUrl("http:localhost:8080/ingredients/{id}").build(urlVariables);
        return restTemplate.getForObject(url, Ingredient.class);
    }

    public Ingredient getIngredientByIdWithGetForEntity(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity = restTemplate
                .getForEntity("http:localhost:8080/ingredients/{id}", Ingredient.class, ingredientId);
        log.info("Fetched time:{}", responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    public void updateIngredient(Ingredient ingredient) {
        restTemplate.put("http:localhost:8080/ingredients/{id}", ingredient, ingredient.getId());
    }

    public void deleteIngredient(Ingredient ingredient) {
        restTemplate.delete("http:localhost:8080/ingredients/{id}",ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity = restTemplate.postForEntity("http:localhost:8080/ingredients", ingredient, Ingredient.class );
        return responseEntity.getBody();
    }
}
