package com.diploma.noormal.repository;

import com.diploma.noormal.model.Laptop;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Long>, QueryDslPredicateExecutor<Laptop> {

}
