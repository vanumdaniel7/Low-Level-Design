package lld.patterns.factory;

public abstract class NotificationService {

    public abstract Notification createNotification();

    public void send(String type) {
        Notification notification = createNotification();
        notification.send();
    }
}
