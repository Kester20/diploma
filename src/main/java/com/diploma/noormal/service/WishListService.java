package com.diploma.noormal.service;

import com.diploma.noormal.model.Product;
import com.diploma.noormal.model.User;
import com.diploma.noormal.model.WishList;

import java.util.List;

/**
 * @author Arsalan. Created on 08.05.2017.
 */
public interface WishListService {

    boolean addToWishList(User user, Product product);

    List<WishList> findWishListByUser(Long userId);
}
