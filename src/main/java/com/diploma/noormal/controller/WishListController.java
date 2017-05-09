package com.diploma.noormal.controller;

import com.diploma.noormal.exception.ProductNotFoundException;
import com.diploma.noormal.model.Product;
import com.diploma.noormal.model.User;
import com.diploma.noormal.service.ProductService;
import com.diploma.noormal.service.UserService;
import com.diploma.noormal.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.diploma.noormal.util.Constants.ControllerConstants.ID_PRODUCT;
import static com.diploma.noormal.util.Constants.ControllerConstants.PRODUCT_NOT_FOUND;

/**
 * @author Arsalan. Created on 08.05.2017.
 */
@Controller
@RequestMapping("/wishList")
public class WishListController {

    private WishListService wishListService;
    private UserService userService;
    private ProductService productService;

    @Autowired
    public WishListController(WishListService wishListService, UserService userService, ProductService productService) {
        this.wishListService = wishListService;
        this.userService = userService;
        this.productService = productService;
    }

    @RequestMapping(value = "/add")
    public boolean addToWishList(@RequestParam(value = ID_PRODUCT) Long idProduct) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUsername(name);

        Product product = productService.findOne(idProduct);
        if (product == null) {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND);
        }
        return wishListService.addToWishList(user, product);
    }
}
