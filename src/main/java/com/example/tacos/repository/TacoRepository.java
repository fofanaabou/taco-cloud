package com.example.tacos.repository;

import com.example.tacos.domain.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Iterable<Taco> findAll(Pageable pageable);
}
