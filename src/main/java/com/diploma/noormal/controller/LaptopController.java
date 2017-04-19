package com.diploma.noormal.controller;

import com.diploma.noormal.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.diploma.noormal.util.Constants.CHECKBOX_CATEGORY;
import static com.diploma.noormal.util.Constants.CHECKBOX_PRODUCER;
import static com.diploma.noormal.util.Constants.FIRST_PRICE;
import static com.diploma.noormal.util.Constants.ORDER_MODE;
import static com.diploma.noormal.util.Constants.PAGE;
import static com.diploma.noormal.util.Constants.SECOND_PRICE;
import static com.diploma.noormal.util.Constants.SELECT_SHOW;
import static com.diploma.noormal.util.Constants.SELECT_SORT;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Controller
public class LaptopController {

    private LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String showLaptops(@RequestParam(value = CHECKBOX_PRODUCER, required = false) String[] producers,
                              @RequestParam(value = CHECKBOX_CATEGORY, required = false) String[] categories,
                              @RequestParam(value = FIRST_PRICE, required = false) Integer firstPrice,
                              @RequestParam(value = SECOND_PRICE, required = false) Integer secondPrice,
                              @RequestParam(value = SELECT_SORT, required = false) String orderBy,
                              @RequestParam(value = SELECT_SHOW, required = false) Integer showCount,
                              @RequestParam(value = PAGE, required = false) Integer page,
                              @RequestParam(value = ORDER_MODE, required = false) String orderMode, Model model) {
        laptopService.findLaptopsByCriteria(producers, categories, firstPrice,
                secondPrice, orderBy, showCount, page, orderMode, model);
        return "products";
    }
}
