package com.diploma.noormal.service;

import com.diploma.noormal.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface ProductService {

    Product findOne(long idLaptop);

    Page<Product> findLaptopsByCriteria(String[] producers, Integer firstPrice,
                                        Integer secondPrice, String orderBy, Integer showCount,
                                        Integer page, String orderMode, Model model);
}
