package com.diploma.noormal.service;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface OrderService {

    Long createOrder(String typeDelivery, String typePayment, String phoneNumber,
                     String userName, String email);

    int getLastOrderId();
}
