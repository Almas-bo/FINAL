package rental.service;

import rental.order.RentalOrder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class BookingService {
    private final Map<String, RentalOrder> activeOrders = new LinkedHashMap<>();

    public void save(RentalOrder order) {
        activeOrders.put(order.getOrderId(), order);
    }

    public Optional<RentalOrder> close(String orderId) {
        return Optional.ofNullable(activeOrders.remove(orderId));
    }

    public int activeCount() {
        return activeOrders.size();
    }
}