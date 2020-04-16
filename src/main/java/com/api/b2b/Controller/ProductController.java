package com.api.b2b.Controller;

import java.net.URI;

import javax.validation.Valid;

import com.api.b2b.Exception.AccountNotFoundException;
import com.api.b2b.Model.Product;
import com.api.b2b.Services.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    ProductService productService;

    @Operation(summary = "simpan product baru", description = "tidak boleh ada kolom yang kosong", tags = { "CRUD Product" })
    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {

        try {
            Product products = productService.save(product);
            return ResponseEntity.ok().body(products);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}