package com.attributegrouptest.Domain.Repository;

import com.attributegrouptest.Domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Noobs on 05/09/2016.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    Category findByType(String type);
}
