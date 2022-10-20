package com.example.tacos.controllers;

import com.example.tacos.domain.TacoOrder;
import com.example.tacos.domain.User;
import com.example.tacos.props.OrderProps;
import com.example.tacos.repository.OrderRepository;
import com.example.tacos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@Slf4j
@RestController
@SessionAttributes("tacoOrder")
@RequestMapping({"/orders", "/api/orders"})
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

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(
            @PathVariable("orderId") Long orderId,
            @RequestBody TacoOrder tacoOrder) {
        tacoOrder.setId(orderId);
        return orderRepository.save(tacoOrder);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(
            @PathVariable("orderId") Long orderId,
            @RequestBody TacoOrder patch) {

        TacoOrder order = orderRepository.findById(orderId).get();
        if(patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if(patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if(patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if( patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) throws EmptyResultDataAccessException {
        orderRepository.deleteById(orderId);
    }

}
