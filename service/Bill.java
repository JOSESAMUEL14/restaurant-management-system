package service;

import model.FoodItem;
import model.Order;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Bill {
    
    public void generateBill(Order order) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                    FOOD HAVEN RESTAURANT");
        System.out.println("                         TAX INVOICE");
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("Order #: " + order.getOrderNumber());
        System.out.println("Date: " + sdf.format(order.getOrderDate()));
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Phone: " + order.getCustomer().getPhoneNumber());
        System.out.println("Order Type: " + order.getCustomer().getOrderType());
        System.out.println("Table: " + order.getTableNumber());
        System.out.println("Status: " + order.getCurrentStatus());
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.printf("%-25s %-8s %-12s %-12s%n", "Item", "Qty", "Price", "Total");
        System.out.println("───────────────────────────────────────────────────────────────");
        
        ArrayList<FoodItem> items = order.getItems();
        ArrayList<Integer> quantities = order.getQuantities();
        
        for (int i = 0; i < items.size(); i++) {
            FoodItem item = items.get(i);
            int qty = quantities.get(i);
            double total = item.getPrice() * qty;
            System.out.printf("%-25s %-8d ₹%-11.2f ₹%-12.2f%n", 
                             item.getName(), qty, item.getPrice(), total);
        }
        
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.printf("Subtotal: ₹%.2f%n", order.getTotalAmount());
        if (order.getComboDiscount() > 0) {
            System.out.printf("Combo Discount: -₹%.2f%n", order.getComboDiscount());
        }
        if (order.getDiscount() > 0) {
            System.out.printf("Special Discount: -₹%.2f%n", order.getDiscount());
        }
        System.out.printf("GST (18%%): ₹%.2f%n", order.getGst());
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.printf("GRAND TOTAL: ₹%.2f%n", order.getGrandTotal());
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("Payment Method: " + order.getPaymentMethod());
        System.out.println("Estimated Time: " + order.getEstimatedTime());
        System.out.println("Special Instructions: " + (order.getSpecialInstructions().isEmpty() ? "None" : order.getSpecialInstructions()));
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("    Thank you for dining with us! 🍽️");
        System.out.println("    Please rate us (1-5 stars) ⭐");
        System.out.println("    Visit again! ❤️");
        System.out.println("═══════════════════════════════════════════════════════════════");
    }
}