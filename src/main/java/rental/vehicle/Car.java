package rental.vehicle;

public class Car extends Vehicle {
    public Car(String id, String model) {
        super(id, model, 8.0, 60.0);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
