package com.example.productservice.query.api.projectionController;

import com.example.productservice.command.api.rest.ProductRestTemplate;
import com.example.productservice.query.api.query.GetProductQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProjectionController {

    private QueryGateway queryGateway;

    public ProjectionController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/products")
    public List<ProductRestTemplate> getAllProducts()
    {
        GetProductQuery getProductQuery = new GetProductQuery();

        List<ProductRestTemplate> productRestTemplates =
                queryGateway
                        .query(getProductQuery, ResponseTypes
                                .multipleInstancesOf(ProductRestTemplate.class)).join();

        return productRestTemplates;
    }
}