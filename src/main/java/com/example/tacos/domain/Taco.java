package com.example.tacos.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Table
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
    private List<IngredientRef> ingredients;
}
