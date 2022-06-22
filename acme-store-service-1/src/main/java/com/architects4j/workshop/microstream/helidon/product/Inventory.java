package com.architects4j.workshop.microstream.helidon.product;

import one.microstream.integrations.cdi.types.Storage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Storage
public class Inventory implements ProductRepository {

    private final Set<Product> products = new HashSet<>();

    @Override
    public Collection<Product> getAll() {
        return Collections.unmodifiableSet(this.products);
    }

    @Override
    public Product save(Product product) {
        Objects.requireNonNull(product, "Product is required");
        this.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(String id) {
        return this.products.stream().filter(this.isIdEquals(id)).limit(1).findFirst();
    }

    @Override
    public void deleteById(String id) {
        this.products.removeIf(this.isIdEquals(id));
    }

    private Predicate<Product> isIdEquals(final String id) {
        return p -> p.getName() == id;
    }
}
