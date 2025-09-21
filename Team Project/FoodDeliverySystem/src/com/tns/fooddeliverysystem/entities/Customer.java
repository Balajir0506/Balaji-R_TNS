package com.tns.fooddeliverysystem.entities;

public class Customer extends User {
    private Cart cart = new Cart();

    public Customer(int userId, String username, long contactNo) {
        super(userId, username, contactNo);
    }

    public Cart getCart() {
        return cart;
    }
}
