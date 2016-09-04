package com.attributegrouptest.Domain;

import com.attributegrouptest.Enums.CategoryType;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Noobs on 04/09/2016.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private CategoryType type;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Item> items;

    public Category(CategoryType type) {
        this.type = type;
    }

    public Category()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
