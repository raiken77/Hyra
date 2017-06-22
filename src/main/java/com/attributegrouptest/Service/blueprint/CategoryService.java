package com.attributegrouptest.Service.blueprint;

import com.attributegrouptest.Domain.Category;
import java.util.List;

/**
 * Created by Noobs on 05/09/2016.
 */
public interface CategoryService {

    List<Category> getAllCategories();

    void addCategory(Category category);

    Category getCategory(Long id);

    Category getByType(String type);

}
