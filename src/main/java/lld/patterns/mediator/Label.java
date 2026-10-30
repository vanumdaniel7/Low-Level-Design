package lld.patterns.mediator;

public class Label extends UIComponent {

    private String label;

    public Label(UIMediator uiMediator, String label) {
        super(uiMediator);
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
