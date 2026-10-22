package lld.patterns.singleton;

public class SynchronizedLazySingleton {
    private static SynchronizedLazySingleton INSTANCE;

    private SynchronizedLazySingleton() {

    }

    public static synchronized SynchronizedLazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SynchronizedLazySingleton();
        }

        return INSTANCE;
    }
}
