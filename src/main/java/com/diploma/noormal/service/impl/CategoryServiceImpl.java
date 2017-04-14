package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Category;
import com.diploma.noormal.repository.CategoryRepository;
import com.diploma.noormal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
}
