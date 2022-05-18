package com.example.productservice.command.api.events;

import com.example.productservice.command.api.entity.Product;
import com.example.productservice.command.api.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductEventHandler {

    private ProductRepo productRepo;


    public ProductEventHandler(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @EventHandler
    public void handle(ProductCreatedEvent productCreatedEvent)
    {
        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent,product);
        productRepo.save(product);
        log.info(product.toString() + "product saved successfully");
    }

}