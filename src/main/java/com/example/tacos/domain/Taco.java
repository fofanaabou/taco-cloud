package com.example.tacos.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Table
@Entity
@NoArgsConstructor
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    @NonNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NonNull
    @Size(min = 5, message = "You must choose at least 1 ingredient")
    @ManyToMany
    @ToString.Exclude
    private List<Ingredient> ingredients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Taco taco = (Taco) o;
        return id != null && Objects.equals(id, taco.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
