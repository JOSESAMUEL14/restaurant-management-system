package admin;

import service.Menu;
import model.FoodItem;

public class Admin {
    private Menu menu;
    private final String PASSWORD = "admin123";
    
    public Admin(Menu menu) {
        this.menu = menu;
    }
    
    public boolean login(String password) {
        return this.PASSWORD.equals(password);
    }
    
    public void addFoodItem(FoodItem item) {
        menu.addFoodItem(item);
    }
    
    public boolean updateFoodItem(int id, String newName, double newPrice) {
        return menu.updateFoodItem(id, newName, newPrice);
    }
    
    public boolean deleteFoodItem(int id) {
        return menu.deleteFoodItem(id);
    }
}