package com.buzas.discoveryclientdb.controllers;

import com.buzas.discoveryclientdb.items.Product;
import com.buzas.discoveryclientdb.items.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    ProductService productService;

    @PostConstruct
    private void init() {
        productService = new ProductService();
    }

    @GetMapping("/")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/")
    public void addProduct(@RequestParam String title, @RequestParam Integer price) {
        productService.addProduct(title, price);
    }

    @PostMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
