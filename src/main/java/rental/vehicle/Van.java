package rental.vehicle;

public class Van extends Vehicle {
    public Van(String id, String model) {
        super(id, model, 12.0, 90.0);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.VAN;
    }
}
