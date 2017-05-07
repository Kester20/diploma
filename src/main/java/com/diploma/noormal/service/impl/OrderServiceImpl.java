package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Order;
import com.diploma.noormal.model.OrderStatusType;
import com.diploma.noormal.model.OrderTypeDelivery;
import com.diploma.noormal.model.OrderTypePayment;
import com.diploma.noormal.model.User;
import com.diploma.noormal.repository.OrderRepository;
import com.diploma.noormal.repository.UserRepository;
import com.diploma.noormal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Long createOrder(String typeDelivery, String typePayment, String phoneNumber,
                            String userName, String email) {

        User user = userRepository.findByUsername(userName);
        Order order = new Order();
        order.setTypeDelivery(OrderTypeDelivery.valueOf(typeDelivery));
        order.setTypePayment(OrderTypePayment.valueOf(typePayment));
        order.setStatus(OrderStatusType.CONFIRMED);
        order.setUser(user);
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getId();
    }
}
