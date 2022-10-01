package com.example.tacos.controllers;

import com.example.tacos.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @DeleteMapping("/deleteOrders")
    public String deleteAllOrders(){
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }
}
