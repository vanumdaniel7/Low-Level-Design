package lld.patterns.adapter;

public interface PaymentProcessor {
    void processPayment(int amount, String currency);
    boolean isPaymentSuccessful();
    String getTransactionId();
}
