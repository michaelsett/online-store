Online Store

Description of the Project

This is a Java-based console application that simulates an online store. Users can view available products, add them to a shopping cart, remove items, and proceed to checkout. The application reads product information from a CSV file and handles user input interactively.

This project is ideal for anyone learning Java and looking to explore file handling, array lists, and console-based user interaction.

Class Diagram

Main Classes:

Store: Main application class that manages the menu, cart, and user interactions.

Product: Represents a product with ID (SKU), name, and price.

User Stories

As a user, I want to view available products so I can decide what to purchase.

As a user, I want to add products to my cart so I can buy them later.

As a user, I want to see what's in my cart so I can review it.

As a user, I want to remove items from my cart if I change my mind.

As a user, I want to check out and pay for my items.

As a user, I want to be notified if I enter an invalid product ID.

As a user, I want the app to be easy to understand and navigate.

Setup

Prerequisites

IntelliJ IDEA: Download and install IntelliJ IDEA

Java SDK: Make sure Java 17 is installed

Running the App

Open the project folder in IntelliJ

Run the Store.java file (contains the main method)

Follow prompts in the terminal to use the store

Technologies Used

Java 17

Built-in Java utilities (Scanner, ArrayList, File)

Interesting Code Highlight

The checkOut() Method

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
}

Why It’s Interesting

This method effectively combines multiple concepts:

Looping through collections to calculate totals

Input validation and error handling

Conditional logic to check if payment is sufficient

Clear communication with the user including formatting and receipt output

State management by clearing the cart on successful checkout

It showcases real-world logic applied in a simple, readable way that’s extendable for features like tax, discounts, or digital receipts.

Future Work

Add quantity selection for each product

Store purchase history in a file

Add categories and filtering

<<<<<<< HEAD
Implement a basic GUI using JavaFX
=======
Implement a basic GUI 
>>>>>>> a2c346842c8f83a7550ca6569f8e11ad20cf423c

Resources

Java documentation and examples from official Oracle docs

Instructor-led guidance and Pluralsight tutorials

Team Members

Michael Settle – Coded and tested the application

Thanks

Big thanks to our instructor and peers for guidance, support, and feedback throughout the development!
