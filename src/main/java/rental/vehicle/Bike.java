package rental.vehicle;

public class Bike extends Vehicle {
    public Bike(String id, String model) {
        super(id, model, 2.0, 15.0);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
