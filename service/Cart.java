package service;

import model.FoodItem;
import java.util.ArrayList;

public class Cart {
    private ArrayList<FoodItem> items;
    private ArrayList<Integer> quantities;
    
    public Cart() {
        items = new ArrayList<>();
        quantities = new ArrayList<>();
    }
    
    public void addItem(FoodItem item, int quantity) {
        int index = items.indexOf(item);
        if (index != -1) {
            int newQuantity = quantities.get(index) + quantity;
            quantities.set(index, newQuantity);
            System.out.println("🔄 Updated quantity for " + item.getName() + " to " + newQuantity);
        } else {
            items.add(item);
            quantities.add(quantity);
            System.out.println("✅ Added " + quantity + " x " + item.getName() + " to cart");
        }
    }
    
    public void updateQuantity(int itemId, int newQuantity) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == itemId) {
                if (newQuantity <= 0) {
                    removeItem(itemId);
                    return;
                }
                quantities.set(i, newQuantity);
                System.out.println("✅ Quantity updated successfully!");
                return;
            }
        }
        System.out.println("❌ Item not found in cart!");
    }
    
    public void removeItem(int itemId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == itemId) {
                items.remove(i);
                quantities.remove(i);
                System.out.println("✅ Item removed from cart!");
                return;
            }
        }
        System.out.println("❌ Item not found in cart!");
    }
    
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("\n🛒 Cart is empty!");
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                        YOUR CART");
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.printf("%-25s %-10s %-12s %-12s%n", "Item", "Quantity", "Price", "Total");
        System.out.println("───────────────────────────────────────────────────────────────");
        
        double subtotal = 0;
        for (int i = 0; i < items.size(); i++) {
            FoodItem item = items.get(i);
            int qty = quantities.get(i);
            double total = item.getPrice() * qty;
            subtotal += total;
            System.out.printf("%-25s %-10d ₹%-11.2f ₹%-12.2f%n", 
                             item.getName(), qty, item.getPrice(), total);
        }
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.printf("Subtotal: ₹%.2f%n", subtotal);
        System.out.println("═══════════════════════════════════════════════════════════════");
    }
    
    public void clearCart() {
        items.clear();
        quantities.clear();
        System.out.println("🗑️ Cart cleared successfully!");
    }
    
    public ArrayList<FoodItem> getItems() {
        return items;
    }
    
    public ArrayList<Integer> getQuantities() {
        return quantities;
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public double getSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < items.size(); i++) {
            subtotal += items.get(i).getPrice() * quantities.get(i);
        }
        return subtotal;
    }
}