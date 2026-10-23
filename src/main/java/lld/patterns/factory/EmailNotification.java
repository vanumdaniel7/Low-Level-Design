package lld.patterns.factory;

public class EmailNotification implements Notification {
    public void send() {
        System.out.println("Sending email notification...");
    }
}
