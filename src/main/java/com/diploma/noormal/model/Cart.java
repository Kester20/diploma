package com.diploma.noormal.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arsalan. Created on 13.04.2017.
 */
@Component
@Scope(value = "session")
public class Cart {

    private Map<Product, Integer> products;

    public Cart() {
        products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        return products.equals(cart.products);
    }

    @Override
    public int hashCode() {
        return products.hashCode();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
