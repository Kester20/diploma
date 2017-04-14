package com.diploma.noormal.service;

import com.diploma.noormal.exceptions.BusinessException;
import com.diploma.noormal.model.Order;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface OrderService {

    void createOrder(Order order) throws BusinessException;

    int getLastOrderId();
}
