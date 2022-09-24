package com.motive.groupexercise.endpoints;

import com.motive.groupexercise.domain.entity.Product;
import com.motive.groupexercise.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value="/data")
public class Endpoints {
    private ProductService productService;

    // @Autowired makes it so that the productService variable above gets instantiated automatically
    @Autowired
    public Endpoints(ProductService productService) {
        this.productService = productService;
    }

    // Get mapping here is defining the endpoint. These will be relative to /product/data because of the
    // RequestMapping annotation above and also the context path set in application.properties
    @GetMapping("/{assetID}")
    public Mono<Product> getProductByID(@PathVariable("assetID") String id) {
        Mono<Product> product = this.productService.getProductById(id);
        return product;
    }

    @GetMapping("/byName/{assetName}")
    public Flux<Product> getProductByName(@PathVariable("assetName") String assetName) {
        Flux<Product> product = this.productService.getProductByName(assetName);
        return product;
    }

    @PutMapping(path = "/insert")
    public Mono<Product> insertProduct(@RequestParam String name, @RequestParam String description) {
        return this.productService.insertNewProduct(name, description);
    }
}
