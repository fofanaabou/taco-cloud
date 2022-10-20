package com.example.tacos.repository;

import com.example.tacos.domain.TacoOrder;
import com.example.tacos.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
    List<TacoOrder> readTacoOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip,
            Date startDate, Date endDate);
    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
