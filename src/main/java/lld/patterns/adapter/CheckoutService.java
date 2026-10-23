package lld.patterns.adapter;

public class CheckoutService {
    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(int amount, String currency) {
        System.out.println("Checkout: Processing order for $" + amount + " " + currency);
        paymentProcessor.processPayment(amount, currency);
        if (paymentProcessor.isPaymentSuccessful()) {
            System.out.println("Checkout: Order successful! Txn: "
                    + paymentProcessor.getTransactionId());
        } else {
            System.out.println("Checkout: Order failed.");
        }
    }

    static void main(String[] args) {
        int amount = 5000;
        String currency = "INR";

        PaymentProcessor legacyGatewayAdapter = new LegacyGatewayAdapter();
        CheckoutService checkoutService = new CheckoutService(legacyGatewayAdapter);

        checkoutService.checkout(amount, currency);
    }
}
