package rental.order;

import rental.pricing.PricingStrategy;
import rental.vehicle.Vehicle;

public final class RentalOrder {
    private final String orderId;
    private final String customerName;
    private final Vehicle vehicle;
    private final String pickupLocation;
    private final long hours;
    private final PricingStrategy pricingStrategy;
    private final double totalPrice;

    RentalOrder(String orderId, String customerName, Vehicle vehicle, String pickupLocation,
                long hours, PricingStrategy pricingStrategy, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.hours = hours;
        this.pricingStrategy = pricingStrategy;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public Vehicle getVehicle() { return vehicle; }
    public String getPickupLocation() { return pickupLocation; }
    public long getHours() { return hours; }
    public PricingStrategy getPricingStrategy() { return pricingStrategy; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return String.format("Order %s | %s | %s | pickup: %s | %d h (%s) | total: %.2f",
                orderId, customerName, vehicle, pickupLocation, hours,
                pricingStrategy.getName(), totalPrice);
    }
}