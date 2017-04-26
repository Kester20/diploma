package com.diploma.noormal.controller;

import com.diploma.noormal.service.CartService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.diploma.noormal.util.Constants.ID_PRODUCT;

/**
 * @author Arsalan. Created on 22.04.2017.
 */
@Controller
@Scope(value = "session")
@RequestMapping(value = "/cart")
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
        CartService cartService = (CartService) session.getAttribute("cartServiceImpl");
        if (idProduct != 0) {
            cartService.addToCart(idProduct);
        }

        JSONObject json = new JSONObject();
        json.put("amount", cartService.getAmount());
        json.put("size", cartService.getNumberOfProducts());
        return json.toString();
    }

    @RequestMapping(value = "/delete")
    public void deleteFromCart(HttpServletRequest request, @RequestParam(value = ID_PRODUCT) long idProduct) {
        HttpSession session = request.getSession();
        CartService cartService = (CartService) session.getAttribute("cartServiceImpl");
        if (cartService != null) {
            cartService.removeFromCart(idProduct);
        }
    }

    @RequestMapping(value = "/amount/update", produces = "application/json")
    @ResponseBody
    public String updateAmount(HttpServletRequest request, @RequestParam(value = ID_PRODUCT) long idProduct,
                               @RequestParam(value = "value") int numberOfProducts) {
        HttpSession session = request.getSession();
        CartService cartService = (CartService) session.getAttribute("cartServiceImpl");
        if (cartService != null) {
            cartService.updateNumberOfProductsInCart(idProduct, numberOfProducts);
        }

        JSONObject json = new JSONObject();
        json.put("amount", cartService.getAmount());
        json.put("size", cartService.getNumberOfProducts());
        return json.toString();
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String showCart() {
        return "checkout";
    }
}
