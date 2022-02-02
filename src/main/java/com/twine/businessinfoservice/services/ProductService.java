package com.twine.businessinfoservice.services;

import com.twine.businessinfoservice.entities.Product;
import com.twine.businessinfoservice.exceptions.ProductNotFoundException;
import com.twine.businessinfoservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;


    //getAllProducts
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    //createProduct
    public Product createProduct(Product product){
        return productRepo.save(product);
    }

    //getProductById
    public Optional<Product> getProductById(Long id) throws ProductNotFoundException {

        Optional<Product> product= productRepo.findById(id);
        if(!product.isPresent())
            throw new ProductNotFoundException("product not found");
        return product;
    }
}
