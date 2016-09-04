package com.attributegrouptest.Domain;

import com.attributegrouptest.Enums.ItemCondition;

import javax.persistence.*;

/**
 * Created by Noobs on 04/09/2016.
 */
@Entity
@Table(name = "Item")
public class Item {

    @Column(name = "Item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;

    @Enumerated(EnumType.STRING)
    private ItemCondition condition;

    @Column(name = "rent_price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private User renter;


    @ManyToOne
    @JoinColumn(name = "rentee_id")
    private User rentee;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Item(String description, ItemCondition condition, double price, User renter, User rentee, Category category) {
        this.description = description;
        this.condition = condition;
        this.price = price;
        this.renter = renter;
        this.rentee = rentee;
        this.category = category;
    }

    public Item()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemCondition getCondition() {
        return condition;
    }

    public void setCondition(ItemCondition condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }

    public User getRentee() {
        return rentee;
    }

    public void setRentee(User rentee) {
        this.rentee = rentee;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
