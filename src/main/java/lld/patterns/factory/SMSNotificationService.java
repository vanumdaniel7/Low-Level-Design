package lld.patterns.factory;

public class SMSNotificationService extends NotificationService {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
