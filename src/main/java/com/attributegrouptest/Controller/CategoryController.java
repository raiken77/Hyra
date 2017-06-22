package com.attributegrouptest.Controller;

import com.attributegrouptest.Domain.Category;
import com.attributegrouptest.Enums.CategoryType;
import com.attributegrouptest.Service.blueprint.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Noobs on 05/09/2016.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCategories()
    {
        return "category/index";

    }

    @RequestMapping(value = "/{id}")
    public String getCategory(@PathVariable("id") Long categoryId, Model model)
    {
        Category category = categoryService.getCategory(categoryId);
        model.addAttribute("category", category);
        return "category/show";

    }

    @RequestMapping(value = "/setup",method = RequestMethod.GET)
    public String populateDatabase()
    {

        Category category = new Category(CategoryType.LAPTOP.toString());
        categoryService.addCategory(category);
        category = new Category(CategoryType.ARDUINO.toString());
        categoryService.addCategory(category);

        return "category/index";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories()
    {
        return this.categoryService.getAllCategories();
    }


}
