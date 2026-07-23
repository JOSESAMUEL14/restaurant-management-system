package service;

import model.FoodItem;
import java.util.ArrayList;

public class Menu {
    private ArrayList<FoodItem> foodItems;
    
    public Menu() {
        foodItems = new ArrayList<>();
        initializeMenu();
    }
    
    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }
    
    private void initializeMenu() {
        // ===== STARTERS =====
        foodItems.add(new FoodItem(101, "Paneer Tikka", 220, "Starter", "Veg"));
        foodItems.add(new FoodItem(102, "Spring Rolls", 180, "Starter", "Veg"));
        foodItems.add(new FoodItem(103, "Mushroom Fry", 200, "Starter", "Veg"));
        foodItems.add(new FoodItem(104, "Hara Bhara Kabab", 190, "Starter", "Veg"));
        foodItems.add(new FoodItem(105, "Veg Seekh Kabab", 210, "Starter", "Veg"));
        foodItems.add(new FoodItem(106, "Chicken Tikka", 280, "Starter", "Non-Veg"));
        foodItems.add(new FoodItem(107, "Fish Fry", 300, "Starter", "Non-Veg"));
        foodItems.add(new FoodItem(108, "Chicken Wings", 260, "Starter", "Non-Veg"));
        foodItems.add(new FoodItem(109, "Mutton Seekh", 320, "Starter", "Non-Veg"));
        foodItems.add(new FoodItem(110, "Prawn Fry", 350, "Starter", "Non-Veg"));
        
        // ===== MAIN COURSE =====
        foodItems.add(new FoodItem(201, "Paneer Butter Masala", 320, "Main Course", "Veg"));
        foodItems.add(new FoodItem(202, "Veg Biryani", 280, "Main Course", "Veg"));
        foodItems.add(new FoodItem(203, "Dal Makhani", 250, "Main Course", "Veg"));
        foodItems.add(new FoodItem(204, "Shahi Paneer", 340, "Main Course", "Veg"));
        foodItems.add(new FoodItem(205, "Malai Kofta", 310, "Main Course", "Veg"));
        foodItems.add(new FoodItem(206, "Chicken Butter Masala", 380, "Main Course", "Non-Veg"));
        foodItems.add(new FoodItem(207, "Mutton Biryani", 420, "Main Course", "Non-Veg"));
        foodItems.add(new FoodItem(208, "Fish Curry", 350, "Main Course", "Non-Veg"));
        foodItems.add(new FoodItem(209, "Chicken Biryani", 360, "Main Course", "Non-Veg"));
        foodItems.add(new FoodItem(210, "Prawn Curry", 400, "Main Course", "Non-Veg"));
        
        // ===== SOUTH INDIAN =====
        foodItems.add(new FoodItem(301, "Plain Idli (2 pcs)", 80, "South Indian", "Veg"));
        foodItems.add(new FoodItem(302, "Rava Idli (2 pcs)", 90, "South Indian", "Veg"));
        foodItems.add(new FoodItem(303, "Kanchi Idli (2 pcs)", 85, "South Indian", "Veg"));
        foodItems.add(new FoodItem(304, "Thatte Idli (2 pcs)", 95, "South Indian", "Veg"));
        foodItems.add(new FoodItem(305, "Mallige Idli (2 pcs)", 100, "South Indian", "Veg"));
        foodItems.add(new FoodItem(306, "Plain Dosa", 100, "South Indian", "Veg"));
        foodItems.add(new FoodItem(307, "Masala Dosa", 120, "South Indian", "Veg"));
        foodItems.add(new FoodItem(308, "Onion Dosa", 110, "South Indian", "Veg"));
        foodItems.add(new FoodItem(309, "Rava Dosa", 130, "South Indian", "Veg"));
        foodItems.add(new FoodItem(310, "Ghee Roast Dosa", 140, "South Indian", "Veg"));
        foodItems.add(new FoodItem(311, "Paper Dosa", 150, "South Indian", "Veg"));
        foodItems.add(new FoodItem(312, "Mysore Masala Dosa", 160, "South Indian", "Veg"));
        foodItems.add(new FoodItem(313, "Podi Dosa", 130, "South Indian", "Veg"));
        foodItems.add(new FoodItem(314, "Cheese Dosa", 170, "South Indian", "Veg"));
        foodItems.add(new FoodItem(315, "Paneer Dosa", 180, "South Indian", "Veg"));
        foodItems.add(new FoodItem(316, "Plain Uttapam", 110, "South Indian", "Veg"));
        foodItems.add(new FoodItem(317, "Onion Uttapam", 120, "South Indian", "Veg"));
        foodItems.add(new FoodItem(318, "Tomato Uttapam", 130, "South Indian", "Veg"));
        foodItems.add(new FoodItem(319, "Mixed Veg Uttapam", 140, "South Indian", "Veg"));
        foodItems.add(new FoodItem(320, "Cheese Uttapam", 160, "South Indian", "Veg"));
        foodItems.add(new FoodItem(321, "Medu Vada (2 pcs)", 90, "South Indian", "Veg"));
        foodItems.add(new FoodItem(322, "Sambar Vada (2 pcs)", 100, "South Indian", "Veg"));
        foodItems.add(new FoodItem(323, "Mysore Bonda (2 pcs)", 95, "South Indian", "Veg"));
        foodItems.add(new FoodItem(324, "Vada Pav", 80, "South Indian", "Veg"));
        foodItems.add(new FoodItem(325, "Lemon Rice", 120, "South Indian", "Veg"));
        foodItems.add(new FoodItem(326, "Tamarind Rice", 120, "South Indian", "Veg"));
        foodItems.add(new FoodItem(327, "Curd Rice", 110, "South Indian", "Veg"));
        foodItems.add(new FoodItem(328, "Coconut Rice", 130, "South Indian", "Veg"));
        foodItems.add(new FoodItem(329, "Mint Rice", 140, "South Indian", "Veg"));
        foodItems.add(new FoodItem(330, "South Indian Thali", 250, "South Indian", "Veg"));
        
        // ===== DESSERTS =====
        foodItems.add(new FoodItem(401, "Gulab Jamun", 120, "Dessert", "Veg"));
        foodItems.add(new FoodItem(402, "Ice Cream", 100, "Dessert", "Veg"));
        foodItems.add(new FoodItem(403, "Brownie", 150, "Dessert", "Veg"));
        foodItems.add(new FoodItem(404, "Payasam", 130, "Dessert", "Veg"));
        foodItems.add(new FoodItem(405, "Rasmalai", 140, "Dessert", "Veg"));
        
        // ===== BEVERAGES =====
        foodItems.add(new FoodItem(501, "Soft Drink", 80, "Beverage", "Veg"));
        foodItems.add(new FoodItem(502, "Fresh Juice", 120, "Beverage", "Veg"));
        foodItems.add(new FoodItem(503, "Coffee", 90, "Beverage", "Veg"));
        foodItems.add(new FoodItem(504, "Tea", 70, "Beverage", "Veg"));
        foodItems.add(new FoodItem(505, "Buttermilk", 60, "Beverage", "Veg"));
        foodItems.add(new FoodItem(506, "Filter Coffee", 100, "Beverage", "Veg"));
        foodItems.add(new FoodItem(507, "Badam Milk", 110, "Beverage", "Veg"));
        
        // ===== TODAY'S SPECIAL =====
        foodItems.add(new FoodItem(601, "Chef's Special Pizza", 450, "Special", "Veg", true));
        foodItems.add(new FoodItem(602, "Grilled Chicken", 500, "Special", "Non-Veg", true));
        foodItems.add(new FoodItem(603, "Special Meal Combo", 350, "Special", "Veg", true));
    }
    
    public void displayMenu() {
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                    FOOD HAVEN RESTAURANT");
        System.out.println("                         COMPLETE MENU");
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.printf("%-6s %-25s %-15s %-10s %-10s%n", "ID", "Item Name", "Category", "Type", "Price");
        System.out.println("───────────────────────────────────────────────────────────────");
        
        for (FoodItem item : foodItems) {
            String specialTag = item.isSpecial() ? " ★" : "";
            String discountTag = item.getDiscountPercentage() > 0 ? " (" + (int)item.getDiscountPercentage() + "% OFF)" : "";
            System.out.printf("%-6d %-25s %-15s %-10s ₹%-9.2f%s%s%n", 
                             item.getId(), 
                             item.getName(), 
                             item.getCategory(), 
                             item.getType(), 
                             item.getPrice(),
                             discountTag,
                             specialTag);
        }
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("★ = Today's Special");
        System.out.println("Total Items: " + foodItems.size());
        System.out.println("═══════════════════════════════════════════════════════════════");
    }
    
    public void displayByCategory(String category) {
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                    " + category.toUpperCase());
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.printf("%-6s %-30s %-12s %-10s%n", "ID", "Item Name", "Type", "Price");
        System.out.println("───────────────────────────────────────────────────────────────");
        
        boolean found = false;
        for (FoodItem item : foodItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.printf("%-6d %-30s %-12s ₹%-9.2f%n", 
                                 item.getId(), 
                                 item.getName(), 
                                 item.getType(), 
                                 item.getPrice());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("                     No items found in this category.");
        }
        System.out.println("───────────────────────────────────────────────────────────────");
    }
    
    public void displaySpecial() {
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                    TODAY'S SPECIAL");
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.printf("%-6s %-30s %-12s %-10s%n", "ID", "Item Name", "Type", "Price");
        System.out.println("───────────────────────────────────────────────────────────────");
        
        boolean found = false;
        for (FoodItem item : foodItems) {
            if (item.isSpecial()) {
                System.out.printf("%-6d %-30s %-12s ₹%-9.2f%n", 
                                 item.getId(), 
                                 item.getName(), 
                                 item.getType(), 
                                 item.getPrice());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("                     No special items today.");
        }
        System.out.println("───────────────────────────────────────────────────────────────");
    }
    
    public FoodItem searchFoodItem(String searchTerm) {
        searchTerm = searchTerm.toLowerCase();
        for (FoodItem item : foodItems) {
            if (item.getName().toLowerCase().contains(searchTerm)) {
                return item;
            }
        }
        return null;
    }
    
    public FoodItem getItemById(int id) {
        for (FoodItem item : foodItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    
    public void addFoodItem(FoodItem item) {
        foodItems.add(item);
        System.out.println("✅ Item added successfully!");
    }
    
    public boolean updateFoodItem(int id, String newName, double newPrice) {
        FoodItem item = getItemById(id);
        if (item != null) {
            item.setName(newName);
            item.setPrice(newPrice);
            return true;
        }
        return false;
    }
    
    public boolean deleteFoodItem(int id) {
        FoodItem item = getItemById(id);
        if (item != null) {
            foodItems.remove(item);
            return true;
        }
        return false;
    }
}