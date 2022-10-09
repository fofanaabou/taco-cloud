package com.example.tacos.controllers;

import com.example.tacos.domain.TacoOrder;
import com.example.tacos.domain.User;
import com.example.tacos.props.OrderProps;
import com.example.tacos.repository.OrderRepository;
import com.example.tacos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@Slf4j
@Controller
@SessionAttributes("tacoOrder")
@RequestMapping("/orders")
@RequiredArgsConstructor
public class orderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderProps orderProps;

    @GetMapping("/current")
    public String orderForm() {

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user,
                               Principal principal) {

        // User user = userRepository.findByUsername(principal.getName());
        // User user$ = (User) authentication.getPrincipal();

        // System.out.println("username:" + principal.);
        // System.out.println("username:" + user.getUsername());
        // order.setUser(user);
        System.out.println("Hello world");

        if (errors.hasErrors())
            return "orderForm";
        order.setPlacedAt(new Date());
        orderRepository.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {

        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
        model.addAttribute("orders", orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));

        return "orderList";
    }
}
