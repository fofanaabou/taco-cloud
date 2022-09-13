package com.example.tacos.repository.jpa;

import com.example.tacos.domain.TacoOrder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

@EnableJpaRepositories
public interface OrderJpaRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
    List<TacoOrder> readTacoOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip,
            Date startDate, Date endDate);
}
