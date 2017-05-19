package com.diploma.noormal.controller;

import com.diploma.noormal.service.CartService;
import com.diploma.noormal.util.JsonMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.diploma.noormal.util.Constants.ControllerConstants.AMOUNT;
import static com.diploma.noormal.util.Constants.ControllerConstants.CART;
import static com.diploma.noormal.util.Constants.ControllerConstants.CART_SERVICE_IMPL;
import static com.diploma.noormal.util.Constants.ControllerConstants.ID_PRODUCT;
import static com.diploma.noormal.util.Constants.ControllerConstants.MODAL;
import static com.diploma.noormal.util.Constants.ControllerConstants.SIZE;
import static com.diploma.noormal.util.Constants.ControllerConstants.VALUE;

/**
 * @author Arsalan. Created on 22.04.2017.
 */
@Controller
@RequestMapping("/cart")
@Scope("session")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/add", produces = "application/json")
    @ResponseBody
    public String addToCart(HttpServletRequest request, @RequestParam(value = ID_PRODUCT) long idProduct) {
        HttpSession session = request.getSession();
        CartService cartService = (CartService) session.getAttribute(CART_SERVICE_IMPL);
        cartService.addToCart(idProduct);
        Map<String, Object> response = prepareResponse();
        return JsonMaker.make(response);
    }

    @RequestMapping(value = "/amount/update", produces = "application/json")
    @ResponseBody
    public String updateAmount(HttpServletRequest request,
                               @RequestParam(value = ID_PRODUCT) long idProduct,
                               @RequestParam(value = VALUE) int numberOfProducts) {
        HttpSession session = request.getSession();
        CartService cartService = (CartService) session.getAttribute(CART_SERVICE_IMPL);
        cartService.updateNumberOfProductInCart(idProduct, numberOfProducts);
        Map<String, Object> response = prepareResponse();
        return JsonMaker.make(response);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public void deleteFromCart(HttpServletRequest request, @RequestParam(value = ID_PRODUCT) long idProduct) {
        HttpSession session = request.getSession();
        CartService cartService = (CartService) session.getAttribute(CART_SERVICE_IMPL);
        cartService.removeFromCart(idProduct);
    }

    private Map<String, Object> prepareResponse() {
        Map<String, Object> response = new HashMap<String, Object>() {{
            put(AMOUNT, cartService.getAmount());
            put(SIZE, cartService.getNumberOfProductsInCart());
            put(MODAL, CART);
        }};
        return response;
    }
}
