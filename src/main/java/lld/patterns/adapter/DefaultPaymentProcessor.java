package lld.patterns.adapter;

public class DefaultPaymentProcessor implements PaymentProcessor {

    private String transactionId;
    private boolean paymentSuccessful;

    @Override
    public void processPayment(int amount, String currency) {
        System.out.println("DefaultPaymentProcessor::processPayment(" + amount + ", " + currency + ")");
        paymentSuccessful = true;
        transactionId = amount + currency;
    }

    @Override
    public boolean isPaymentSuccessful() {
        return paymentSuccessful;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }
}
