package rental.vehicle;

public final class VehicleFactory {
    private VehicleFactory() {
    }

    public static Vehicle create(VehicleType type, String id, String model) {
        if (type == null) {
            throw new IllegalArgumentException("Vehicle type must not be null");
        }
        switch (type) {
            case CAR:
                return new Car(id, model);
            case BIKE:
                return new Bike(id, model);
            case VAN:
                return new Van(id, model);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + type);
        }
    }
}
