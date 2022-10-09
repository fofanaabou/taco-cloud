package com.example.tacos.service;

import com.example.tacos.domain.TacoOrder;
import com.example.tacos.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private final OrderRepository orderRepository;

    public AdminServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    @Override
    public TacoOrder getOrder(Long id) {
        return null;
    }
}
