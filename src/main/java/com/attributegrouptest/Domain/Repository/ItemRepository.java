package com.attributegrouptest.Domain.Repository;

import com.attributegrouptest.Domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Noobs on 05/09/2016.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {

    List<Item> findByDescriptionContaining(String query);
    List<Item> findByRenteeIsNull();

}
