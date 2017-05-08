package com.diploma.noormal.repository;

import com.diploma.noormal.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUserId(Long userId);
}
