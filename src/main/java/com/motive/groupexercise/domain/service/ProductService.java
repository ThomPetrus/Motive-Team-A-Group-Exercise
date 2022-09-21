package com.motive.groupexercise.domain.service;

import com.motive.groupexercise.domain.entity.Product;
import com.motive.groupexercise.domain.exception.ProductException;
import com.motive.groupexercise.domain.exception.ProductNotFoundException;
import com.motive.groupexercise.domain.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieve a product by its unique id.
     *
     * @param id - String UUID
     * @return Product for give id
     * @throws ProductException if error occurs
     * @throws ProductNotFoundException if no product found for id
     */
    public Mono<Product> getProductById(String id) {
        return productRepository.findById(id)
                .onErrorMap(throwable -> {
                    throw new ProductException(String.format("Error retrieving Product for %s", id));
                })
                .map(product -> {
                    if (Optional.ofNullable(product).isEmpty()) {
                        throw new ProductNotFoundException(String.format("No product found for id %s", id));
                    }
                    return product;
                });
    }

    /**
     * Retrieve any products that match a requested name
     *
     * @param name
     * @return Flux of Product with any matching given name
     * @throws ProductException if error occurs
     * @throws ProductNotFoundException if no products found for name
     */
    public Flux<Product> getProductByName(String name) {
        return productRepository.findByName(name)
                .onErrorMap(throwable -> {
                    throw new ProductException(String.format("Error retrieving Product for %s", name));
                })
                .map(product -> {
                    if (Optional.ofNullable(product).isEmpty()) {
                        throw new ProductNotFoundException(String.format("No products found for name %s", name));
                    }
                    return product;
                });
    }

    /**
     * Insert new Product
     *
     * @param name - new product name
     * @param description - new product description
     */
    public Mono<Product> insertNewProduct(String name, String description) {
        Product product = new Product(name, description);
        return productRepository.save(product);
    }
}
