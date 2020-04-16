package com.api.b2b.Repository;

import java.util.*;

import com.api.b2b.Model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}