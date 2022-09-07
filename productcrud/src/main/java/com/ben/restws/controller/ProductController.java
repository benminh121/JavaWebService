package com.ben.restws.controller;

import com.ben.restws.entities.Product;
import com.ben.restws.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository repository;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return repository.findById(id).get();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);

    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return repository.save(product);
    }
}
