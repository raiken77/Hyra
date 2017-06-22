package com.attributegrouptest.Service.impl;

import com.attributegrouptest.Domain.Item;
import com.attributegrouptest.Domain.Repository.ItemRepository;
import com.attributegrouptest.Service.blueprint.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Noobs on 05/09/2016.
 */
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findOne(id);
    }
}
