package com.example.tacos.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class Taco {

    @Id
    private Long id;

    private Date createdAt = new Date();

    @NonNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NonNull
    @Size(min = 5, message = "You must choose at least 1 ingredient")
    @ToString.Exclude
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

}
