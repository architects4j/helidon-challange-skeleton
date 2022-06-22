package com.architects4j.workshop.microstream.helidon.product;

import jakarta.nosql.mapping.Repository;

import java.util.List;

public interface ProductRepository extends Repository<Product, String> {
    List<Product> findAll();
}
