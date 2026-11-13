package rental.facade;

import rental.order.RentalOrder;
import rental.order.RentalOrderBuilder;
import rental.pricing.PricingStrategy;
import rental.service.BookingService;
import rental.service.InventoryService;
import rental.service.PaymentService;
import rental.vehicle.Vehicle;
import rental.vehicle.VehicleFactory;
import rental.vehicle.VehicleType;

public class RentalFacade {
    private final InventoryService inventory = new InventoryService();
    private final PaymentService payments = new PaymentService();
    private final BookingService bookings = new BookingService();

    public Vehicle addToFleet(VehicleType type, String id, String model) {
        Vehicle vehicle = VehicleFactory.create(type, id, model);
        inventory.addVehicle(vehicle);
        return vehicle;
    }

    public RentalOrder rentVehicle(String customer, VehicleType type, String pickup,
                                   long hours, PricingStrategy strategy) {
        Vehicle vehicle = inventory.findAvailable(type)
                .orElseThrow(() -> new IllegalStateException("No available vehicles of type " + type));

        RentalOrder order = new RentalOrderBuilder()
                .customer(customer)
                .vehicle(vehicle)
                .pickupLocation(pickup)
                .hours(hours)
                .pricingStrategy(strategy)
                .build();

        inventory.reserve(vehicle);
        try {
            payments.charge(customer, order.getTotalPrice());
        } catch (RuntimeException e) {
            inventory.release(vehicle);
            throw e;
        }
        bookings.save(order);
        return order;
    }

    public void returnVehicle(String orderId) {
        RentalOrder order = bookings.close(orderId)
                .orElseThrow(() -> new IllegalArgumentException("No active order: " + orderId));
        inventory.release(order.getVehicle());
    }

    public int activeRentals() {
        return bookings.activeCount();
    }
}