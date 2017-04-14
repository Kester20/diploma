package com.diploma.noormal.controller;

import com.diploma.noormal.model.Category;
import com.diploma.noormal.repository.CategoryRepository;
import com.diploma.noormal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Arsalan. Created on 13.04.2017.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    public @ResponseBody
    Iterable<Category> hello() {
        return categoryService.getAllCategories();
    }
}
