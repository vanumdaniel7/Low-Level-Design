package lld.patterns.mediator;

public class TextField extends UIComponent {

    private String text;

    public TextField(UIMediator uiMediator) {
        super(uiMediator);
        this.text = "";
    }

    public void setText(String text) {
        this.text = text;
        notifyMediator();
    }

    public String getText() {
        return this.text;
    }
}
