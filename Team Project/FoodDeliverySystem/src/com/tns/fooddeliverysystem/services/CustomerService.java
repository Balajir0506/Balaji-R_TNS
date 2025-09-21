package com.tns.fooddeliverysystem.services;
import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.FoodItem;

import java.util.Map;

public class CustomerService {
    private Map<Integer, Customer> customers;

    public CustomerService(Map<Integer, Customer> customers) {
        this.customers = customers;
    }
    


    public void addCustomer(int uid, String uname, long cno) {
        if (customers.containsKey(uid)) {
            System.out.println("Customer with this ID already exists!");
            return;
        }
        customers.put(uid, new Customer(uid, uname, cno));
        System.out.println("Customer created successfully!");
    }

    
    public Customer getCustomer(int uid) {
        return customers.get(uid);
    }

   
    public void addFoodToCart(int uid, FoodItem food, int qty) {
        if (food == null) {
            System.out.println("Invalid Food Item!");
            return;
        }
        Customer c = customers.get(uid);
        if (c != null) {
            c.getCart().addItem(food, qty);
            System.out.println("Food item added to cart!");
        } else {
            System.out.println("Customer not found!");
        }
    }

    
    public void viewCart(int uid) {
        Customer c = customers.get(uid);
        if (c != null) {
            System.out.println(c.getCart());
        } else {
            System.out.println("Customer not found!");
        }
    }
}