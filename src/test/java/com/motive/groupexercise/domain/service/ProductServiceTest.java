package com.motive.groupexercise.domain.service;

import com.motive.groupexercise.domain.entity.Product;
import com.motive.groupexercise.domain.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    void shouldBeAbleToPersistAndRetrieveProducts() {
        String expectedName = "name";
        String expectedDescription = "description";

        Product product = new Product(expectedName, expectedDescription);

//        when(productRepository.save(any())).thenReturn(product);
        doReturn(Mono.just(product)).when(productRepository).save(any());

        // when
        productService.insertNewProduct(expectedName, expectedDescription).block();

        //then
        verify(productRepository, times(1)).save(productCaptor.capture());

        Product savedProduct = productCaptor.getValue();
        Assertions.assertEquals(expectedName, savedProduct.getName());
        Assertions.assertEquals(expectedDescription, savedProduct.getDescription());
    }
}
