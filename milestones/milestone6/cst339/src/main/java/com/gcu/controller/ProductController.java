package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.models.ProductForm;

import jakarta.validation.Valid;

// ProductController handles product display, create, update, and delete using Spring MVC + Spring Data JDBC
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // Constructor injection of ProductService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Display list of products
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/index";
    }

    // ---> ADDED for Milestone 5: PRODUCT DISPLAY MODULE (View single product)
    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        ProductEntity product = productService.findById(id);
        if (product == null) {
            // simple fallback - redirect to list
            return "redirect:/products";
        }

        model.addAttribute("product", product);
        return "products/view";
    }

    // ---> ADDED for Milestone 5: UPDATE MODULE (Show edit form)
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        ProductEntity product = productService.findById(id);
        if (product == null)
            return "redirect:/products";

        ProductForm form = new ProductForm();
        form.setId(product.getId());
        form.setName(product.getName());
        form.setDescription(product.getDescription());
        form.setPrice(product.getPrice().floatValue());
        form.setQuantity(product.getQuantity());

        model.addAttribute("form", form);
        model.addAttribute("productId", id);
        return "products/edit";
    }

    // ---> ADDED for Milestone 5: UPDATE MODULE (Submit edit form)
    @PostMapping("/{id}/edit")
    public String editSubmit(@PathVariable Long id,
            @Valid @ModelAttribute("form") ProductForm form,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productId", id);
            return "products/edit";
        }

        ProductEntity entity = new ProductEntity();
        entity.setId(id);
        entity.setName(form.getName());
        entity.setDescription(form.getDescription());
        entity.setPrice(new java.math.BigDecimal(form.getPrice()));
        entity.setQuantity(form.getQuantity());

        productService.update(entity);
        return "redirect:/products/" + id;
    }

    // ---> ADDED for Milestone 5: DELETE MODULE (Handle delete product)
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    // Show form to create a new product
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("form", new ProductForm());
        return "products/create";
    }

    // Handle form submission to create a new product
    @PostMapping("/create")
    public String createSubmit(@Valid @ModelAttribute("form") ProductForm form,
            BindingResult result) {
        if (result.hasErrors())
            return "products/create";

        ProductEntity entity = new ProductEntity();
        entity.setName(form.getName());
        entity.setDescription(form.getDescription());
        entity.setPrice(new java.math.BigDecimal(form.getPrice()));
        entity.setQuantity(form.getQuantity());

        productService.create(entity);
        return "redirect:/products";
    }
}
