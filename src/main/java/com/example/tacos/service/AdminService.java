package com.example.tacos.service;

import com.example.tacos.domain.TacoOrder;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    @PreAuthorize("hasRole('ADMIN')")
    void deleteAllOrders();

    @PostAuthorize("hasRole('USER') ||" +
            "returnObject.user.name == authentication.name")
    TacoOrder getOrder(Long id);
}
