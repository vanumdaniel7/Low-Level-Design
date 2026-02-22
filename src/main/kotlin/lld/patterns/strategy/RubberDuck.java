package lld.patterns.strategy;

public class RubberDuck extends Duck {

    public RubberDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Squeak();
    }

    @Override
    void display() {
        System.out.println("RubberDuck::display()");
    }
}
