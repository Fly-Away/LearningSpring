package com.api.b2b.Services;

import com.api.b2b.Model.Product;
import com.api.b2b.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }
}