package lld.patterns.decorator;

public class Latte extends BeverageDecorator {
    public Latte(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        return super.getCost() + 1;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", Latte";
    }
}
