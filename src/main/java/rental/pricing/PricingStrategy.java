package rental.pricing;

import rental.vehicle.Vehicle;

public interface PricingStrategy {
    double calculatePrice(Vehicle vehicle, long hours);

    String getName();
}
