package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.models.ProductForm;
import com.gcu.services.ProductService;

import jakarta.validation.Valid;

// Controller for handling product-related requests
@Controller
@RequestMapping("/products")
public class ProductController {

    // IoC injection of ProductService
    private final ProductService productService; // IoC injection

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Display list of products 
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/list";
    }

    // Show form to create a new product
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("form", new ProductForm());
        return "products/create";
    }

    // Handle form submission to create a new product
    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("form") ProductForm form,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "products/create";
        }
        productService.create(form);
        return "redirect:/products";
    }
}
