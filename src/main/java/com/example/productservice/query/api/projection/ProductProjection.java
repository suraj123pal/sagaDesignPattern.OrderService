package com.example.productservice.query.api.projection;

import com.example.productservice.command.api.entity.Product;
import com.example.productservice.command.api.repository.ProductRepo;
import com.example.productservice.command.api.rest.ProductRestTemplate;
import com.example.productservice.query.api.query.GetProductQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private ProductRepo productRepo;

    public ProductProjection(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @QueryHandler
    public List<ProductRestTemplate> handle(GetProductQuery getProductQuery)
    {
        List<Product> allProducts = productRepo.findAll();
        ProductRestTemplate productRestTemplate = new ProductRestTemplate();
        List<ProductRestTemplate> allProduct = allProducts.stream().map(product ->
                ProductRestTemplate.
                        builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build()).collect(Collectors.toList());

        return allProduct;

    }
}