package com.diploma.noormal.repository;

import com.diploma.noormal.model.WishList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Arsalan. Created on 08.05.2017.
 */
@Repository
public interface WishListRepository extends CrudRepository<WishList, Long>{

    List<WishList> findByUserId(Long userId);
}
