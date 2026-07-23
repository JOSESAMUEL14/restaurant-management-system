package service;

import model.*;
import admin.Admin;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Restaurant {
    private Menu menu;
    private Cart cart;
    private Bill bill;
    private Admin admin;
    private FileManager fileManager;
    private int orderCounter;
    private double totalSales;
    private ArrayList<Table> tables;
    private ArrayList<Order> orderHistory;
    
    public Restaurant() {
        this.menu = new Menu();
        this.cart = new Cart();
        this.bill = new Bill();
        this.admin = new Admin(menu);
        this.fileManager = new FileManager();
        this.orderCounter = 1000;
        this.totalSales = 0;
        this.orderHistory = new ArrayList<>();
        initializeTables();
    }
    
    private void initializeTables() {
        tables = new ArrayList<>();
        tables.add(new Table(1, 2));
        tables.add(new Table(2, 2));
        tables.add(new Table(3, 4));
        tables.add(new Table(4, 4));
        tables.add(new Table(5, 6));
        tables.add(new Table(6, 6));
        tables.add(new Table(7, 8));
        tables.add(new Table(8, 8));
    }
    
    public void customerSection() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        
        while (!back) {
            System.out.println("\n================================================");
            System.out.println("               CUSTOMER SECTION");
            System.out.println("================================================");
            System.out.println(" 1. View Full Menu");
            System.out.println(" 2. View by Category");
            System.out.println(" 3. View Today's Special");
            System.out.println(" 4. Search Food");
            System.out.println(" 5. Place Order");
            System.out.println(" 6. View Cart");
            System.out.println(" 7. View Order History");
            System.out.println(" 8. Table Booking");
            System.out.println(" 9. Today's Offers");
            System.out.println("10. Back to Main Menu");
            System.out.println("================================================");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    menu.displayMenu();
                    break;
                    
                case 2:
                    displayCategoryMenu();
                    break;
                    
                case 3:
                    menu.displaySpecial();
                    break;
                    
                case 4:
                    searchFood();
                    break;
                    
                case 5:
                    placeOrder();
                    break;
                    
                case 6:
                    cart.viewCart();
                    break;
                    
                case 7:
                    viewCustomerOrderHistory();
                    break;
                    
                case 8:
                    tableBooking();
                    break;
                    
                case 9:
                    displayDailyOffers();
                    break;
                    
                case 10:
                    back = true;
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    private void displayCategoryMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n================================================");
        System.out.println("               SELECT CATEGORY");
        System.out.println("================================================");
        System.out.println("1. Starter");
        System.out.println("2. Main Course");
        System.out.println("3. South Indian");
        System.out.println("4. Dessert");
        System.out.println("5. Beverage");
        System.out.println("6. Special");
        System.out.print("Enter your choice: ");
        int catChoice = scanner.nextInt();
        scanner.nextLine();
        
        String category = "";
        switch (catChoice) {
            case 1: category = "Starter"; break;
            case 2: category = "Main Course"; break;
            case 3: category = "South Indian"; break;
            case 4: category = "Dessert"; break;
            case 5: category = "Beverage"; break;
            case 6: category = "Special"; break;
            default: System.out.println("Invalid choice!");
        }
        
        if (!category.isEmpty()) {
            menu.displayByCategory(category);
        }
    }
    
    private void searchFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter food name to search: ");
        String searchTerm = scanner.nextLine();
        FoodItem found = menu.searchFoodItem(searchTerm);
        if (found != null) {
            System.out.println("\nFound: " + found.getName() + " - Rs." + found.getPrice());
        } else {
            System.out.println("\nNo item found with that name.");
        }
    }
    
    private void displayFilteredMenu(String preference) {
        System.out.println("\n================================================");
        if (preference.equals("Both")) {
            System.out.println("          COMPLETE MENU (Veg & Non-Veg)");
        } else {
            System.out.println("          " + preference.toUpperCase() + " ONLY MENU");
        }
        System.out.println("================================================");
        System.out.printf("%-6s %-25s %-15s %-10s %-10s%n", "ID", "Item Name", "Category", "Type", "Price");
        System.out.println("------------------------------------------------");
        
        for (FoodItem item : menu.getFoodItems()) {
            if (preference.equals("Both") || item.getType().equals(preference)) {
                String specialTag = item.isSpecial() ? " *" : "";
                System.out.printf("%-6d %-25s %-15s %-10s Rs.%-9.2f%s%n", 
                                 item.getId(), 
                                 item.getName(), 
                                 item.getCategory(), 
                                 item.getType(), 
                                 item.getPrice(),
                                 specialTag);
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("* = Today's Special");
    }
    
    private void displayDailyOffers() {
        System.out.println("\n================================================");
        System.out.println("               TODAY'S OFFERS");
        System.out.println("================================================");
        System.out.println("  Monday    : 5% OFF on all items");
        System.out.println("  Tuesday   : Buy 2 Get 1 Free on Desserts");
        System.out.println("  Wednesday : 10% OFF on South Indian dishes");
        System.out.println("  Thursday  : 15% OFF on Main Course");
        System.out.println("  Friday    : 20% OFF on Starters");
        System.out.println("  Weekend   : 10% OFF on all items");
        System.out.println("");
        System.out.println("  COMBO OFFERS:");
        System.out.println("  3+ items  : 10% OFF on total bill");
        System.out.println("  4+ items  : 20% OFF on total bill");
        System.out.println("");
        System.out.println("  Loyalty Points:");
        System.out.println("  Earn 10 points for every Rs.100 spent");
        System.out.println("  100 points = Rs.10 discount on next order");
        System.out.println("================================================");
    }
    
    private void tableBooking() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n================================================");
        System.out.println("               TABLE BOOKING");
        System.out.println("================================================");
        System.out.println("Available Tables:");
        System.out.println("------------------------------------------------");
        
        boolean hasAvailable = false;
        for (Table table : tables) {
            if (!table.isBooked()) {
                table.displayTable();
                hasAvailable = true;
            }
        }
        
        if (!hasAvailable) {
            System.out.println("No tables available at the moment.");
            return;
        }
        
        System.out.println("------------------------------------------------");
        System.out.print("Enter table number to book: ");
        int tableNo = scanner.nextInt();
        scanner.nextLine();
        
        Table selectedTable = null;
        for (Table table : tables) {
            if (table.getTableNumber() == tableNo && !table.isBooked()) {
                selectedTable = table;
                break;
            }
        }
        
        if (selectedTable == null) {
            System.out.println("Table not available or invalid number!");
            return;
        }
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String currentTime = sdf.format(new Date());
        
        selectedTable.setBooked(true);
        selectedTable.setBookedBy(name);
        selectedTable.setBookingTime(currentTime);
        selectedTable.setCustomerPhone(phone);
        
        System.out.println("\nTable " + tableNo + " booked successfully!");
        System.out.println("Booking Details:");
        System.out.println("   Name: " + name);
        System.out.println("   Phone: " + phone);
        System.out.println("   Time: " + currentTime);
        System.out.println("   Capacity: " + selectedTable.getCapacity() + " people");
    }
    
    private void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n================================================");
        System.out.println("               PLACE ORDER");
        System.out.println("================================================");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        
        System.out.println("\nOrder Type:");
        System.out.println("1. Dine-in");
        System.out.println("2. Takeaway");
        System.out.print("Enter choice: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();
        
        String orderType = (typeChoice == 1) ? "Dine-in" : "Takeaway";
        
        Customer customer = new Customer(name, phone, orderType);
        
        // Veg/Non-Veg Preference
        System.out.println("\nSelect Food Preference:");
        System.out.println("1. Vegetarian Only");
        System.out.println("2. Non-Vegetarian Only");
        System.out.println("3. Both (Show All Items)");
        System.out.print("Enter choice: ");
        int preferenceChoice = scanner.nextInt();
        scanner.nextLine();
        
        String preference = "";
        switch (preferenceChoice) {
            case 1: preference = "Veg"; break;
            case 2: preference = "Non-Veg"; break;
            case 3: preference = "Both"; break;
            default: preference = "Both";
        }
        
        // Table selection for dine-in
        String tableNumber = "Not Assigned";
        if (orderType.equals("Dine-in")) {
            System.out.println("\nSelect Table (Enter table number):");
            for (Table table : tables) {
                if (!table.isBooked()) {
                    table.displayTable();
                }
            }
            System.out.print("Enter table number (0 to skip): ");
            int tableNo = scanner.nextInt();
            scanner.nextLine();
            if (tableNo > 0) {
                for (Table table : tables) {
                    if (table.getTableNumber() == tableNo && !table.isBooked()) {
                        table.setBooked(true);
                        table.setBookedBy(name);
                        table.setCustomerPhone(phone);
                        tableNumber = String.valueOf(tableNo);
                        System.out.println("Table " + tableNo + " assigned!");
                        break;
                    }
                }
            }
        }
        
        boolean ordering = true;
        while (ordering) {
            displayFilteredMenu(preference);
            System.out.print("\nEnter item ID to add (0 to finish): ");
            int itemId = scanner.nextInt();
            scanner.nextLine();
            
            if (itemId == 0) {
                if (cart.isEmpty()) {
                    System.out.println("Cart is empty! Add some items first.");
                    return;
                }
                ordering = false;
                break;
            }
            
            FoodItem item = menu.getItemById(itemId);
            if (item == null) {
                System.out.println("Invalid item ID!");
                continue;
            }
            
            if (!preference.equals("Both")) {
                if (!item.getType().equals(preference)) {
                    System.out.println("Sorry! This item doesn't match your preference (" + preference + " only).");
                    continue;
                }
            }
            
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than 0!");
                continue;
            }
            
            cart.addItem(item, quantity);
            
            System.out.print("Add more items? (y/n): ");
            String more = scanner.nextLine();
            if (more.equalsIgnoreCase("n")) {
                ordering = false;
            }
        }
        
        cart.viewCart();
        
        // Special instructions
        System.out.print("\nAny special instructions? (Press Enter to skip): ");
        String instructions = scanner.nextLine();
        
        System.out.print("\nConfirm order? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (!confirm.equalsIgnoreCase("y")) {
            cart.clearCart();
            System.out.println("Order cancelled!");
            return;
        }
        
        orderCounter++;
        Order order = new Order(orderCounter, customer);
        
        for (int i = 0; i < cart.getItems().size(); i++) {
            order.addItem(cart.getItems().get(i), cart.getQuantities().get(i));
        }
        
        order.setSpecialInstructions(instructions);
        order.setTableNumber(tableNumber);
        order.calculateTotal();
        
        System.out.println("\n================================================");
        System.out.println("                  PAYMENT");
        System.out.println("================================================");
        System.out.println("1. Cash");
        System.out.println("2. UPI");
        System.out.println("3. Debit/Credit Card");
        System.out.print("Select payment method: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();
        
        String paymentMethod = "";
        switch (paymentChoice) {
            case 1: paymentMethod = "Cash"; break;
            case 2: paymentMethod = "UPI"; break;
            case 3: paymentMethod = "Card"; break;
            default: paymentMethod = "Cash";
        }
        
        order.setPaymentMethod(paymentMethod);
        
        // Loyalty points
        int pointsEarned = (int)(order.getGrandTotal() / 10);
        customer.addLoyaltyPoints(pointsEarned);
        
        bill.generateBill(order);
        
        System.out.print("Please rate us (1-5 stars): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        if (rating >= 1 && rating <= 5) {
            order.setCustomerRating(rating);
        }
        
        order.setStatus("Completed");
        
        // Update order status
        for (int i = 0; i < 4; i++) {
            order.updateStatus();
        }
        
        totalSales += order.getGrandTotal();
        
        fileManager.saveOrder(order);
        orderHistory.add(order);
        customer.addOrderToHistory("Order #" + orderCounter + " - Rs." + order.getGrandTotal());
        
        cart.clearCart();
        
        System.out.println("\n================================================");
        System.out.println("           PAYMENT SUCCESSFUL!");
        System.out.println("================================================");
        System.out.println("Thank you for your order, " + name + "!");
        System.out.println("Order Number: #" + orderCounter);
        System.out.println("Estimated preparation time: 20-25 minutes");
        System.out.println("Loyalty Points Earned: " + pointsEarned);
        System.out.println("Total Points: " + customer.getLoyaltyPoints());
        System.out.println("================================================");
    }
    
    private void viewCustomerOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("\nNo orders found in history.");
            return;
        }
        
        System.out.println("\n================================================");
        System.out.println("             YOUR ORDER HISTORY");
        System.out.println("================================================");
        for (Order order : orderHistory) {
            System.out.println("Order #" + order.getOrderNumber() + " | " + 
                             order.getFormattedDate() + " | " +
                             "Rs." + order.getGrandTotal() + " | " +
                             "Rating: " + order.getCustomerRating() + "/5");
        }
        System.out.println("================================================");
    }
    
    public void adminSection() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter admin password: ");
        String password = scanner.nextLine();
        
        if (!admin.login(password)) {
            System.out.println("Invalid password!");
            return;
        }
        
        boolean back = false;
        while (!back) {
            System.out.println("\n================================================");
            System.out.println("               ADMIN SECTION");
            System.out.println("================================================");
            System.out.println(" 1. Add Food Item");
            System.out.println(" 2. Update Food Item");
            System.out.println(" 3. Delete Food Item");
            System.out.println(" 4. View All Orders");
            System.out.println(" 5. View Total Sales");
            System.out.println(" 6. Sales Analysis");
            System.out.println(" 7. View Table Status");
            System.out.println(" 8. Back to Main Menu");
            System.out.println("================================================");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addFoodItem();
                    break;
                    
                case 2:
                    updateFoodItem();
                    break;
                    
                case 3:
                    deleteFoodItem();
                    break;
                    
                case 4:
                    fileManager.viewAllOrders();
                    break;
                    
                case 5:
                    viewTotalSales();
                    break;
                    
                case 6:
                    salesAnalysis();
                    break;
                    
                case 7:
                    viewTableStatus();
                    break;
                    
                case 8:
                    back = true;
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private void addFoodItem() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n================================================");
        System.out.println("               ADD FOOD ITEM");
        System.out.println("================================================");
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Enter category (Starter/Main Course/South Indian/Dessert/Beverage/Special): ");
        String category = scanner.nextLine();
        
        System.out.print("Enter type (Veg/Non-Veg): ");
        String type = scanner.nextLine();
        
        System.out.print("Is this today's special? (y/n): ");
        String special = scanner.nextLine();
        boolean isSpecial = special.equalsIgnoreCase("y");
        
        int id = (int)(Math.random() * 900) + 100;
        
        FoodItem item = new FoodItem(id, name, price, category, type, isSpecial);
        admin.addFoodItem(item);
    }
    
    private void updateFoodItem() {
        Scanner scanner = new Scanner(System.in);
        menu.displayMenu();
        
        System.out.print("\nEnter item ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        FoodItem item = menu.getItemById(id);
        if (item == null) {
            System.out.println("Item not found!");
            return;
        }
        
        System.out.print("Enter new name (press Enter to keep current): ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            name = item.getName();
        }
        
        System.out.print("Enter new price (press Enter to keep current): ");
        String priceInput = scanner.nextLine();
        double price = item.getPrice();
        if (!priceInput.isEmpty()) {
            price = Double.parseDouble(priceInput);
        }
        
        if (admin.updateFoodItem(id, name, price)) {
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Update failed!");
        }
    }
    
    private void deleteFoodItem() {
        Scanner scanner = new Scanner(System.in);
        menu.displayMenu();
        
        System.out.print("\nEnter item ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (admin.deleteFoodItem(id)) {
            System.out.println("Item deleted successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }
    
    private void viewTotalSales() {
        System.out.println("\n================================================");
        System.out.println("               TOTAL SALES");
        System.out.println("================================================");
        System.out.printf("Total Sales: Rs.%.2f%n", totalSales);
        System.out.printf("Total Orders: %d%n", orderHistory.size());
        if (orderHistory.size() > 0) {
            System.out.printf("Average Order Value: Rs.%.2f%n", totalSales / orderHistory.size());
        }
        System.out.println("================================================");
    }
    
    private void salesAnalysis() {
        System.out.println("\n================================================");
        System.out.println("              SALES ANALYSIS");
        System.out.println("================================================");
        
        System.out.printf("Total Sales: Rs.%.2f%n", totalSales);
        System.out.printf("Total Orders: %d%n", orderHistory.size());
        
        if (orderHistory.size() > 0) {
            System.out.printf("Average Order Value: Rs.%.2f%n", totalSales / orderHistory.size());
            
            System.out.println("\nMost Popular Items:");
            System.out.println("------------------------------------------------");
            
            int vegCount = 0, nonVegCount = 0;
            for (Order order : orderHistory) {
                for (FoodItem item : order.getItems()) {
                    if (item.getType().equals("Veg")) {
                        vegCount++;
                    } else {
                        nonVegCount++;
                    }
                }
            }
            
            System.out.println("Veg Items Ordered: " + vegCount + " times");
            System.out.println("Non-Veg Items Ordered: " + nonVegCount + " times");
            
            double totalRating = 0;
            int ratingCount = 0;
            for (Order order : orderHistory) {
                if (order.getCustomerRating() > 0) {
                    totalRating += order.getCustomerRating();
                    ratingCount++;
                }
            }
            if (ratingCount > 0) {
                System.out.printf("Average Customer Rating: %.1f/5%n", totalRating / ratingCount);
            }
        }
        System.out.println("================================================");
    }
    
    private void viewTableStatus() {
        System.out.println("\n================================================");
        System.out.println("               TABLE STATUS");
        System.out.println("================================================");
        System.out.printf("%-12s %-12s %-20s %-15s%n", "Table No", "Capacity", "Status", "Booked By");
        System.out.println("------------------------------------------------");
        
        for (Table table : tables) {
            if (table.isBooked()) {
                System.out.printf("%-12d %-12d Booked     %-15s%n", 
                                 table.getTableNumber(), 
                                 table.getCapacity(), 
                                 table.getBookedBy());
            } else {
                System.out.printf("%-12d %-12d Available  %-15s%n", 
                                 table.getTableNumber(), 
                                 table.getCapacity(), 
                                 "-");
            }
        }
        System.out.println("================================================");
    }
}