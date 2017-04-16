package com.diploma.noormal.controller;

import com.diploma.noormal.model.Laptop;
import com.diploma.noormal.service.CategoryService;
import com.diploma.noormal.service.LaptopService;
import com.diploma.noormal.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
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
    public String showLaptops(HttpServletRequest request, Model model) {
        Map<String, Object> criteria = laptopService.createCriteria(request);
        if (criteria != null) {
            prepareResponse(model, criteria);
        }
        return "products";
    }

    private void prepareResponse(Model model, Map<String, Object> criteria) {
        Page<Laptop> page = laptopService.getLaptopByCriteria(criteria);
        model.addAttribute(LAPTOP_LIST, page.getContent());
        model.addAttribute(PRODUCER_LIST, producerService.getAllProducers());
        model.addAttribute(CATEGORY_LIST, categoryService.getAllCategories());
        model.addAttribute(COUNT_OF_LAPTOPS, page.getTotalElements());
        model.addAttribute(COUNT_OF_PAGES, getCountOfPages(page.getTotalElements(), (int) criteria.get(LIMIT)));
        model.addAttribute(SHOW_COUNT, criteria.get(LIMIT));
        model.addAttribute(CURRENT_PAGE, criteria.get(PAGE));
    }

    private int getCountOfPages(double countOfLaptops, double showCount) {
        return (int) Math.ceil(countOfLaptops / showCount);
    }
}
