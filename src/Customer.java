import java.util.ArrayList;

public class Customer {
    String name;
    float money;
    ArrayList<Vehicle> vehicles;


    public Customer(String name, float money, ArrayList<Vehicle> vehicles) {
        this.name = name;
        this.money = money;
        this.vehicles = vehicles;
    }
}
