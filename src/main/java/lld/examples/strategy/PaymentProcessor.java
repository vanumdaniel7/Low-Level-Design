package lld.examples.strategy;

public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    boolean processPayment(int amount) {
        return paymentStrategy.pay(amount);
    }
}
