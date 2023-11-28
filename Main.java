import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for items that can be purchased
interface Purchasable {
    void purchase(int quantity);
}

// Interface for items that can be sold
interface Saleable {
    void sell(int quantity);
}

// Abstract class representing a product
abstract class Product {
    protected String productID;
    protected String productName;
    protected int quantity;
    protected double price;

    public Product(String productID, String productName, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public abstract void displayDetails();

    public double calculateValue() {
        return quantity * price;
    }
}

// Concrete class for Electronics
class Electronics extends Product implements Purchasable, Saleable {
    private String brand;

    public Electronics(String productID, String productName, int quantity, double price, String brand) {
        super(productID, productName, quantity, price);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Brand: " + brand);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
    }

    @Override
    public void purchase(int purchaseQuantity) {
        quantity += purchaseQuantity;
    }

    @Override
    public void sell(int sellQuantity) {
        if (sellQuantity <= quantity) {
            quantity -= sellQuantity;
        } else {
            System.out.println("Not enough stock available.");
        }
    }
}

// Concrete class for Clothings
class Clothings extends Product implements Purchasable, Saleable {
    private String size;

    public Clothings(String productID, String productName, int quantity, double price, String size) {
        super(productID, productName, quantity, price);
        this.size = size;
    }

    @Override
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Size: " + size);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
    }

    @Override
    public void purchase(int purchaseQuantity) {
        quantity += purchaseQuantity;
    }

    @Override
    public void sell(int sellQuantity) {
        if (sellQuantity <= quantity) {
            quantity -= sellQuantity;
        } else {
            System.out.println("Not enough stock available.");
        }
    }
}

// Concrete class for Food
class Food extends Product implements Purchasable, Saleable {
    private String expirationDate;

    public Food(String productID, String productName, int quantity, double price, String expirationDate) {
        super(productID, productName, quantity, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
    }

    @Override
    public void purchase(int purchaseQuantity) {
        quantity += purchaseQuantity;
    }

    @Override
    public void sell(int sellQuantity) {
        if (sellQuantity <= quantity) {
            quantity -= sellQuantity;
        } else {
            System.out.println("Not enough stock available.");
        }
    }
}

// Inventory management system
class InventoryManagementSystem {
    private List<Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void removeProduct(String productID) {
        inventory.removeIf(product -> product.productID.equals(productID));
    }

    public void updateProductQuantity(String productID, int newQuantity) {
        for (Product product : inventory) {
            if (product.productID.equals(productID)) {
                product.quantity = newQuantity;
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        for (Product product : inventory) {
            totalValue += product.calculateValue();
        }
        return totalValue;
    }

    public void displayInventory() {
        for (Product product : inventory) {
            product.displayDetails();
            System.out.println("---------------");
        }
    }
}

// Main class for console interface
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Example usage
        Electronics laptop = new Electronics("E001", "Laptop", 10, 899.99, "HP");
        Clothings shirt = new Clothings("C001", "T-Shirt", 20, 19.99, "L");
        Food apple = new Food("F001", "Apple", 50, 1.99, "2023-12-31");

        ims.addProduct(laptop);
        ims.addProduct(shirt);
        ims.addProduct(apple);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Calculate Total Value");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product type (E for Electronics, C for Clothings, F for Food): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    if (type.equals("E")) {
                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();
                        ims.addProduct(new Electronics(id, name, quantity, price, brand));
                    } else if (type.equals("C")) {
                        System.out.print("Enter size: ");
                        String size = scanner.nextLine();
                        ims.addProduct(new Clothings(id, name, quantity, price, size));
                    } else if (type.equals("F")) {
                        System.out.print("Enter expiration date: ");
                        String expirationDate = scanner.nextLine();
                        ims.addProduct(new Food(id, name, quantity, price, expirationDate));
                    } else {
                        System.out.println("Invalid product type.");
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    String updateID = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    ims.updateProductQuantity(updateID, newQuantity);
                    break;
                case 3:
                    System.out.print("Enter product ID: ");
                    String removeID = scanner.nextLine();
                    ims.removeProduct(removeID);
                    break;
                case 4:
                    ims.displayInventory();
                    break;
                case 5:
                    System.out.println("Total inventory value: $" + ims.calculateTotalValue());
                    break;
                case 6:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}