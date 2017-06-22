package com.attributegrouptest.strategy.Search;

import com.attributegrouptest.Domain.Item;

import java.util.List;

/**
 * Created by Noobs on 07/09/2016.
 */
public abstract class SearchStrategy {

    abstract List<Item> searchItems(List<Item> items, String query);

}
