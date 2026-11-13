package rental.service;

import rental.vehicle.Vehicle;
import rental.vehicle.VehicleType;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class InventoryService {
    private final Map<String, Vehicle> fleet = new LinkedHashMap<>();
    private final Set<String> rentedIds = new HashSet<>();

    public void addVehicle(Vehicle vehicle) {
        fleet.put(vehicle.getId(), vehicle);
    }

    public Optional<Vehicle> findAvailable(VehicleType type) {
        return fleet.values().stream()
                .filter(v -> v.getType() == type && !rentedIds.contains(v.getId()))
                .findFirst();
    }

    public void reserve(Vehicle vehicle) {
        if (!rentedIds.add(vehicle.getId())) {
            throw new IllegalStateException("Vehicle already rented: " + vehicle.getId());
        }
    }

    public void release(Vehicle vehicle) {
        rentedIds.remove(vehicle.getId());
    }
}