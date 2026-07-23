package model;

public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isBooked;
    private String bookedBy;
    private String bookingTime;
    private String customerPhone;
    
    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isBooked = false;
        this.bookedBy = "";
        this.bookingTime = "";
        this.customerPhone = "";
    }
    
    public int getTableNumber() {
        return tableNumber;
    }
    
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public boolean isBooked() {
        return isBooked;
    }
    
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    
    public String getBookedBy() {
        return bookedBy;
    }
    
    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }
    
    public String getBookingTime() {
        return bookingTime;
    }
    
    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
    
    public String getCustomerPhone() {
        return customerPhone;
    }
    
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    public void displayTable() {
        String status = isBooked ? "🔴 Booked by " + bookedBy : "🟢 Available";
        System.out.printf("Table %-3d | Capacity: %-2d | %s%n", tableNumber, capacity, status);
    }
}