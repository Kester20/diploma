package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Cart;
import com.diploma.noormal.model.Product;
import com.diploma.noormal.service.CartService;
import com.diploma.noormal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

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
        int countOfProduct = getCountOfProductInCart(product);
        cart.getProducts().put(product, countOfProduct);
    }

    @Override
    public void removeFromCart(long idProduct) {
        Map<Product, Integer> productsInCart = cart.getProducts();
        for (Product product : productsInCart.keySet()) {
            if (product.getId() == idProduct) {
                productsInCart.remove(product);
            }
        }
    }

    @Override
    public int getAmount() {
        int result = 0;
        Map<Product, Integer> productsInCart = cart.getProducts();
        for (Product product : productsInCart.keySet()) {
            result += product.getCost() * productsInCart.get(product);
        }
        return result;
    }

    @Override
    public int getNumberOfProducts() {
        return cart.getProducts().size();
    }

    private int getCountOfProductInCart(Product product){
        Map<Product, Integer> productsInCart = cart.getProducts();
        return productsInCart.get(product)  == null ? 1 : productsInCart.get(product);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
