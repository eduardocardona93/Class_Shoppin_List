package com.example.class_shoppin_list;

public class cartItem {
    private String name;
    private double price;
    private int quantity;

    public cartItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
