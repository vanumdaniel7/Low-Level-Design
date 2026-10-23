package lld.patterns.factory;

public class SMSNotification implements Notification {
    public void send() {
        System.out.println("Sending SMS notification...");
    }
}
