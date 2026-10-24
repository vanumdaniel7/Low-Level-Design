package lld.examples.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    @Override
    public boolean pay(int amount) {
        System.out.println("Paying " + amount + " with credit card");
        return true;
    }
}
