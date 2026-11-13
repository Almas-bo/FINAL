package rental;

import rental.facade.RentalFacade;
import rental.order.RentalOrder;
import rental.pricing.DailyPricingStrategy;
import rental.pricing.HourlyPricingStrategy;
import rental.vehicle.VehicleType;

public class FacadeTest {
    public static void main(String[] args) {
        RentalFacade rental = new RentalFacade();
        rental.addToFleet(VehicleType.CAR, "C-001", "Toyota Camry");
        rental.addToFleet(VehicleType.CAR, "C-002", "Kia K5");

        RentalOrder o1 = rental.rentVehicle("Yersultan", VehicleType.CAR, "Astana Airport",
                5, new HourlyPricingStrategy());
        System.out.println(o1);

        RentalOrder o2 = rental.rentVehicle("Aibek", VehicleType.CAR, "Khan Shatyr",
                48, new DailyPricingStrategy());
        System.out.println(o2);
        System.out.println("Active rentals: " + rental.activeRentals());

        try {
            rental.rentVehicle("Dana", VehicleType.CAR, "Center", 2, new HourlyPricingStrategy());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        rental.returnVehicle(o1.getOrderId());
        System.out.println("Active rentals after return: " + rental.activeRentals());
    }
}