package com.attributegrouptest.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noobs on 05/09/2016.
 */
public class IterableConverter {


    public static <T> List<T> createList(Iterable<T> iterator)
    {
        List<T> list = new ArrayList<T>();

        iterator.forEach(item ->
        {
            list.add(item);
        });

        return list;
    }
}
