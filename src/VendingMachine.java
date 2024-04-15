import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	 private int waterQuantity;
	    private int coinsInserted;
	    private int totalSales;
	    private Map<String, Integer> productInventory;

	    public VendingMachine(int initialQuantity) {
	        waterQuantity = initialQuantity;
	        coinsInserted = 0;
	        totalSales = 0;
	        productInventory = new HashMap<>();
	    }

	    public void insertCoin(int coinValue) {
	        coinsInserted += coinValue;
	    }

	    public void dispenseWater() {
	        dispenseProduct("Water", 10);
	    }

	    public void dispenseProduct(String productName, int productPrice) {
	        if (productInventory.containsKey(productName)) {
	            int quantity = productInventory.get(productName);
	            if (quantity > 0) {
	                if (coinsInserted >= productPrice) {
	                    System.out.println("Here's your " + productName + ". Enjoy!");
	                    quantity--;
	                    coinsInserted -= productPrice;
	                    totalSales += productPrice;
	                    productInventory.put(productName, quantity);
	                } else {
	                    System.out.println("Please insert " + productPrice + " coins to get " + productName + ".");
	                }
	            } else {
	                System.out.println("Sorry, " + productName + " is out of stock.");
	            }
	        } else {
	            System.out.println("Invalid product.");
	        }
	    }

	    public void refillWater(int quantity) {
	        waterQuantity += quantity;
	        System.out.println("Water refilled. Current quantity: " + waterQuantity);
	    }

	    public void addProduct(String productName, int quantity) {
	        if (productInventory.containsKey(productName)) {
	            quantity += productInventory.get(productName);
	        }
	        productInventory.put(productName, quantity);
	        System.out.println("Product added: " + productName + ". Quantity: " + quantity);
	    }

	    public void removeProduct(String productName, int quantity) {
	        if (productInventory.containsKey(productName)) {
	            int currentQuantity = productInventory.get(productName);
	            if (currentQuantity >= quantity) {
	                currentQuantity -= quantity;
	                productInventory.put(productName, currentQuantity);
	                System.out.println("Product removed: " + productName + ". Quantity: " + quantity);
	            } else {
	                System.out.println("Invalid quantity. The current quantity of " + productName + " is " + currentQuantity);
	            }
	        } else {
	            System.out.println("Invalid product.");
	        }
	    }

	    public void checkSales() {
	        System.out.println("Total sales: " + totalSales + " coins");
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to the Vending Machine!");
	        System.out.print("Please enter the initial quantity of water: ");
	        int initialQuantity = scanner.nextInt();

	        VendingMachine vendingMachine = new VendingMachine(initialQuantity);

	        boolean exit = false;
	        while (!exit) {
	            System.out.println("1. Insert coin");
	            System.out.println("2. Dispense water");
	            System.out.println("3. Dispense product");
	            System.out.println("4. Refill water");
	            System.out.println("5. Add product");
	            System.out.println("6. Remove product");
	            System.out.println("7. Check sales");
	            System.out.println("8. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter the coin value: ");
	                    int coinValue = scanner.nextInt();
	                    vendingMachine.insertCoin(coinValue);
	                    break;
	                case 2:
	                    vendingMachine.dispenseWater();
	                    break;
	                case 3:
	                    System.out.print("Enter the product name: ");
	                    String product = scanner.next();
	                    System.out.print("Enter the product price: ");
	                    int price = scanner.nextInt();
	                    vendingMachine.dispenseProduct(product, price);
	                    break;
	                case 4:
	                    System.out.print("Enter the quantity of water to refill: ");
	                    int refillQuantity = scanner.nextInt();
	                    vendingMachine.refillWater(refillQuantity);
	                    break;
	                case 5:
	                    System.out.print("Enter the product name: ");
	                    String newProduct = scanner.next();
	                    System.out.print("Enter the quantity of the product to add: ");
	                    int productQuantity = scanner.nextInt();
	                    vendingMachine.addProduct(newProduct, productQuantity);
	                    break;
	                case 6:
	                    System.out.print("Enter the product name: ");
	                    String removeProduct =scanner.next();
	                    System.out.print("Enter the quantity of the product to remove: ");
	                    int removeQuantity = scanner.nextInt();
	                    vendingMachine.removeProduct(removeProduct, removeQuantity);
	                    break;
	                case 7:
	                    vendingMachine.checkSales();
	                    break;
	                case 8:
	                    exit = true;
	                    System.out.println("Thank you for using the Vending Machine!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	        scanner.close();
	    }

}

