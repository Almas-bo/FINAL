package rental.vehicle;

public abstract class Vehicle {
    private final String id;
    private final String model;
    private final double hourlyRate;
    private final double dailyRate;

    protected Vehicle(String id, String model, double hourlyRate, double dailyRate) {
        this.id = id;
        this.model = model;
        this.hourlyRate = hourlyRate;
        this.dailyRate = dailyRate;
    }

    public abstract VehicleType getType();

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    @Override
    public String toString() {
        return getType() + " " + model + " [" + id + "]";
    }
}
