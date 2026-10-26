package lld.learnings.concurrency;

public class CustomThread {

    static void main() {
        CustomThreadUsingInheritance customThreadUsingInheritance = new CustomThreadUsingInheritance();
    }

    private class CustomThreadUsingInheritance extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(" 1 ");
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
