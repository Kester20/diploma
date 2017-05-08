package com.diploma.noormal.service;

import com.diploma.noormal.model.Order;
import com.diploma.noormal.model.Product;

import java.util.List;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface OrderService {

    Long createOrder(String typeDelivery, String typePayment, String phoneNumber,
                     String userName, String email, List<Product> productsInCart);

    List<Order> findOrdersByUser(Long userId);
}
