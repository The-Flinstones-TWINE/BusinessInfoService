package com.twine.businessinfoservice.controller;

import com.twine.businessinfoservice.entities.Product;
import com.twine.businessinfoservice.exceptions.ProductNotFoundException;
import com.twine.businessinfoservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //getAllProducts method
    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //createProduct method
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    //getProductById
    @GetMapping("/product/{id}")
    public Optional<Product> getProductById( @PathVariable("id") Long id){
        try {
            return productService.getProductById(id);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
}
