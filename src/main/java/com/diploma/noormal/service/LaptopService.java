package com.diploma.noormal.service;

import com.diploma.noormal.model.Laptop;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface LaptopService {

    List<Laptop> getLaptopByCriteria(Map<String, Object> criteria);

    int getCountOfLaptops();

    Laptop getLaptopById(int id);

    Map<String, Object> createCriteria(HttpServletRequest request);

}
