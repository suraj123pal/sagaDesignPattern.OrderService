package com.example.productservice.command.api.controller;

import com.example.productservice.command.api.command.CreateProductCommand;
import com.example.productservice.command.api.rest.ProductRestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/post")
@Slf4j
public class CommandRestController {

    private CommandGateway commandGateway;

    public CommandRestController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    @PostMapping("/product")
    public String createProduct(@RequestBody ProductRestTemplate productRestTemplate)
    {

        CreateProductCommand createProductCommand = CreateProductCommand
                .builder()
                .productId(UUID.randomUUID().toString())
                .name(productRestTemplate.getName())
                .price(productRestTemplate.getPrice())
                .quantity(productRestTemplate.getQuantity())
                .build();

        String  reponse = commandGateway.sendAndWait(createProductCommand);

        log.info(productRestTemplate.toString());
        return reponse;
    }
}