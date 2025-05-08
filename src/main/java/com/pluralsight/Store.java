package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import com.pluralsight.Product;

public class Store {
    public static void main(String[] args) {
        // Initialize variables
        ArrayList<Product> inventory = new ArrayList<Product>();
        ArrayList<Product> cart = new ArrayList<Product>();
        double totalAmount = 0.0;

        // Load inventory from CSV file
        loadInventory("products.csv", inventory);

        // Create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Display menu and get user choice until they choose to exit
        while (choice != 3) {
            System.out.println("Welcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            // Call the appropriate method based on user choice
            switch (choice) {
                case 1:
                    displayProducts(inventory, cart, scanner);
                    break;
                case 2:
                    displayCart(cart, scanner, totalAmount);
                    break;
                case 3:
                    checkOut(cart, totalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        try {
            Scanner fileScanner = new Scanner(new java.io.File(fileName));

            // Skip the header line
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    Product product = new Product(id, name, price);
                    inventory.add(product);
                }
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
        // This method should read a CSV file with product information and
        // populate the inventory ArrayList with com.pluralsight.Product objects. Each line
        // of the CSV file contains product information in the following format:
        //
        // id,name,price
        //
        // where id is a unique string identifier, name is the product name,
        // price is a double value representing the price of the product
    }

    public static void displayProducts(ArrayList<Product> inventory, ArrayList<Product> cart, Scanner scanner) {
        System.out.println("\n--- Available Products ---");
        for (Product product : inventory) {
            System.out.println(product);
        }

        System.out.print("\nEnter the product ID to add to cart (or type 'back' to return): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("back")) {
            return;
        }

        Product selectedProduct = findProductById(input, inventory);

        if (selectedProduct != null) {
            cart.add(selectedProduct);
            System.out.println("Product added to cart: " + selectedProduct.getName());
        } else {
            System.out.println("Product not found.");
        }

        // This method should display a list of products from the inventory,
        // and prompt the user to add items to their cart. The method should
        // prompt the user to enter the ID of the product they want to add to
        // their cart. The method should
        // add the selected product to the cart ArrayList.
    }

    public static void displayCart(ArrayList<Product> cart, Scanner scanner, double totalAmount) {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }

        System.out.println("\n--- Your Shopping Cart ---");
        totalAmount = 0;
        for (Product product : cart) {
            System.out.println(product);
            totalAmount += product.getPrice();
        }

        System.out.printf("Total Amount: $%.2f\n", totalAmount);

        System.out.print("\nEnter the ID of a product to remove (or type 'back' to return): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("back")) {
            return;
        }

        Product toRemove = findProductById(input, cart);
        if (toRemove != null) {
            cart.remove(toRemove);
            System.out.println("Product removed from cart: " + toRemove.getName());
        } else {
            System.out.println("Product not found in cart.");
        }
        // This method should display the items in the cart ArrayList, along
        // with the total cost of all items in the cart. The method should
        // prompt the user to remove items from their cart by entering the ID
        // of the product they want to remove. The method should update the cart ArrayList and totalAmount
        // variable accordingly.
    }

    public static void checkOut(ArrayList<Product> cart, double totalAmount) {
        if (cart.isEmpty()) {
            System.out.println("\nCart is empty. Nothing to check out.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        totalAmount = 0;

        for (Product product : cart) {
            totalAmount += product.getPrice();
        }

        System.out.printf("\nYour total is: $%.2f\n", totalAmount);
        System.out.print("Enter payment amount: ");
        double payment = scanner.nextDouble();

        if (payment >= totalAmount) {
            double change = payment - totalAmount;
            System.out.printf("Payment accepted. Your change: $%.2f\n", change);

            System.out.println("\n--- Receipt ---");
            for (Product product : cart) {
                System.out.println(product);
            }
            System.out.printf("Total: $%.2f\nChange: $%.2f\n", totalAmount, change);

            cart.clear();
        } else {
            System.out.println("Insufficient payment. Checkout cancelled.");
        }
        // This method should calculate the total cost of all items in the cart,
        // and display a summary of the purchase to the user. The method should
        // prompt the user to confirm the purchase, and calculate change and clear the cart
        // if they confirm.
    }

    public static Product findProductById(String id, ArrayList<Product> inventory) {
        for (Product product : inventory) {
            if (product.getSku().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
        // This method should search the inventory ArrayList for a product with
        // the specified ID, and return the corresponding com.pluralsight.Product object. If
        // no product with the specified ID is found, the method should return
        // null.
    }
}







