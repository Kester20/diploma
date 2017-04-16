package com.diploma.noormal.controller;

import com.diploma.noormal.service.CategoryService;
import com.diploma.noormal.service.LaptopService;
import com.diploma.noormal.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static com.diploma.noormal.util.Constants.CATEGORY_LIST;
import static com.diploma.noormal.util.Constants.COUNT_OF_LAPTOPS;
import static com.diploma.noormal.util.Constants.COUNT_OF_PAGES;
import static com.diploma.noormal.util.Constants.CURRENT_PAGE;
import static com.diploma.noormal.util.Constants.LAPTOP_LIST;
import static com.diploma.noormal.util.Constants.LIMIT;
import static com.diploma.noormal.util.Constants.PAGE;
import static com.diploma.noormal.util.Constants.PRODUCER_LIST;
import static com.diploma.noormal.util.Constants.SHOW_COUNT;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Controller
public class LaptopController {

    private LaptopService laptopService;
    private CategoryService categoryService;
    private ProducerService producerService;

    @Autowired
    public LaptopController(LaptopService laptopService, CategoryService categoryService, ProducerService producerService) {
        this.laptopService = laptopService;
        this.categoryService = categoryService;
        this.producerService = producerService;
    }

    @RequestMapping(value = "/catalog_servlet", method = RequestMethod.GET)
    public String showLaptops(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> criteria = laptopService.createCriteria(request);
        if (criteria != null) {
            prepareResponse(request, criteria);
        }
        return "products";
    }

    private void prepareResponse(HttpServletRequest request, Map<String, Object> criteria) {
        request.setAttribute(LAPTOP_LIST, laptopService.getLaptopByCriteria(criteria));
        request.setAttribute(PRODUCER_LIST, producerService.getAllProducers());
        request.setAttribute(CATEGORY_LIST, categoryService.getAllCategories());
        request.setAttribute(COUNT_OF_LAPTOPS, laptopService.getCountOfLaptops());
        request.setAttribute(COUNT_OF_PAGES, getCountOfPages(laptopService.getCountOfLaptops(), (int) criteria.get(LIMIT)));
        request.setAttribute(SHOW_COUNT, criteria.get(LIMIT));
        request.setAttribute(CURRENT_PAGE, criteria.get(PAGE));
    }

    private int getCountOfPages(double countOfLaptops, double showCount) {
        return (int) Math.ceil(countOfLaptops / showCount);
    }
}
