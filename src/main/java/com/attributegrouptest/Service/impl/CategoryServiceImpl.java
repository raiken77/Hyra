package com.attributegrouptest.Service.impl;

import com.attributegrouptest.Domain.Category;
import com.attributegrouptest.Domain.Repository.CategoryRepository;
import com.attributegrouptest.Service.blueprint.CategoryService;
import com.attributegrouptest.Utility.IterableConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noobs on 05/09/2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return IterableConverter.createList(categoryRepository.findAll());
    }

    @Override
    public void addCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        return this.categoryRepository.findOne(id);
    }

    @Override
    public Category getByType(String type) {
        return this.categoryRepository.findByType(type);
    }

    //    private List<Category> populateList(Iterable<Category> categoriesItems)
//    {
//        List<Category> categoriesList = new ArrayList<>();
//
//        categoriesItems.forEach(item ->
//        {
//            categoriesList.add(item);
//        });
//    }
}
