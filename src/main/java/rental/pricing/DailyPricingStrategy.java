package rental.pricing;

import rental.vehicle.Vehicle;

public class DailyPricingStrategy implements PricingStrategy {
    private static final long HOURS_IN_DAY = 24;

    @Override
    public double calculatePrice(Vehicle vehicle, long hours) {
        long days = (hours + HOURS_IN_DAY - 1) / HOURS_IN_DAY;
        return vehicle.getDailyRate() * days;
    }

    @Override
    public String getName() {
        return "Daily";
    }
}
