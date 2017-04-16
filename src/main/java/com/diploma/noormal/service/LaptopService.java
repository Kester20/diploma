package com.diploma.noormal.service;

import com.diploma.noormal.model.Laptop;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
public interface LaptopService {

    Page<Laptop> getLaptopByCriteria(Map<String, Object> criteria);

    Map<String, Object> createCriteria(HttpServletRequest request);

}
