package com.diploma.noormal.controller;


import com.diploma.noormal.service.CartService;
import com.diploma.noormal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.diploma.noormal.util.Constants.ControllerConstants.CART_SERVICE_IMPL;
import static com.diploma.noormal.util.Constants.ControllerConstants.DONE_ORDER;
import static com.diploma.noormal.util.Constants.ControllerConstants.ORDER_ID;

/**
 * @author Arsalan. Created on 01.05.2017.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/create")
    public String createOrder() {
        return "order";
    }

    @RequestMapping("/confirm")
    public String confirmOrder() {
        return "confirmOrder";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addOrder(
            @RequestParam(value = "typeDelivery", required = false) String typeDelivery,
            @RequestParam(value = "typePayment", required = false) String typePayment,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "userEmail", required = false) String email,
            HttpServletRequest request) {
        long savedOrderId = orderService.createOrder(typeDelivery, typePayment, phoneNumber, userName, email);

        HttpSession session = request.getSession();
        CartService cartService = (CartService) session.getAttribute(CART_SERVICE_IMPL);
        cartService.clearCart();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ORDER_ID, savedOrderId);
        modelAndView.setViewName(DONE_ORDER);
        return modelAndView;
    }

}
