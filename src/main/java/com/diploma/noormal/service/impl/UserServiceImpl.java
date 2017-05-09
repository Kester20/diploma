package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Product;
import com.diploma.noormal.model.Role;
import com.diploma.noormal.model.User;
import com.diploma.noormal.repository.RoleRepository;
import com.diploma.noormal.repository.UserRepository;
import com.diploma.noormal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles((List<Role>) roleRepository.findAll());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addToWishList(User user, Product product) {
        List<Product> wishList = user.getWishList();
        wishList.add(product);
        userRepository.save(user);
    }
}
