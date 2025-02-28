package com.example.mystore.controller;

import com.example.mystore.core.Result;
import com.example.mystore.entity.Supplier;
import com.example.mystore.service.SupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SupController {

    @Autowired
    private SupService supService;

    @GetMapping("/")
    public String init() {
        return "index";
    }

    @PostMapping("/login")
    public String loginCheck(Supplier supplier, Model model) {
        Result result = supService.checkSupplier(supplier);
        
        if (!result.isSuccess()) {
            model.addAttribute("error", result.getMessage());
            return "index";
        }
        
        model.addAttribute("supplier", result.getData());
        return "home";
    }
}