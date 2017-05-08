package com.diploma.noormal.service;

import com.diploma.noormal.model.Product;

import java.util.List;

/**
 * @author Arsalan. Created on 23.04.2017.
 */
public interface CartService {

    boolean addToCart(long idProduct);

    void removeFromCart(long product);

    int getAmount();

    int getNumberOfProductsInCart();

    void updateNumberOfProductInCart(long idProduct, int numberOfProducts);

    void clearCart();

    List<Product> getAllProductsInCart();
}
