package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Laptop;
import com.diploma.noormal.model.QLaptop;
import com.diploma.noormal.repository.LaptopRepository;
import com.diploma.noormal.service.LaptopService;
import com.diploma.noormal.util.Constants;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import static com.diploma.noormal.util.Constants.ASC;
import static com.diploma.noormal.util.Constants.CHECKBOX_CATEGORY;
import static com.diploma.noormal.util.Constants.DEFAULT_FIRST_PRICE;
import static com.diploma.noormal.util.Constants.DEFAULT_PAGE;
import static com.diploma.noormal.util.Constants.DEFAULT_SECOND_PRICE;
import static com.diploma.noormal.util.Constants.DEFAULT_SELECT_SHOW;
import static com.diploma.noormal.util.Constants.DESC;
import static com.diploma.noormal.util.Constants.FIRST_PRICE;
import static com.diploma.noormal.util.Constants.LAPTOPS_CATEGORY;
import static com.diploma.noormal.util.Constants.LAPTOPS_ID;
import static com.diploma.noormal.util.Constants.LAPTOPS_PRODUCER;
import static com.diploma.noormal.util.Constants.LIMIT;
import static com.diploma.noormal.util.Constants.ORDER_BY;
import static com.diploma.noormal.util.Constants.ORDER_MODE;
import static com.diploma.noormal.util.Constants.PAGE;
import static com.diploma.noormal.util.Constants.SECOND_PRICE;
import static com.diploma.noormal.util.Constants.SELECT_SHOW;
import static com.diploma.noormal.util.Constants.SELECT_SORT;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public List<Laptop> getLaptopByCriteria(Map<String, Object> criteria) {
        String[] producers = (String[]) criteria.get(LAPTOPS_PRODUCER);
        String[] categories = (String[]) criteria.get(LAPTOPS_CATEGORY);
        int lowerPriceLimit = (int) criteria.get(FIRST_PRICE);
        int upperPriceLimit = (int) criteria.get(SECOND_PRICE);
        /*String orderBy = (String) criteria.get(ORDER_BY);
        int showCount = (int) criteria.get(LIMIT);
        int page = (int) criteria.get(PAGE);
        String orderMode = (String) criteria.get(ORDER_MODE);*/

        QLaptop qLaptop  = QLaptop.laptop;
        Predicate predicateProducer = producers == null ? null : qLaptop.producer.name.in(producers);
        Predicate predicateCategory = categories == null ? null : qLaptop.category.name.in(categories);
        Predicate predicate = qLaptop.cost.between(lowerPriceLimit, upperPriceLimit)
                .and(predicateProducer)
                .and(predicateCategory);

        //Pageable pageable = new PageRequest(0, 1, new Sort(Sort.Direction.ASC, "id"));
        return (List<Laptop>) laptopRepository.findAll(predicate);
    }

    @Override
    public int getCountOfLaptops() {
        return 0;
    }

    @Override
    public Laptop getLaptopById(int id) {
        return null;
    }

    @Override
    public Map<String, Object> createCriteria(HttpServletRequest request) {
        Map<String, Object> criteria = new LinkedHashMap<>();
        String[] producers = request.getParameterValues(Constants.CHECKBOX_PRODUCER);
        String[] categories = request.getParameterValues(CHECKBOX_CATEGORY);
        int firstPrice = request.getParameter(FIRST_PRICE) == null ? DEFAULT_FIRST_PRICE : Integer.parseInt(request.getParameter(FIRST_PRICE));
        int secondPrice = request.getParameter(SECOND_PRICE) == null ? DEFAULT_SECOND_PRICE : Integer.parseInt(request.getParameter(SECOND_PRICE));
        String orderBy = request.getParameter(SELECT_SORT) == null ? LAPTOPS_ID : request.getParameter(SELECT_SORT);
        int showCount = request.getParameter(SELECT_SHOW) == null ? DEFAULT_SELECT_SHOW : Integer.parseInt(request.getParameter(SELECT_SHOW));
        int page = request.getParameter(PAGE) == null ? DEFAULT_PAGE : Integer.parseInt(request.getParameter(PAGE));
        String orderMode = request.getParameter(ORDER_MODE) == null ? ASC : DESC;

        if (producers != null) {
            criteria.put(LAPTOPS_PRODUCER, producers);
        }
        if (categories != null) {
            criteria.put(LAPTOPS_CATEGORY, categories);
        }

        criteria.put(FIRST_PRICE, firstPrice);
        criteria.put(SECOND_PRICE, secondPrice);
        criteria.put(ORDER_BY, orderBy);
        criteria.put(LIMIT, showCount);
        criteria.put(PAGE, page);
        criteria.put(ORDER_MODE, orderMode);
        return criteria;
    }
}
