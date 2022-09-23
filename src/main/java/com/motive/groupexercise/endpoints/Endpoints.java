package com.motive.groupexercise.endpoints;

import com.motive.groupexercise.domain.entity.Product;
import com.motive.groupexercise.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class Endpoints {
    private ProductService productService;

    @Autowired
    public Endpoints(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{assetID}")
    public Mono<Product> testRoute(@PathVariable("assetID") String id) {
        Mono<Product> product = this.productService.getProductById(id);
        System.out.println(product);
        return product;
    }
}