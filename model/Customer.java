package model;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String phoneNumber;
    private String orderType;
    private int loyaltyPoints;
    private ArrayList<String> orderHistory;
    
    public Customer(String name, String phoneNumber, String orderType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orderType = orderType;
        this.loyaltyPoints = 0;
        this.orderHistory = new ArrayList<>();
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getOrderType() { return orderType; }
    public void setOrderType(String orderType) { this.orderType = orderType; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void addLoyaltyPoints(int points) { this.loyaltyPoints += points; }
    public void redeemPoints(int points) { this.loyaltyPoints -= points; }
    public ArrayList<String> getOrderHistory() { return orderHistory; }
    public void addOrderToHistory(String order) { orderHistory.add(order); }
}