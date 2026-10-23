package lld.patterns.adapter;

public class LegacyGatewayAdapter implements PaymentProcessor {

    private LegacyPaymentGateway legacyPaymentGateway;
    private long transactionReference;

    @Override
    public void processPayment(int amount, String currency) {
        this.legacyPaymentGateway.executeTransaction(amount, currency);
        this.transactionReference = legacyPaymentGateway.getReferenceNumber();
    }

    @Override
    public boolean isPaymentSuccessful() {
        return legacyPaymentGateway.checkStatus(transactionReference);
    }

    @Override
    public String getTransactionId() {
        return String.valueOf(transactionReference);
    }
}
