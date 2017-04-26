package com.diploma.noormal.service;

import com.diploma.noormal.model.User;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
