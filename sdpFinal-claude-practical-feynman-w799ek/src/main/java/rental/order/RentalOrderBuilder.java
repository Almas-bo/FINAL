package rental.order;

import rental.pricing.HourlyPricingStrategy;
import rental.pricing.PriceCalculator;
import rental.pricing.PricingStrategy;
import rental.vehicle.Vehicle;

import java.util.concurrent.atomic.AtomicInteger;

public class RentalOrderBuilder {
    private static final AtomicInteger SEQUENCE = new AtomicInteger(1000);

    private String customerName;
    private Vehicle vehicle;
    private String pickupLocation;
    private long hours;
    private PricingStrategy pricingStrategy = new HourlyPricingStrategy();

    public RentalOrderBuilder customer(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public RentalOrderBuilder vehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public RentalOrderBuilder pickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
        return this;
    }

    public RentalOrderBuilder hours(long hours) {
        this.hours = hours;
        return this;
    }

    public RentalOrderBuilder days(long days) {
        this.hours = days * 24;
        return this;
    }

    public RentalOrderBuilder pricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        return this;
    }

    public RentalOrder build() {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalStateException("Customer name is required");
        }
        if (vehicle == null) {
            throw new IllegalStateException("Vehicle is required");
        }
        if (pickupLocation == null || pickupLocation.isBlank()) {
            throw new IllegalStateException("Pickup location is required");
        }
        if (hours <= 0) {
            throw new IllegalStateException("Rental duration must be positive");
        }
        if (pricingStrategy == null) {
            throw new IllegalStateException("Pricing strategy is required");
        }

        double price = new PriceCalculator(pricingStrategy).calculate(vehicle, hours);
        String id = "ORD-" + SEQUENCE.incrementAndGet();
        return new RentalOrder(id, customerName, vehicle, pickupLocation, hours, pricingStrategy, price);
    }
}