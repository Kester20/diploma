package com.diploma.noormal.service.impl;

import com.diploma.noormal.exceptions.BusinessException;
import com.diploma.noormal.model.Order;
import com.diploma.noormal.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void createOrder(Order order) throws BusinessException {

    }

    @Override
    public int getLastOrderId() {
        return 0;
    }
}
