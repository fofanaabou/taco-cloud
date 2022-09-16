package com.example.tacos.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
