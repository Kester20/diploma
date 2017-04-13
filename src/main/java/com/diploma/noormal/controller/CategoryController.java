package com.diploma.noormal.controller;

import com.diploma.noormal.model.Category;
import com.diploma.noormal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Arsalan
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/categories")
    public @ResponseBody
    Iterable<Category> hello() {
        return categoryRepository.findAll();
    }
}
