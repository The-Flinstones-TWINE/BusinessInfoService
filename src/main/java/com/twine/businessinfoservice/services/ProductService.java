package com.twine.businessinfoservice.services;

import com.twine.businessinfoservice.entities.Product;
import com.twine.businessinfoservice.exceptions.ProductNotFoundException;
import com.twine.businessinfoservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    //createProduct
    public List<String> createProducts(List<Product> products){
        List<Product> savedProducts =productRepo.saveAll(products);
        List<String> businessProductIds = savedProducts.stream().map(product -> product.getId()).collect(Collectors.toList());
        return businessProductIds;
    }

    //getProductById
    public Optional<Product> getProductById(String id) throws ProductNotFoundException {

        Optional<Product> product= productRepo.findById(id);
        if(!product.isPresent())
            throw new ProductNotFoundException("product not found");
        return product;
    }
}
