import java.util.Scanner;
import service.Restaurant;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        
        System.out.println("================================================");
        System.out.println("       WELCOME TO FOOD HAVEN RESTAURANT");
        System.out.println("================================================");
        System.out.println("     Where Every Meal Tells a Story");
        System.out.println("================================================");
        
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n================================================");
            System.out.println("                  MAIN MENU");
            System.out.println("================================================");
            System.out.println(" 1. Customer Section");
            System.out.println(" 2. Admin Section");
            System.out.println(" 3. Exit");
            System.out.println("================================================");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    restaurant.customerSection();
                    break;
                case 2:
                    restaurant.adminSection();
                    break;
                case 3:
                    System.out.println("\n================================================");
                    System.out.println("   Thank you for visiting Food Haven Restaurant!");
                    System.out.println("        We hope to serve you again soon!");
                    System.out.println("================================================");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}