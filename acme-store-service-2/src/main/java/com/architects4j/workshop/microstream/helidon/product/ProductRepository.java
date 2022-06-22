package com.architects4j.workshop.microstream.helidon.product;

import jakarta.nosql.mapping.Repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface ProductRepository extends Repository<Product, String> {
    List<Product> findAll();
}
