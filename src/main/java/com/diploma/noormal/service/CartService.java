package com.diploma.noormal.service;

/**
 * @author Arsalan. Created on 23.04.2017.
 */
public interface CartService {

    void addToCart(long idProduct);

    void removeFromCart(long product);

    int getAmount();

    int getNumberOfProducts();
}
