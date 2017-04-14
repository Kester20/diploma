package com.diploma.noormal.service;

import com.diploma.noormal.model.Laptop;

import java.util.List;
import java.util.Map;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface LaptopService {

    List<Laptop> getLaptopByCriteria(Map<String, Object> criteria);

    int getCountOfLaptops();

    Laptop getLaptopById(int id);

}
