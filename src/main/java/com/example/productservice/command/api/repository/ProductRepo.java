package com.example.productservice.command.api.repository;

import com.example.productservice.command.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}