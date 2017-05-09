package com.diploma.noormal.controller;

import com.diploma.noormal.exception.ProductNotFoundException;
import com.diploma.noormal.model.Product;
import com.diploma.noormal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.diploma.noormal.util.Constants.ControllerConstants.CHECKBOX_PRODUCER;
import static com.diploma.noormal.util.Constants.ControllerConstants.FIRST_PRICE;
import static com.diploma.noormal.util.Constants.ControllerConstants.ID_PRODUCT;
import static com.diploma.noormal.util.Constants.ControllerConstants.ORDER_MODE;
import static com.diploma.noormal.util.Constants.ControllerConstants.PAGE;
import static com.diploma.noormal.util.Constants.ControllerConstants.PRODUCT;
import static com.diploma.noormal.util.Constants.ControllerConstants.PRODUCT_NOT_FOUND;
import static com.diploma.noormal.util.Constants.ControllerConstants.SECOND_PRICE;
import static com.diploma.noormal.util.Constants.ControllerConstants.SELECT_SHOW;
import static com.diploma.noormal.util.Constants.ControllerConstants.SELECT_SORT;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String showLaptops(@RequestParam(value = CHECKBOX_PRODUCER, required = false) String[] producers,
                              @RequestParam(value = FIRST_PRICE, required = false) Integer firstPrice,
                              @RequestParam(value = SECOND_PRICE, required = false) Integer secondPrice,
                              @RequestParam(value = SELECT_SORT, required = false) String orderBy,
                              @RequestParam(value = SELECT_SHOW, required = false) Integer showCount,
                              @RequestParam(value = PAGE, required = false) Integer page,
                              @RequestParam(value = ORDER_MODE, required = false) String orderMode, Model model) {
        productService.findLaptopsByCriteria(producers, firstPrice,
                secondPrice, orderBy, showCount, page, orderMode, model);
        return "products";
    }

    @RequestMapping(value = "/single")
    public ModelAndView single(@RequestParam(value = ID_PRODUCT) Long idProduct){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findOne(idProduct);
        if(product == null){
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND);
        }
        modelAndView.addObject(PRODUCT, product);
        modelAndView.setViewName("single");
        return modelAndView;
    }
}
