package lld.patterns.singleton;

public class StaticBlockSingleton {
    private int value = 24;
    private static StaticBlockSingleton INSTANCE;

    private StaticBlockSingleton() {

    }

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception exception) {
            System.out.println("An unknown exception occured " + exception);
        }
    }
}
