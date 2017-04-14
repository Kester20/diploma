package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Laptop;
import com.diploma.noormal.repository.LaptopRepository;
import com.diploma.noormal.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public List<Laptop> getLaptopByCriteria(Map<String, Object> criteria) {
        return null;
    }

    @Override
    public int getCountOfLaptops() {
        return 0;
    }

    @Override
    public Laptop getLaptopById(int id) {
        return null;
    }
}
