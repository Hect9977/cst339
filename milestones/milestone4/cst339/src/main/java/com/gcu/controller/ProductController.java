package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.models.ProductForm;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

// ProductController class to handle requests related to products, including listing and creating products
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // Constructor injection of ProductService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Show list of products
    @GetMapping
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) return "redirect:/login";

        model.addAttribute("products", productService.findAll());
        return "products/index"; 
    }

    // Show form to create a new product
    @GetMapping("/create")
    public String createForm(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) return "redirect:/login";

        model.addAttribute("form", new ProductForm());
        return "products/create"; 
    }

    // Handle form submission to create a new product
    @PostMapping("/create")
    public String createSubmit(HttpSession session,
                               @Valid @ModelAttribute("form") ProductForm form,
                               BindingResult result) {
        if (session.getAttribute("userId") == null) return "redirect:/login";
        if (result.hasErrors()) return "products/create";

        ProductEntity entity = new ProductEntity(
                null,
                form.getName(),
                form.getDescription(),
                form.getPrice(),
                form.getQuantity()
        );

        productService.create(entity);
        return "redirect:/products";
    }
}
