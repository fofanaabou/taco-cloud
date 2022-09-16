package com.example.tacos.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@ToString
@Table("ingredient")
@NoArgsConstructor(access = AccessLevel.PROTECTED,force = true)
@AllArgsConstructor
public class Ingredient  {

    @PrimaryKey
    private  String id;
    private  String name;
    private  Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
