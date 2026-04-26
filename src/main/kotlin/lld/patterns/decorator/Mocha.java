package lld.patterns.decorator;

public class Mocha extends BeverageDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        return super.getCost() + 2;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", Mocha";
    }
}
