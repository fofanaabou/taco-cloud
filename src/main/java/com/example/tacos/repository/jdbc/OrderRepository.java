package com.example.tacos.repository.jdbc;

import com.example.tacos.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
