package lld.examples.strategy;

public class DebitCardPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(int amount) {
        System.out.println("Paying " + amount + " with debit card");
        return true;
    }
}
