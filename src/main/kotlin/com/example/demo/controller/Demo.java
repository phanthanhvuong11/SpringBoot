package com.example.demo.controller;


import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.model.Product;
import com.example.demo.repository.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class Demo {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getAllProducts/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("True", "Query product successfully", product));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "Cannot find product with id = " + id, null));
        }
    }
}
