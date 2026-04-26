package lld;

import lld.patterns.decorator.HouseBlend;
import lld.patterns.decorator.Latte;
import lld.patterns.decorator.Mocha;
import lld.patterns.decorator.Beverage;

public class Main {
    public static void main(String[] args) {

        Beverage houseBlend = new HouseBlend();
        Beverage houseBlendWithLatte = new Latte(houseBlend);
        Beverage houseBlendWithLatteAndMocha = new Mocha(houseBlendWithLatte);

        System.out.println(houseBlend.getCost());
        System.out.println(houseBlendWithLatte.getCost());
        System.out.println(houseBlendWithLatteAndMocha.getCost());

        System.out.println(houseBlend.getDescription());
        System.out.println(houseBlendWithLatte.getDescription());
        System.out.println(houseBlendWithLatteAndMocha.getDescription());
    }
}
