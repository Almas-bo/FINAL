package rental.service;

public class PaymentService {
    public void charge(String customer, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        System.out.printf("Payment: %s paid %.2f%n", customer, amount);
    }
}