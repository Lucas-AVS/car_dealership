import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public static void main(String[] args) {
        List<Vehicle> forSaleVehicles = new ArrayList<>();
        forSaleVehicles.add(new Vehicle("BMW", "GT3", 2017, 300000, 1000000));
        forSaleVehicles.add(new Vehicle("Fiat", "Uno", 2005, 8000000, 12000));
        forSaleVehicles.add(new Vehicle("Toyota", "Corolla", 1986, 500000, 90000));

        Employee employeeMark = new Employee("Mark", 0);
        Customer customerJohn = new Customer("John", 100000,  new ArrayList<>());

        SellVehicle("Mustang", forSaleVehicles, employeeMark, customerJohn);
        SellVehicle("GT3", forSaleVehicles, employeeMark, customerJohn);
        SellVehicle("Corolla", forSaleVehicles, employeeMark, customerJohn);
        SellVehicle("Uno", forSaleVehicles, employeeMark, customerJohn);
    }

    public static void SellVehicle(String vehicleModel, List<Vehicle> forSaleVehicles, Employee employee, Customer customer) {

        int index = -1;
        for (int i = 0; i < forSaleVehicles.size(); i++) {
            if (forSaleVehicles.get(i).model.equals(vehicleModel)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("There is no " + vehicleModel + " for sale");
        }
        else {
            Vehicle currentVehicle = forSaleVehicles.get(index);
            if (customer.money <= currentVehicle.price) {
                System.out.println("Customer: " + customer.name + " doesn't have enough money to buy a " + vehicleModel);
            }
            else {
                customer.vehicles.add(currentVehicle);
                customer.money -= currentVehicle.price;

                forSaleVehicles.remove(index);
                employee.numberSales++;

                System.out.println("Successful deal! " + customer.name + "bought a " + currentVehicle.brand +
                        currentVehicle.model + " from " + employee.name + " for:" + currentVehicle.price + "$");
            }
        }

    }
}
