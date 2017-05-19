package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Cart;
import com.diploma.noormal.model.Product;
import com.diploma.noormal.service.CartService;
import com.diploma.noormal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Arsalan. Created on 23.04.2017.
 */
@Service
@Scope(value = "session")
public class CartServiceImpl implements CartService {

    private ProductService productService;
    private Cart cart;

    @Autowired
    public CartServiceImpl(ProductService productService, Cart cart) {
        this.productService = productService;
        this.cart = cart;
    }

    @Override
    public void addToCart(long idProduct) {
        Product product = productService.findOne(idProduct);
        if (product != null) {
            int countOfProduct = getCountOfProductInCart(product);
            Map<Product, Integer> productsInCart = cart.getProducts();
            productsInCart.put(product, countOfProduct);
        }
    }

    @Override
    public void removeFromCart(long idProduct) {
        Map<Product, Integer> productsInCart = cart.getProducts();
        for (Iterator<Product> iterator = productsInCart.keySet().iterator(); iterator.hasNext(); ) {
            Product product = iterator.next();
            if (product.getId() == idProduct) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public int getAmount() {
        Map<Product, Integer> productsInCart = cart.getProducts();
        return productsInCart.keySet().stream().mapToInt(product -> product.getCost() * productsInCart.get(product)).sum();
    }

    @Override
    public void updateNumberOfProductInCart(long idProduct, int numberOfProducts) {
        Map<Product, Integer> productsInCart = cart.getProducts();
        for (Product product : productsInCart.keySet()) {
            if (product.getId() == idProduct) {
                productsInCart.put(product, numberOfProducts);
                break;
            }
        }
    }

    @Override
    public int getNumberOfProductsInCart() {
        Map<Product, Integer> productsInCart = cart.getProducts();
        return productsInCart.values().stream().mapToInt(values -> values).sum();
    }

    private int getCountOfProductInCart(Product product) {
        Map<Product, Integer> productsInCart = cart.getProducts();
        return productsInCart.get(product) == null ? 1 : productsInCart.get(product);
    }

    @Override
    public void clearCart() {
        cart.getProducts().clear();
    }

    @Override
    public List<Product> getAllProductsInCart() {
        Map<Product, Integer> productsInCart = cart.getProducts();
        Set<Product> productSet = productsInCart.keySet();
        return new ArrayList<>(productSet);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
