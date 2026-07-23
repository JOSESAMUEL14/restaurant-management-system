package service;

import model.Order;
import model.FoodItem;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE_NAME = "orders.txt";
    
    public void saveOrder(Order order) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            out.println("═══════════════════════════════════════════════════════════════");
            out.println("=== ORDER #" + order.getOrderNumber() + " ===");
            out.println("Date: " + sdf.format(order.getOrderDate()));
            out.println("Customer: " + order.getCustomer().getName());
            out.println("Phone: " + order.getCustomer().getPhoneNumber());
            out.println("Order Type: " + order.getCustomer().getOrderType());
            out.println("Table: " + order.getTableNumber());
            out.println("Status: " + order.getCurrentStatus());
            out.println("Items:");
            
            ArrayList<FoodItem> items = order.getItems();
            ArrayList<Integer> quantities = order.getQuantities();
            for (int i = 0; i < items.size(); i++) {
                out.println("  " + items.get(i).getName() + " x" + quantities.get(i) + 
                           " = ₹" + (items.get(i).getPrice() * quantities.get(i)));
            }
            
            out.println("Subtotal: ₹" + order.getTotalAmount());
            out.println("Combo Discount: ₹" + order.getComboDiscount());
            out.println("Special Discount: ₹" + order.getDiscount());
            out.println("GST: ₹" + order.getGst());
            out.println("Grand Total: ₹" + order.getGrandTotal());
            out.println("Payment: " + order.getPaymentMethod());
            out.println("Rating: " + order.getCustomerRating() + " stars");
            out.println("Special Instructions: " + order.getSpecialInstructions());
            out.println("═══════════════════════════════════════════════════════════════\n");
            
            System.out.println("✅ Order saved successfully!");
            
        } catch (IOException e) {
            System.out.println("❌ Error saving order: " + e.getMessage());
        }
    }
    
    public void viewAllOrders() {
        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            System.out.println("\n═══════════════════════════════════════════════════════════════");
            System.out.println("                    ORDER HISTORY");
            System.out.println("═══════════════════════════════════════════════════════════════");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("📭 No orders found. Order history is empty.");
        } catch (IOException e) {
            System.out.println("❌ Error reading orders: " + e.getMessage());
        }
    }
}