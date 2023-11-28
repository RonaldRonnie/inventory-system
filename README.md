#Inventory Management System

This Java program implements an inventory management system that allows you to manage products, including adding, updating, removing, and viewing products. It also calculates the total value of the inventory.

Features:

    Add, update, and remove products
    View inventory details
    Calculate total inventory value

Usage:

    Compile the Java code using the following command:

javac InventoryManagementSystem.java

    Run the compiled program using the following command:

java Main

    Follow the instructions on the console to manage your inventory.

Example Usage:

1. Add Product
Enter product type (E for Electronics, C for Clothings, F for Food): E
Enter product ID: E001
Enter product name: Laptop
Enter quantity: 10
Enter price: 899.99
Enter brand: HP

2. Add Product
Enter product type (E for Electronics, C for Clothings, F for Food): C
Enter product ID: C001
Enter product name: T-Shirt
Enter quantity: 20
Enter price: 19.99
Enter size: L

3. Add Product
Enter product type (E for Electronics, C for Clothings, F for Food): F
Enter product ID: F001
Enter product name: Apple
Enter quantity: 50
Enter price: 1.99
Enter expiration date: 2023-12-31

4. View Inventory
Product ID: E001
Product Name: Laptop
Brand: HP
Quantity: 10
Price: $899.99
---------------

Product ID: C001
Product Name: T-Shirt
Size: L
Quantity: 20
Price: $19.99
---------------

Product ID: F001
Product Name: Apple
Expiration Date: 2023-12-31
Quantity: 50
Price: $1.99
---------------

5. Calculate Total Value
Total inventory value: $1039.96

Additional Notes:

    The program stores product information in an ArrayList.
    The program uses interfaces to define common behaviors for different types of products.
    The program uses a Scanner object to read input from the console.
