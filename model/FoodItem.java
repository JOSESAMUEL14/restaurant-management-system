package model;

public class FoodItem {
    private int id;
    private String name;
    private double price;
    private String category;
    private String type;
    private boolean isSpecial;
    private double discountPercentage;
    private String imageUrl; // Added field for image URL
    
    public FoodItem(int id, String name, double price, String category, String type, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.type = type;
        this.imageUrl = imageUrl;
        this.isSpecial = false;
        this.discountPercentage = 0;
    }
    
    public FoodItem(int id, String name, double price, String category, String type, boolean isSpecial, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.type = type;
        this.isSpecial = isSpecial;
        this.discountPercentage = 0;
        this.imageUrl = imageUrl;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getType() { return type; }
    public boolean isSpecial() { return isSpecial; }
    public double getDiscountPercentage() { return discountPercentage; }
    public String getImageUrl() { return imageUrl; }
    
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setSpecial(boolean isSpecial) { this.isSpecial = isSpecial; }
    public void setDiscountPercentage(double discountPercentage) { this.discountPercentage = discountPercentage; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public double getDiscountedPrice() {
        return price - (price * discountPercentage / 100);
    }
    
    public void displayItem() {
        String specialTag = isSpecial ? " ★" : "";
        String discountTag = discountPercentage > 0 ? " (" + (int)discountPercentage + "% OFF)" : "";
        System.out.printf("%-6d %-25s %-15s %-10s ₹%-9.2f%s%s%n", 
                         id, name, category, type, price, discountTag, specialTag);
    }
    
    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + category + "," + type + "," + isSpecial + "," + discountPercentage + "," + imageUrl;
    }
}
