package com.pluralsight;

public class Product {
    private String sku;          // SKU or product ID
    private String name;        // Name of the product
    private double price;       // Price of the product

    // Constructor
    public Product(String sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setters (optional if you don’t plan to modify products after creation)
    public void setId(String id) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // String representation for easy printing
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Price: $%.2f", sku, name, price);
    }
}
