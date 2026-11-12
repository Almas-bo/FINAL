package rental.pricing;

import rental.vehicle.Vehicle;

public class PriceCalculator {
    private PricingStrategy strategy;

    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public PricingStrategy getStrategy() {
        return strategy;
    }

    public double calculate(Vehicle vehicle, long hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Rental duration must be positive");
        }
        return strategy.calculatePrice(vehicle, hours);
    }
}
