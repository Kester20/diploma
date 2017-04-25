package com.diploma.noormal.service;

import com.diploma.noormal.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface LaptopService {

    Laptop findOne(long idLaptop);

    Page<Laptop> findLaptopsByCriteria(String[] producers, Integer firstPrice,
                                       Integer secondPrice, String orderBy, Integer showCount,
                                       Integer page, String orderMode, Model model);
}
