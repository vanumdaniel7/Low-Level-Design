package lld.patterns.decorator;

public class HouseBlend implements Beverage {

    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "HouseBlend";
    }
}
