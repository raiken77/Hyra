package com.attributegrouptest.Domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Noobs on 04/09/2016.
 */
@Entity
@Table(name = "Student")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;
    private String lastname;
    @Column(name = "phonenumber")
    private String phoneNumber;
    private String username;
    private String password;

    @Transient
    private String passwordConfirm;

    @Email
    private String email;

    @OneToMany(mappedBy = "rentee", cascade = CascadeType.ALL)
    private Set<Item> rentedItems;

    @OneToMany(mappedBy = "renter", cascade = CascadeType.ALL)
    private Set<Item> leasedItems;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "user_role",  joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User(String firstname, String lastname, String phoneNumber, String username, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String fullname()
    {
        return this.firstname + this.lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Item> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(Set<Item> rentedItems) {
        this.rentedItems = rentedItems;
    }

    public Set<Item> getLeasedItems() {
        return leasedItems;
    }

    public void setLeasedItems(Set<Item> leasedItems) {
        this.leasedItems = leasedItems;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
