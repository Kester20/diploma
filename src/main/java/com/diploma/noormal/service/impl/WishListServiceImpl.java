package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Product;
import com.diploma.noormal.model.User;
import com.diploma.noormal.model.WishList;
import com.diploma.noormal.repository.WishListRepository;
import com.diploma.noormal.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arsalan. Created on 08.05.2017.
 */
@Service
public class WishListServiceImpl implements WishListService {

    private WishListRepository wishListRepository;

    @Autowired
    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public boolean addToWishList(User user, Product product) {
        WishList wishList = new WishList();
        wishList.setUserId(user.getId());
        wishList.setProductId(product.getId());
        return wishListRepository.save(wishList) != null;
    }

    @Override
    public List<WishList> findWishListByUser(Long userId) {
        return wishListRepository.findByUserId(userId);
    }
}
