package com.example.tacos.domain;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED,force = true)
@AllArgsConstructor
@Entity
public class Ingredient  {

    @Id
    private  String id;
    private  String name;
    private  Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
