package model;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Order {
    private int orderNumber;
    private Customer customer;
    private ArrayList<FoodItem> items;
    private ArrayList<Integer> quantities;
    private Date orderDate;
    private String status;
    private double totalAmount;
    private double gst;
    private double discount;
    private double comboDiscount;
    private double grandTotal;
    private String paymentMethod;
    private int customerRating;
    private String specialInstructions;
    private String estimatedTime;
    private String tableNumber;
    private String[] statusHistory;
    private int currentStatusIndex;
    
    public Order(int orderNumber, Customer customer) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.orderDate = new Date();
        this.status = "Order Placed";
        this.customerRating = 0;
        this.specialInstructions = "";
        this.estimatedTime = "20-25 minutes";
        this.tableNumber = "Not Assigned";
        this.statusHistory = new String[]{"Order Placed", "Preparing", "Cooking", "Ready", "Delivered"};
        this.currentStatusIndex = 0;
        this.comboDiscount = 0;
    }
    
    public int getOrderNumber() { return orderNumber; }
    public Customer getCustomer() { return customer; }
    public ArrayList<FoodItem> getItems() { return items; }
    public ArrayList<Integer> getQuantities() { return quantities; }
    public Date getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public double getGst() { return gst; }
    public void setGst(double gst) { this.gst = gst; }
    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }
    public double getComboDiscount() { return comboDiscount; }
    public void setComboDiscount(double comboDiscount) { this.comboDiscount = comboDiscount; }
    public double getGrandTotal() { return grandTotal; }
    public void setGrandTotal(double grandTotal) { this.grandTotal = grandTotal; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public int getCustomerRating() { return customerRating; }
    public void setCustomerRating(int customerRating) { this.customerRating = customerRating; }
    public String getSpecialInstructions() { return specialInstructions; }
    public void setSpecialInstructions(String specialInstructions) { this.specialInstructions = specialInstructions; }
    public String getEstimatedTime() { return estimatedTime; }
    public void setEstimatedTime(String estimatedTime) { this.estimatedTime = estimatedTime; }
    public String getTableNumber() { return tableNumber; }
    public void setTableNumber(String tableNumber) { this.tableNumber = tableNumber; }
    public String getCurrentStatus() { return statusHistory[currentStatusIndex]; }
    public void updateStatus() { if (currentStatusIndex < statusHistory.length - 1) { currentStatusIndex++; } }
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(orderDate);
    }
    
    public void addItem(FoodItem item, int quantity) {
        items.add(item);
        quantities.add(quantity);
    }
    
    public void calculateTotal() {
        totalAmount = 0;
        for (int i = 0; i < items.size(); i++) {
            totalAmount += items.get(i).getPrice() * quantities.get(i);
        }
        
        // Apply combo discount
        applyComboDiscount();
        
        // Apply special discount
        if (totalAmount > 500) {
            discount = totalAmount * 0.10;
        } else {
            discount = 0;
        }
        
        // Apply daily offer
        applyDailyOffer();
        
        gst = (totalAmount - comboDiscount - discount) * 0.18;
        grandTotal = totalAmount - comboDiscount - discount + gst;
    }
    
    private void applyComboDiscount() {
        int itemCount = items.size();
        if (itemCount >= 4) {
            comboDiscount = totalAmount * 0.20; // 20% off for 4+ items
        } else if (itemCount >= 3) {
            comboDiscount = totalAmount * 0.10; // 10% off for 3 items
        } else {
            comboDiscount = 0;
        }
    }
    
    private void applyDailyOffer() {
        // Monday: 5% off on all items
        // Tuesday: Buy 2 Get 1 Free on Desserts
        // Wednesday: 10% off on South Indian
        // Thursday: 15% off on Main Course
        // Friday: 20% off on Starters
        // Weekend: 10% off on all items
    }
}