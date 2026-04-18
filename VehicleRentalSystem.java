import java.util.Scanner;
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============================");
        System.out.println("   Welcome to Rent-A-Ride!   ");
        System.out.println("==============================");
        System.out.print("\nEnter your name  : ");
        String name = scanner.nextLine();
        System.out.print("Enter your phone : ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, phone);
        System.out.println("\nHello, " + customer.getName() + "! Let's find you a vehicle.");
        System.out.println("\n--- Choose Vehicle Type ---");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        Vehicle vehicle;

        switch (choice) {
            case 1:
                vehicle = new Car("Mercedes CLA250", 50.0);
                break;
            case 2:
                vehicle = new Bike("YAMAHA R15M", 25.0);
                break;
            case 3:
                vehicle = new Truck("Ford F-150", 80.0);
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Car.");
                vehicle = new Car("Toyota Corolla", 40.0);
        }
        System.out.println("\n--- Vehicle Details ---");
        vehicle.showInfo();
        System.out.print("\nHow many days do you want to rent? ");
        int days = Integer.parseInt(scanner.nextLine());
        if (days <= 0) {
            System.out.println("Invalid days! Setting to 1 day.");
            days = 1;
        }
        double totalCost = vehicle.calculateCost(days);
        System.out.println("\n==============================");
        System.out.println("        RENTAL SUMMARY        ");
        System.out.println("==============================");
        System.out.println("Customer : " + customer.getName());
        System.out.println("Phone    : " + customer.getPhone());
        System.out.println("Vehicle  : " + vehicle.getName());
        System.out.println("Days     : " + days);
        System.out.println("Rate     : $" + vehicle.getPricePerDay() + "/day");
        System.out.printf("Total    : $%.2f%n", totalCost);
        System.out.println("==============================");
        System.out.println("   Thank you for renting!    ");
        System.out.println("==============================");
        scanner.close();
    }
}
abstract class Vehicle {
    private String name;
    private double pricePerDay;
    public Vehicle(String name, double pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
    }
    public String getName() {
        return name;
    }
    public double getPricePerDay() {
        return pricePerDay;
    }
    public abstract double calculateCost(int days);
    public void showInfo() {
        System.out.println("Vehicle : " + name);
        System.out.println("Price   : $" + pricePerDay + " per day");
    }
}
class Car extends Vehicle {
    public Car(String name, double pricePerDay) {
        super(name, pricePerDay);
    }
    @Override
    public double calculateCost(int days) {
        return getPricePerDay() * days;
    }
    @Override
    public void showInfo() {
        System.out.println("Type    : Car");
        super.showInfo();
    }
}
class Bike extends Vehicle {
    public Bike(String name, double pricePerDay) {
        super(name, pricePerDay);
    }
    @Override
    public double calculateCost(int days) {
        return getPricePerDay() * days * 0.90;
    }
    @Override
    public void showInfo() {
        System.out.println("Type    : Bike");
        super.showInfo();
        System.out.println("Discount: 10% OFF");
    }
}
class Truck extends Vehicle {
    public Truck(String name, double pricePerDay) {
        super(name, pricePerDay);
    }
    @Override
    public double calculateCost(int days) {
        return getPricePerDay() * days * 1.20;
    }
    @Override
    public void showInfo() {
        System.out.println("Type    : Truck");
        super.showInfo();
        System.out.println("Charge  : +20% extra");
    }
}
class Customer {
    private String name;
    private String phone;
    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
}