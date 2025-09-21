package com.tns.fooddeliverysystem.services;
import com.tns.fooddeliverysystem.entities.*;
import java.util.*;

public class OrderService {
    private Map<Integer, Order> orders;
    private Map<Integer, DeliveryPerson> deliveryPersons;
    private static int orderCounter = 1;

    public OrderService(Map<Integer, Order> orders, Map<Integer, DeliveryPerson> deliveryPersons) {
        this.orders = orders;
        this.deliveryPersons = deliveryPersons;
    }

    public void placeOrder(Customer customer) {
        if (customer.getCart().getItems().isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        Order order = new Order(orderCounter++, customer);
        orders.put(order.getOrderId(), order);
        customer.getCart().getItems().clear();
        System.out.println("Order placed successfully! Your order ID is: " + order.getOrderId());
    }

    public void viewOrders() {
        System.out.println("Orders:");
        for (Order o : orders.values()) {
            System.out.println(o);
        }
    }

    public void viewCustomerOrders(int uid) {
        for (Order o : orders.values()) {
            if (o.getCustomer().getUserId() == uid) {
                System.out.println(o);
            }
        }
    }

    public void addDeliveryPerson(int did, String dname, long dno) {
        deliveryPersons.put(did, new DeliveryPerson(did, dname, dno));
        System.out.println("Delivery person added successfully!");
    }

    public void assignDelivery(int oid, int did) {
        if (orders.containsKey(oid) && deliveryPersons.containsKey(did)) {
            orders.get(oid).setDeliveryPerson(deliveryPersons.get(did));
            System.out.println("Delivery person assigned successfully!");
        } else {
            System.out.println("Invalid order or delivery person!");
        }
    }
}
