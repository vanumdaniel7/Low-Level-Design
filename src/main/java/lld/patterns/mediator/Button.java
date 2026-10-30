package lld.patterns.mediator;

public class Button extends UIComponent {

    private boolean isEnabled;

    public Button(UIMediator uiMediator, boolean isEnabled) {
        super(uiMediator);
        this.isEnabled = isEnabled;
    }

    public void click() {
        if (isEnabled) {
            System.out.println("Login Button clicked!");
            notifyMediator();
        } else {
            System.out.println("Login Button is disabled.");
        }
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}
