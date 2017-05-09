package com.diploma.noormal.service;

import com.diploma.noormal.model.Product;
import com.diploma.noormal.model.User;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);

    void addToWishList(User user, Product product);

    void deleteFromWishList(User user, Product product);

    void addComment(User user, Product product, String text);
}
