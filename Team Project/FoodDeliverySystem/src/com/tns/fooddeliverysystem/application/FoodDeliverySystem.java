package com.tns.fooddeliverysystem.application;

import com.tns.fooddeliverysystem.entities.*;
import com.tns.fooddeliverysystem.services.*;
import java.util.*;

public class FoodDeliverySystem {
    private static Map<Integer, Restaurant> restaurants = new HashMap<>();
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static Map<Integer, DeliveryPerson> deliveryPersons = new HashMap<>();
    private static Map<Integer, Order> orders = new HashMap<>();

    
    private static FoodService foodService = new FoodService(restaurants);
    private static CustomerService customerService = new CustomerService(customers);
    private static OrderService orderService = new OrderService(orders, deliveryPersons);

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Admin Menu\n2. Customer Menu\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: adminMenu(); break;
                case 2: customerMenu(); break;
                case 3: System.out.println("Exiting System..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item");
            System.out.println("3. Remove Food Item");
            System.out.println("4. View Restaurants");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery");
            System.out.println("8. Exit");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Restaurant Name: ");
                    String rname = sc.nextLine();
                    foodService.addRestaurant(rid, rname);
                    break;
                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    rid = sc.nextInt();
                    System.out.print("Enter Food ID: ");
                    int fid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Food Name: ");
                    String fname = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    foodService.addFoodItem(rid, fid, fname, price);
                    break;
                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    rid = sc.nextInt();
                    System.out.print("Enter Food ID: ");
                    fid = sc.nextInt();
                    foodService.removeFoodItem(rid, fid);
                    break;
                case 4: 
                    foodService.viewRestaurants(); 
                    break;
                case 5: 
                    orderService.viewOrders(); 
                    break;
                case 6:
                    System.out.print("Enter Delivery Person ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    long dno = sc.nextLong();
                    orderService.addDeliveryPerson(did, dname, dno);
                    break;
                case 7:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();
                    System.out.print("Enter Delivery Person ID: ");
                    did = sc.nextInt();
                    orderService.assignDelivery(oid, did);
                    break;
                case 8: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

   
    private static void customerMenu() {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    long cno = sc.nextLong();
                    customerService.addCustomer(uid, uname, cno);
                    break;
                case 2: 
                    foodService.viewRestaurants(); 
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    uid = sc.nextInt();
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt();
                    System.out.print("Enter Food ID: ");
                    int fid = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    FoodItem item = foodService.findFoodItem(rid, fid);
                    customerService.addFoodToCart(uid, item, qty);
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    uid = sc.nextInt();
                    customerService.viewCart(uid);
                    break;
                case 5:
                    System.out.print("Enter Customer ID: ");
                    uid = sc.nextInt();
                    Customer c = customerService.getCustomer(uid);
                    orderService.placeOrder(c);
                    break;
                case 6:
                    System.out.print("Enter Customer ID: ");
                    uid = sc.nextInt();
                    orderService.viewCustomerOrders(uid);
                    break;
                case 7: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}

