package rental.pricing;

import rental.vehicle.Vehicle;

public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Vehicle vehicle, long hours) {
        return vehicle.getHourlyRate() * hours;
    }

    @Override
    public String getName() {
        return "Hourly";
    }
}
