package com.attributegrouptest.Service.blueprint;

import com.attributegrouptest.Domain.Item;
import org.springframework.stereotype.Service;

/**
 * Created by Noobs on 05/09/2016.
 */
public interface ItemService {

    void saveItem(Item item);
    Item findById(Long id);

}
