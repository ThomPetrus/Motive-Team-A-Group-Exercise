package com.motive.groupexercise.domain.repository;

import com.motive.groupexercise.domain.entity.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, String> {

    @Query("select * from product where name like concat('%',:name,'%')")
    Flux<Product> findByName(String name);
}
