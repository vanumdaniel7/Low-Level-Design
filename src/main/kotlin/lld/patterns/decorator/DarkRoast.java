package lld.patterns.decorator;

public class DarkRoast implements Beverage {
    @Override
    public int getCost() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Dark Roast";
    }
}
