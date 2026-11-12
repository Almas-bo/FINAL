package rental;

import rental.pricing.DailyPricingStrategy;
import rental.pricing.HourlyPricingStrategy;
import rental.pricing.PriceCalculator;
import rental.vehicle.Vehicle;
import rental.vehicle.VehicleFactory;
import rental.vehicle.VehicleType;

public class Main {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.create(VehicleType.CAR, "C-001", "Toyota Camry");
        Vehicle bike = VehicleFactory.create(VehicleType.BIKE, "B-001", "Trek FX");
        Vehicle van = VehicleFactory.create(VehicleType.VAN, "V-001", "Ford Transit");

        PriceCalculator calculator = new PriceCalculator(new HourlyPricingStrategy());
        long[] durations = {5, 30};

        for (long hours : durations) {
            for (Vehicle vehicle : new Vehicle[] {car, bike, van}) {
                calculator.setStrategy(new HourlyPricingStrategy());
                double hourly = calculator.calculate(vehicle, hours);
                calculator.setStrategy(new DailyPricingStrategy());
                double daily = calculator.calculate(vehicle, hours);
                System.out.printf("%s, %d h -> Hourly: %.2f, Daily: %.2f%n", vehicle, hours, hourly, daily);
            }
        }
    }
}
