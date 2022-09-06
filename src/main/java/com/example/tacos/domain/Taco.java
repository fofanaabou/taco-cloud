package com.example.tacos.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Taco {

    private Long id;

    private Date createdAt = new Date();

    @NonNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NonNull
    @Size(min = 5, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
