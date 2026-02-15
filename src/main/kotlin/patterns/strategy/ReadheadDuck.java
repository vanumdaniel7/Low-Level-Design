package patterns.strategy;

public class ReadheadDuck extends Duck {

    public ReadheadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("ReadheadDuck::display()");
    }
}
