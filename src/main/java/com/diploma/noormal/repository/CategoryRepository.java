package com.diploma.noormal.repository;

import com.diploma.noormal.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arsalan. Created on 13.04.2017.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
