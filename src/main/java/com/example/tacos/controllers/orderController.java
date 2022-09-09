package com.example.tacos.controllers;

import com.example.tacos.domain.TacoOrder;
import com.example.tacos.repository.jdbc.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@SessionAttributes("tacoOrder")
@RequestMapping("/orders")
@RequiredArgsConstructor
public class orderController {

    private final OrderRepository orderRepository;

    @GetMapping("/current")
    public String orderForm(){

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus){

        if(errors.hasErrors())
            return "orderForm";
        orderRepository.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
