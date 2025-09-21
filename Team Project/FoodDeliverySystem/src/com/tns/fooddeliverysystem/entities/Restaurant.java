package com.tns.fooddeliverysystem.entities;

import java.util.*;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu = new ArrayList<>();

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<FoodItem> getMenu() { return menu; }

    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    public void removeFoodItem(int foodItemId) {
        menu.removeIf(f -> f.getId() == foodItemId);
    }

    @Override
    public String toString() {
        return "Restaurant{id=" + id + ", name='" + name + "'}";
    }
}
